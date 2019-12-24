<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="se"	uri="http://www.springframework.org/security/tags"%>

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
<body onload="openSocket('전체채팅방')">
	<se:authentication property="name" var="loginuser" />
	
	<div>
		[${loginuser}] 님 반갑습니다.
		<input type="hidden" id="sender" value="${loginuser}">
		채팅방목록
		<select id="chatList">
			<c:forEach var="chat" items="${roomList}">
				<option value="${chat}">${chat}</option>
			</c:forEach>
		</select>
		<button type="button" onclick="closeSocket();">채팅종료</button>
		<button type="button" onclick="moveSocket();">채팅방이동</button>
		
		
		<form action="create.do" method="post">
			<input type="text" name="roomName" placeholder="채팅방이름">
			<input type="submit" value="채팅방만들기">
		</form>
		
	</div>
		
	<div id="chatArea"><div id="chatMessageArea"></div></div>
	<br/>
    <input type="text" id="messageinput">
    <input type="button" onclick="send();" value="전송">
    <input type="button" onclick="listsend();" value="접속자보기">
    
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

        function listsend(){
        	console.log("list호출");
            ws.send("/list,"+document.getElementById("sender").value);
        }
        
		function moveSocket(){
			window.open("chat.do?roomName="+$('#chatList').val(),$('#chatList').val(),"width=700,height=600");
		}
		
		function openSocket(room){
			if(ws !== undefined && ws.readyState !== WebSocket.CLOSED){
				writeResponse("<b>이미 연결되어 있습니다.</b>");
				return;
			}

			//웹소켓 객체 만드는 코드
            ws=new WebSocket("ws://192.168.6.10:8090/ChatRoom/chat.do/"+room+"/${loginuser}");
            
            ws.onopen=function(event){
                if(event.data === undefined) return;
                
                writeResponse(event.data);
            };
            
            ws.onmessage=function(event){
                writeResponse(event.data);
            };
            
            ws.onclose=function(event){
                writeResponse("<b>연결이 해제되었습니다.</b>");
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