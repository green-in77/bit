<%@page import="kr.or.bit.dto.Board"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.bit.service.BoardService"%>
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
<%
	BoardService service = BoardService.getinstance();	
	
	//게시물 총 건수		
	int totalboardcount = service.totalboardcount();
	
	//상세보기 후 list 복귀시 현재 페이지 유지하기 위해
	String ps = request.getParameter("ps"); //pagesize
	String cp = request.getParameter("cp"); //current page
	
	if(ps == null || ps.trim().equals("")){
		//default 설정
		ps = "4";
	}
	
	if(cp == null || cp.trim().equals("")){
		//default 설정
		cp = "1";
	}
	
	int pagesize = Integer.parseInt(ps);
	int cpage = Integer.parseInt(cp);
	int pagecount = 0;
	
	if(totalboardcount % pagesize == 0){
		pagecount = totalboardcount / pagesize;
	}else {
		pagecount = (totalboardcount / pagesize) +1;
	}
	
	out.print("pagesize : <h3>" + pagesize + "</h3>");
	out.print("totalboardcount : <h3>" + totalboardcount + "</h3>");
	out.print("cpage : <h3>" + cpage + "</h3>");
	out.print("pagecount : <h3>" + pagecount + "</h3>");
	
	List<Board> list = service.list(cpage, pagesize);
	
		
	//out.print("데이터 건수 : " + list.size());
	//글번호, 제목, 작성자, 날짜, 조회수
%>
	<table border='1'>
		<tr><td>글번호</td><td>제목</td><td>작성자</td><td>작성일</td><td>조회수</td></tr>
		<c:forEach var="board" items="<%=list%>">
			<tr>
				<td>${board.idx}</td><td>${board.subject}</td><td>${board.writer}</td><td>${board.writedate}</td><td>${board.readnum}</td>
			</tr> 
		</c:forEach>
	</table>
</body>
</html>