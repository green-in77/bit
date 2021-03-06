<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Fmt 포맷관련</title>
</head>
<body>
 <h3>숫자관련</h3>
 변수선언 : <c:set var="price" value="1000000"></c:set><br>

 변수값 출력:${price}<br>

 <fmt:formatNumber value="${price}" type="number" /><br><!-- 1000단위 콤마 처리 -->
 <fmt:formatNumber value="50000000" type="currency" currencySymbol="$" /><br> <!-- 1000단위 콤마처리 + 달러표시 -->
 <fmt:formatNumber value="0.13" type="percent"/> <!-- 13% -->
 변수에 설정 <br>
 <fmt:formatNumber value="123456789" pattern="###,###,###" var="pdata" />
 <!-- 자리수 설정 ###,###,### -->
 변수에 설정한 값 : ${pdata}<br><!-- 123,456,789 -->
 
 <hr>
 <h3>날짜 관련 format</h3>
 변수선언 : <c:set var="now" value="<%= new Date() %>" /><br>
 변수값 : ${now}<br>
 Basic Date : <fmt:formatDate value="${now}" type="date" /><br>
 <!-- 2019.11.4 (년.월.일) -->
 
 DateStyle(full) : <fmt:formatDate value="${now}" type="date" dateStyle="full" /><br>
 <!-- 2019년 11월 4일 월요일 -->
 
 DateStyle(short) : <fmt:formatDate value="${now}" type="date" dateStyle="short" /><br>
 <!--  19.11.4 -->
 
 시간:<fmt:formatDate value="${now}" type="time"/><br>
 <!--  오후 12:55:58  -->
 날짜 + 시간:<fmt:formatDate value="${now}" type="both"/><br>
 <!-- 2019. 11. 4 오후 12:55:58 -->
 혼합:<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br>
 <!-- 2019년 11월 4일 월요일 오후 12시 55분 58초 KST -->
    혼합2:<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" /><br>
 <!-- 19. 11. 4 오후 12:55 -->
 
</body>
</html>
