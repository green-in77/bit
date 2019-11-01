<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
/*
	1. 관리자만 접근 가능한 PAGE
	2. 로그인한 일반 회원이 주소값을 외워서 접근불가
	3. 회원에 관련된 모든 페이지 상단에 걸어야 하나.... : include : ssessionCheck.jsp
*/	
	//2. 일반회원 접근불가
	if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")){ //값이 없거나, admin이 아니면
		//강제로 페이지 이동
		response.sendRedirect("Ex02_JDBC_Main.jsp");
	}

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}

tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}

td {
	border: solid 1px red;
}
</style>
</head>
<body>
	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px">
				<jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
			<!--
				회원목록(리스트) 출력
				목록 (select id,ip from koreamember)
			-->	
			<%
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					conn = Singleton_Helper.getConnection("oracle");
					String sql = "select id,ip from koreamember";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
			%>
				<Table style="width: 400px; height: 100px; margin-left: auto; margin-right: auto; text-align: center;">
					<tr>
						<th colspan="4">회원리스트</th>
					</tr>
					<tr>
						<td width="100px">ID</td>
						<td width="100px">IP</td>
						<td colspan="2">회원관리</td>
					</tr>
			<%
					while(rs.next()){
			%>
						<tr>
							<td><a href='Ex03_MemberDetail.jsp?id=<%=rs.getString("id")%>'><%= rs.getString("id") %></a></td>
									<!-- 링크타고 넘어가는건 무조건 GET 방식으로 현재 click 한 아이디의 값을 가지고 넘어감.. -->
							<td><%= rs.getString("ip") %></td>
							<td><a href='Ex03_MemberDelete.jsp?id=<%=rs.getString("id")%>'>[삭제]</a></td>
							<td><a href='Ex03_MemberEdit.jsp?id=<%=rs.getString("id")%>'>[수정]</a></td>
			<%
						//out.print(rs.getString("id") + " / " + rs.getString("ip"));
					}
			%>
			</Table>
			<hr>
				<form action="Ex03_MemberSearch.jsp" method="post">
					회원명 : <input type="text" name="search">
					<input type="submit" value="이름검색하기">
				</form>
			<hr>
			<%
				} catch(Exception e){
					
				} finally{
					Singleton_Helper.close(rs);
					Singleton_Helper.close(pstmt);
				}
			%>
				
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>