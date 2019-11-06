<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//EL 출력(서버쪽 자원....) <%= 대체
	//EL을 사용한다고 해서 JAVA의 객체를 지원하는 것은 아니다.
	Date today = new Date();
	request.setAttribute("day", today); //페이지 Scope
	session.setAttribute("day2", today); //프로젝트 Scope	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL 목적 : 출력</h3>
	<%= request.getAttribute("day") %><br>
	EL : ${requestScope.day}<br><!-- requestScope 붙여서 쓰는 것을 권장 -->
	Session EL : ${sessionScope.day2}<br>
</body>
</html>