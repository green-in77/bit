<%@ page contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="se"	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>쪽지보내기</title>
	<style>
	#chatArea {
		width: 600px; height: 400px; overflow-y: auto; border: 1px solid black;
	}
	</style>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			connect();
			$('#sendBtn').click(function() { send(); });
		})
		
		var wsocket;
		
		function connect() {
			wsocket = new WebSocket(
					"ws://192.168.6.10:8090/Alram/chat-ws");
			wsocket.onopen = onOpen;
			wsocket.onmessage = onMessage;
			wsocket.onclose = onClose;
		}
		function disconnect() {
			wsocket.close();
		}
		
		function onOpen(evt) {
		}
		
		function onMessage(evt) {
			var data = evt.data;
			appendMessage(data);
		}
		
		function onClose(evt) {
		}
		
		function send() {
			let m_to = $('#m_to').val();
			let m_from = $('#m_from').val();
			let msg = $('#msg').val();
			wsocket.send(m_to + "," + m_from + "," + msg);
			$('#msg').val("");
		}
	
		function appendMessage(msg) {
		}
		
	</script>
</head>
<body>
	<se:authentication property="name" var="loginuser"  />
		보내는사람 : ${loginuser} <input type="hidden" name="m_to" id="m_to" value="${loginuser}">
		받는사람 :
		<select name="m_from" id="m_from">
			<c:forEach var="member" items="${listmember}">
				<option value="${member.userid}">${member.name}</option>
			</c:forEach>
		</select> 
		<input type="text" id="msg" name="msg">
		<input type="button" id="sendBtn" value="전송">
		<br>
		<a href="${pageContext.request.contextPath}">홈으로</a>
</body>
</html>