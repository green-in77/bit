<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MemoList</title>
</head>
<body>
	<h3>MemoList</h3>
	<table border="1px">
		<tr>
			<td>ID</td><td>Email</td><td>Content</td>
		</tr>
		
		<c:forEach var="memo" items="${memolist}"> <!-- ${requestScope.memolist} -->
			<tr>
				<td>${memo.id}</td><td>${memo.email}</td><td>${memo.content}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="memo.html">글쓰기</a>
</body>
</html>