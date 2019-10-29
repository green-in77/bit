<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
	1. 메모리 쿠키(브라우져 쿠키) : Client 강제적으로 지우지 않는 한, 브라우져를 닫기 전까지, 강제로 소멸타임 -1
	2. 파일 쿠키(소멸 시간을 가지고 있다) : Client 강제로 지우지 않는 한, 정해진 시간이 되지 않는 한
		setMaxage(60) : 60초
		30일 : (30* 24 * 60 * 60) 30일 24시간 60분 60초 	
-->
<%
	Cookie co = new Cookie("bit", "hong");
	co.setMaxAge(60); //60초
	response.addCookie(co);
%>
</body>
</html>