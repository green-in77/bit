<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 한글처리
	//데이터 받는 모든 페이지 상단에는
	//request.setCharacterEncoding("UTF-8");
	//데이터 받기 전에 꼭 해야함
	
	//관심사(주관심, 보조관심)
	//주관심 : 데이터 출력
	//보조관심 : 한글처리
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Ok</title>
</head>
<body>
한글명 : ${param.kor}<br>
영문명 : ${param.eng}<br>
</body>
</html>