<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Servlet TEST</title>
</head>
<body>
	<h3>servlet 요청하기</h3>
	<h3>getContextPath() : <%=request.getContextPath() %></h3>
								<!-- /WebServlet_1 -->
	<a href="<%=request.getContextPath()%>/simple">일반요청하기</a>
</body>
</html>