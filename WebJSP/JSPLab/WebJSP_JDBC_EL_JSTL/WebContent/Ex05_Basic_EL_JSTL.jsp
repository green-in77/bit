<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
/*
	<c:set			: 변수생성, 값저장, 자바 객체 변수로 만들기(value=<%=객체)
	<c:remove		: 변수 삭제
	<c:if			: 조건문 (test:"조건절")
	<c:choose		: 여러가지 조건에 따라서 처리가능(case 문 비슷 / if보다 활용도가 높음)
	<c:forEach		: 반복문(개선된 for문)
	<c:forTokens	: 토큰값(split 과 for문 결합)
	<c:out			: JSTL 출력구문(이거보단 EL표현식 ${} 사용함)
	<c:catch		: 예외처리
*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL parameter 받기</h3>
	${param.id} - ${param.pwd}<br>
	
	<h3>EL parameter 값을 변수에 저장하기</h3>
	<c:set var="userid" value="${param.id}"/>
	<c:set var="userpwd" value="${param.pwd}" />
	
	<h3>JSTL 변수값 출력</h3>
	id : ${userid}<br>
	pw : ${userpwd}<br>
	
	<hr>
	<c:if test="${!empty userpwd}">
		<h3>not empty userpwd</h3>
		<c:if test="${userpwd == '1004' }">
			<h3>welcome Admin page</h3>
		</c:if>
	</c:if>
</body>
</html>