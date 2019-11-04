<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="common/Admin.jsp"></c:import>

<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("search");
		
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		conn = Singleton_Helper.getConnection("oracle");
		String sql = "select count(*) from KOREAMEMBER where name like ?";
		
		String sql2 = "select id, ip from koreamember where name like ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, '%'+name+'%');
		
		rs = pstmt.executeQuery();
		
		int rowcount=0;
		
		if(rs.next()){
			rowcount = rs.getInt(1); //조회건수
		}
		
		pstmt = conn.prepareStatement(sql2); 
		pstmt.setString(1, '%'+name+'%');
		rs = pstmt.executeQuery();

%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Search</title>
    	
	<c:import url="common/Top.jsp"></c:import>
	
    <div class="d-flex align-items-stretch">
    
    <c:import url="common/Left.jsp"></c:import>
    
      <div class="page-holder w-100 d-flex flex-wrap">
        <div class="container-fluid px-xl-5">
      		
      		<div class="row">
					<div class="col-lg-12 table-padding">
						<div class="card mb-5 mb-lg-0">         
							<div class="card-header">
								<h2 class="h6 mb-0 text-uppercase">Search List</h2>
							</div>
						<div class="card-body">
							<p class="text-gray"></p>
							<c:set var = "rowcount" value="<%=rowcount%>"/>
							<c:choose>
								<c:when test="${rowcount > 0}">
									[${param.search}] 조회결과는 ${rowcount}건 입니다.	
																
									<c:forEach var="data" begin="1" end="${rowcount}">
										<% rs.next();%>
										<c:set var="id" value='<%=rs.getString("id")%>' />
										<c:set var="ip" value='<%=rs.getString("ip")%>' />
										
										<!-- 회원리스트 1줄 -->
				                    	<div class="d-flex justify-content-between align-items-start align-items-sm-center mb-4 flex-column flex-sm-row">
				                      		<div class="left d-flex align-items-center">
				                        		<div class="icon icon-lg shadow mr-3 text-gray"><i class="fab fa-android"></i></div>
				                        			<div class="text">
				                          				<h6 class="mb-0 d-flex align-items-center">
															<span><a href='memberDetail.jsp?id=${id}'>${id}</span>
														</h6>
														<small class="text-gray">${ip}</small>
													</div>
												</div>
												<div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-violet">
													<a href='memberEdit.jsp?id=${id}'><span>수정</span></a>
													<a href='memberDelete.jsp?id=${id}'><span>삭제</span></a>
												</div>
										</div>
				                    	<!-- 회원리스트 1줄 -->
									</c:forEach>
								</c:when>
								
								<c:otherwise>
									[${param.search}] 조회결과가 없습니다.
								</c:otherwise>
							</c:choose>								
 
						</div>
                	</div>
              	</div>           
            </div> 

        </div>
        
        <c:import url="common/Bottom.jsp"></c:import>
        			                    	
<%
	} catch(Exception e){
		System.out.println("Search : " + e.getMessage());
						
	} finally{
		Singleton_Helper.close(rs);
		Singleton_Helper.close(pstmt);
	}
%>	 
        