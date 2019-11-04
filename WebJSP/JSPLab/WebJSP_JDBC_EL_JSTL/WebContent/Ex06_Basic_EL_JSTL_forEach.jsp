<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.bit.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h3>JSTL for 문</h3>
	<!--
		JAVA
			for(int i = 0; i <= 10 ; i++){}
			for(String s : list){}
	-->
	<!-- 		변수		1부터			10까지 -->
	<c:forEach var="i" begin="1" end="10">
		<c:set var="sum" value="${sum+i}" /> <!-- sum에 i를 누적한다. 생성된 변수는 scope을 별도로 보지 않는다 page 내에서 사용 가능 -->
	</c:forEach>
	sum:누적값 : ${sum}<br>
	
	<h3>구구단 5단 출력하기</h3>
	<c:forEach var="i" begin="1" end="9">
		<li>5 * ${i} = ${5*i}</li>
	</c:forEach>
	
	<h3>EL & JSTL 사용해서 2~9까지 출력</h3>
	<table border='1'>
		<c:forEach var="i" begin="2" end="9">
			<tr>
			<c:forEach var="j" begin="0" end="9">
				<c:choose>
					<c:when test="${j==0}"><!-- case j가 0이면 -->
						<th bgcolor="yellow">${i}단</th>
					</c:when>
					<c:otherwise><!-- default 나머지는 -->
						<td>${i} * ${j} = ${i*j}</td>	
					</c:otherwise>
				</c:choose>
			</c:forEach>
			</tr>
		</c:forEach>
	</table>
	
	<h3>JSTL forEach</h3>
	<%
		int[] arr = new int[]{10,20,30,40};
		//int[] arr = {10,20,30,40}
		
		/* for(int i : arr){
			out.print("출력값 : " + i + "<br>");
		} */
	%>
	<h3>★★★★★★★★ [EL JAVA 객체에 직접 접근 불가] JSTL 변수를 사용해 데이터를 담은 후 EL출력 ★★★★★★★★</h3>
	arr 배열[객체] 접근 불가 : ${arr}<br><!-- 값이 없어도 error 가 나지 않음 -->
	<c:set var="intarr" value="<%=arr%>" /> <!-- intarr에 arr배열의 주소값이 할당 -->
	c:set 변수에 접근 : ${intarr}<br>
	<hr>
	<h3>Java 에서의 개선된 for문(items 제공)</h3>
	<c:forEach var="i" items="${intarr}"> <!--for(String s : list){}-->
		배열값 : ${i}<br>
	</c:forEach> <!--  c:set으로 변수에 담아서 활용  -->
	
	<h3>단순하게..(편하게...주로사용)</h3>
	<c:forEach var="i" items="<%=arr%>"> <!-- c:set 으로 변수에 담지 않고 바로 사용 -->
		배열값2 : ${i}<br>
	</c:forEach>
	
	<h3>재미삼아..(많이 쓰지 않음)</h3>
	<c:forEach var="i" items="<%= new int[]{1,2,3,4,5} %>"> <!-- 배열을 선언부터 넣어서 -->
		배열값3 : ${i}<br>
	</c:forEach>
	
	<h3>forEach 활용하기 2</h3>
	<c:forEach var="i" items="${intarr}" varStatus="status"> <!-- varStatus : 상태를 담는 변수 / status ->변수명 -->
		index : ${status.index} &nbsp;&nbsp;&nbsp; <!-- 시작값 : 0~ -->
		count : ${status.count} &nbsp;&nbsp;&nbsp; <!-- 갯수 : 1~ -->
		value : ${i}<br>
	</c:forEach>
	
	<h3>★★★★★★★★★★★★POINT (JSTL forEach 활용)★★★★★★★★★★★★</h3>
	<%
		List<Emp> emplist = new ArrayList<>();
		emplist.add(new Emp(1000,"A"));
		emplist.add(new Emp(2000,"B"));
		emplist.add(new Emp(3000,"C"));
		
		for(Emp e : emplist){
			out.print(e.getEmpno() + " / " +e.getEname() + "<br>");
		}
	%>
	<h3>JSTL로 출력</h3>
	<c:forEach var="i" items="<%= emplist %>">
		사원번호 : ${i.empno} / 사원명 : ${i.ename}<br>
	</c:forEach>
	
	<h3>JSTL 사용 Map 출력</h3>
	<%
		Map<String, Object> hm = new HashMap<>();
		hm.put("name", "hong");
		hm.put("pwd", "1004");
		hm.put("date", new Date());
	%>
	<h3>Java Map EL&JSTL 출력하기</h3>
	<c:set var="hm" value="<%=hm%>" />
	<c:forEach var="obj" items="${hm}">
		${obj.key} : ${obj.value}<br> <!-- key, value 속성 의무 제공 (Map : 순서보장X) -->
	</c:forEach>
	<hr>
	(key)name : ${hm.name}<br>
	(key)pwd : ${hm.pwd}<br>
	(key)date : ${hm.date}<br>
	
	<h3>JSTL 구분자 처리</h3>
	<c:forTokens var="token" items="A.B.C.D" delims=".">
		${token}<br>
	</c:forTokens>
	
	<h3>JSTL 복합구분자 처리</h3>
	<c:forTokens var="token" items="A-B.C/D" delims=".-/">
		${token}<br>
	</c:forTokens>
	
	<!-- step 마이너스 값을 사용할 수 없습니다 
		 step = -1 그래서 편법적으로 사용합니다
	-->
	<c:set var="nowNum" value="10"></c:set>
	<c:forEach var="i" begin="0" end="${nowNum}" step="1">
	   ${nowNum - i}
	</c:forEach>
		
	<c:forEach var="i" begin="0" end="${2016-1900}">
	    <c:set var="yearOption" value="${2016-i}" />
	    <option value="${yearOption}">${yearOption}</option>
	</c:forEach>
</body>
</html>