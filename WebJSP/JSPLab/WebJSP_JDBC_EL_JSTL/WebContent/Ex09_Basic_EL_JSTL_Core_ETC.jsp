<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL Core Lib ETC</title>
</head>
<body>
	<h3>out 출력(EL)</h3>
	<c:out value="<p>태그는 문단태그 입니다.</p>" /> <!-- 태그해석불가(문자로 취급) -->
	&lt;p&gt;태그는 문단태그&lt;/p&gt;<!-- &lt; = < / &gt; = > -->
	
	<hr>
	<!-- JSTL 예외처리 -->
	<h3>예외처리</h3>
	<c:catch var = "msg">
		name : <%= request.getParameter("name") %>
		<%
			if(request.getParameter("name").equals("hong")){
				out.print("당신의 이름은 : " + request.getParameter("name"));
			}
		%>
	</c:catch>
	<c:if test ="${msg != null}"> <!--  예외가 발생했다면 -->
		<h3>예외발생</h3>
		오류메시지 : ${msg}
	</c:if>
</body>
</html>