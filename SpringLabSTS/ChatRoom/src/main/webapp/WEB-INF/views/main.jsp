<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>모두의 채팅</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript">
		
	</script>
</head>
<body>
	<a href="${pageContext.request.contextPath}/chatAll.do">채팅입장</a><br>
	
	<form action="create.do" method="post">
		<input type="text" name="roomName" placeholder="채팅방이름">
		<input type="submit" value="채팅방만들기">
	</form>
</body>
</html>