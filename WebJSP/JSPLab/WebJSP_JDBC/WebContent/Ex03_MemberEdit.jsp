<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")){ //값이 없거나, admin이 아니면
		//강제로 페이지 이동
		response.sendRedirect("Ex02_JDBC_Main.jsp");
	}

	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		conn = Singleton_Helper.getConnection("oracle");
		String sql = "select id,pwd,name,age,trim(gender),email from koreamember where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		rs.next();

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
			<td colspan="2"><jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px"><jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<form action="Ex03_MemberEditok.jsp" method="post">

					<h3 style="text-align: center;">회원정보수정</h3>
					<div>
						<table
							style="width: 400px; height: 200px; margin-left: auto; margin-right: auto;">
							<tr>
								<td>아이디</td>
								<td>
								  <input type="text" name="id" id="id" value=<%= rs.getString(1) %> readonly>
								</td>
							</tr>
							<tr>
								<td>비번</td>
								<td><%= rs.getString(2) %></td>	
							</tr>
							<tr>
								<td>이름</td>
								<td>
								<input type="text" name="name" id="name" value=<%= rs.getString(3) %> style="background-color: yellow">
								</td>
							</tr>
							<tr>
								<td>나이</td>
								<td>
									<input type="text" name="age" id="age" maxlength="3" value=<%= rs.getString(4) %> style="background-color: yellow">
								</td>
							</tr>
							<tr>
								<td>성별</td>
								<td>[<%=rs.getString(5) %>]
								<input type="radio" name="gender" id="gender" value="여" <%if(rs.getString(5).equals("여")){%>checked<%}%>>여자
								<input type="radio" name="gender" id="gender" value="여" <%if(rs.getString(5).equals("남")){%>checked<%}%>>남자
								</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td>
								<input type="text" name="email" id="email" value=<%= rs.getString(6) %> style="background-color: yellow">
								</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="수정하기">
								<a href='Ex03_Memberlist.jsp'>리스트이동</a></td>
						</table>

					</div>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>
<%
		
		/* pstmt.setString(1, id);
		row = pstmt.executeUpdate();
		 
		if(row > 0) {
			out.print("<script>");
				out.print("alert('삭제가 완료되었습니다.');");	
				out.print("location.href='Ex03_Memberlist.jsp'");	
			out.print("</script>");
		}else {
			out.print("<script>");
				out.print("alert('삭제에 실패했습니다. 다시 확인바랍니다.');");	
				out.print("location.href='Ex03_Memberlist.jsp'");	
			out.print("</script>");
		} */

	} catch(Exception e){
		
	} finally{
		Singleton_Helper.close(rs);
		Singleton_Helper.close(pstmt);
	}
%>
