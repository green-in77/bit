<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Chat</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<style>
		#chatArea {
			width: 600px; height: 400px; overflow-y: auto; border: 1px solid black;
		}
	</style>
</head>
<body onload="openSocket('all')">
	<div>
		이름 : <input type="text" id="sender" value="${loginuser}">
		<select id="chatList">
			<c:forEach var="chat" items="${roomList}">
				<option value="${chat}">${chat}</option>
			</c:forEach>
		</select>
		<button type="button" onclick="closeSocket();">채팅종료</button>
		<button type="button" onclick="moveSocket();">채팅방이동</button>
	</div>
		
	<div id="chatArea"><div id="chatMessageArea"></div></div>
	<br/>
    <input type="text" id="messageinput">
    <input type="button" onclick="send();" value="전송">
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#messageinput').keypress(function(event){ //엔터누르면 전송
				var keycode = (event.keyCode ? event.keyCode : event.which);
				if(keycode == '13'){
					send();	
				}
				event.stopPropagation();
			});
		});
		
		var ws;
		var messages = document.getElementById("chatArea");

		function moveSocket(){
			if(ws !== undefined && ws.readyState !== WebSocket.CLOSED){
				writeResponse("기존 채팅방 종료 후 이동바랍니다.");
				return;
			}
			//console.log($('#chatList').val());
			openSocket($('#chatList').val());
		}
		
		function openSocket(room){
			if(ws !== undefined && ws.readyState !== WebSocket.CLOSED){
				writeResponse("이미 연결되어 있습니다.");
				return;
			}

			//웹소켓 객체 만드는 코드
            ws=new WebSocket("ws://192.168.6.10:8090/ChatRoom/chat.do/"+room);
            
            ws.onopen=function(event){
                if(event.data === undefined) return;
                
                writeResponse(event.data);
            };
            
            ws.onmessage=function(event){
                writeResponse(event.data);
            };
            
            ws.onclose=function(event){
                writeResponse("연결이 해제되었습니다.");
            }
        }
        
        function send(){
            var text=document.getElementById("messageinput").value+","+document.getElementById("sender").value;
            ws.send(text);
            text="";
        }
        
        function closeSocket(){
            ws.close();
        }
        
        function writeResponse(text){
            messages.innerHTML+="<br/>"+text;
        }
	</script>
</body>
</html>