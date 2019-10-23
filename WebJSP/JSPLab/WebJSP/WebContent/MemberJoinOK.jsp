<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	//userId , userPass , userEmail , userPhone, userSsn1 , userSsn2 , userZipCode
	String userId = request.getParameter("userId");
	String userPass = request.getParameter("userPass");
	String userEmail = request.getParameter("userEmail");
	String userPhone = request.getParameter("userPhone");
	String userSsn = request.getParameter("userSsn1") + request.getParameter("userSsn2");
	String userZipCode = request.getParameter("userZipCode");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입완료</title>
	<style>
    body{font-family:"malgun gothic";font-size:9pt;}
    th { text-align:right; background-color:#dbdbdb; width: 120px; text-align: center}
    th.title { text-align:center; font-size:12pt;background-color:#ffffff;}
  </style>
</head>
<body>
	<table>
		<tr>
			<th colspan="2" class="title">회원가입</th>
		</tr>
		
		<tr>
			<th>아이디</th>
			<td>
				<%= userId %>        	
			</td>
		</tr>
		
		<tr>
			<th>패스워드</th>
			<td>
				<%= userPass %>
			</td>
		</tr>
		 <tr>
			<th>이메일</th>
			<td>
				<%= userEmail %>
			</td>
		</tr>
		<tr>
			<th>주민번호</th>
			<td>
		    	<%= userSsn %>
			</td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td>
				<%= userZipCode %>
			</td>
		</tr>
		<tr>
			<th>핸드폰번호</th>
			<td>
				<%= userPhone %>
			</td>
		</tr>
	</table>
</body>
</html>