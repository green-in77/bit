<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.service.boardservice"%>
<%@page import="kr.or.kosta.dto.board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
        <link rel="Stylesheet" href="<%=request.getContextPath()%>/style/default.css" />
</head>
<body>
    
     <c:import url="/include/header.jsp" />
     <!-- include -->
     
     <c:set var="boardlist" value="<%=boardservice.getInstance() %>"/>
     <!-- boardlist 에 boardservice 의 주소값 할당 -->
     <c:set var="totalboardcount" value="${boardlist.totalboardcount() }"/>
     <!--  -->
 
     
     
     <c:if test="${empty param.ps }">
         <c:set var="pagesize" value="5" />
     </c:if>
     
     <c:if test="${!empty param.ps }">
         <c:set var="pagesize" value="${param.ps }" />
     </c:if>
     
     <c:if test="${empty param.cp }">
         <c:set var="cpage" value="1" />
     </c:if>
     
     <c:if test="${!empty param.cp }">
         <c:set var="cpage" value="${param.cp }" />
     </c:if>
     
     <c:set var="list" value="${boardlist.list(cpage,pagesize ) }"/>
      
     <c:if test="${totalboardcount % pagesize == 0 }">
         <c:set var="pagecount" value="${totalboardcount } / ${pagesize }"/>
         
     </c:if>
     
     <c:if test="${totalboardcount % pagesize != 0 }">
         <c:set var="pagecount" value="${totalboardcount / pagesize + 1 }"/>
     </c:if>
         
     <div id="pageContainer">
         <table width="80%" border="1" cellspacing="0" align="center" >
             <tr>
                 <td>순번</td>
                 <td>제목</td>           
                 <td>글쓴이</td>
                 <td>날짜</td>
                 <td>조회수</td>
             </tr>
 
             
             <c:forEach var="board" items="${list  }">
             
                 <c:set var="idx" value="${board.getIdx()}"/>
                 <c:set var="subject" value="${board.getSubject()}"/>
                 
                 <c:if test="${subject != null && fn:length(subject) > 15}">                 
                     <c:set var="subject" value="${fn:substring(subject, 0, 15) }" />         
                     <c:set var="subject" value="${subject}...." />        
                     
                 </c:if>
                 
                 <c:set var="writer" value="${board.getWriter()}"/>
                 
                 <c:if test="${writer != null && fn:length(writer) > 4}">                 
                     <c:set var="writer" value="${fn:substring(writer, 0, 4) }" />     
                     <c:set var="writer" value="${writer}...." />            
                     
                 </c:if>
                 
                 <c:set var="writedate" value="${board.getWritedate().toString()}"/>
                 <c:set var="readnum" value="${board.getReadnum()}"/>
             
             <tr onmouseover="this.style.backgroundColor='gold'" 
                         onmouseout="this.style.backgroundColor='white'">
                 
                     <td>${idx }</td>
                     <td>
                     
                         <c:set var="depth" value="${board.getDepth() }"/>
                         
                         <c:forEach var="i" begin="0" end="${depth }" step="1">
                             &nbsp;&nbsp;&nbsp;
                         </c:forEach> 
                         
                         <c:if test="${depth > 0 }">
                             <img src='../images/re.gif'/>
                         </c:if>
                         
                         <a href='board_content.jsp?idx=${idx}&cp=${cpage }&ps=${pagesize}'>
                             ${subject }
                         </a>
                     </td>
                     <td>${writer }</td>
                     <td>${writedate }</td>
                     <td>${readnum }</td>
                 </tr>
             </c:forEach>
     
             <tr>
                 <td colspan="4"    align="center">
                 
                     <c:if test="${cpage > 1 }">
                         <a href='board_list.jsp?cp=${cpage-1}&ps=${pagesize}'>[이전]</a>
                     </c:if>            
                                 
                      <c:forEach var="i" begin="1" end="${pagecount }" step="1">
                          <c:if test="${i == cpage }">
                             <font color='red'>[${i }]</font>
                         </c:if>
                         <c:if test="${i != cpage }">
                             <a href='board_list.jsp?cp=${i }&ps=${pagesize}'>[${i }]</a>
                         </c:if>
                     </c:forEach> 
                     
                     <c:if test="${cpage > 1 }">
                         <a href='board_list.jsp?cp=${cpage+1}&ps=${pagesize}'>[다음]</a>
                     </c:if>
                 </td>        
                 <td colspan="1"    align="center">
                         
                             총 게시물 : 
                             ${totalboardcount }
                 </td>
             </tr>
         </table>
     
     </div>
     
</body>
</html>