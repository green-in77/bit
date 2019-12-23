<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Chat</title>
	<style>
		#chatArea {
			width: 600px; height: 400px; overflow-y: auto; border: 1px solid black;
		}
	</style>
</head>
<body>
	<div>
		이름 : <input type="text" id="sender" value="${loginuser}">
	</div>
	
	<div>
		<button type="button" onclick="openSocket('java');">javaOpen</button>
		<button type="button" onclick="openSocket('oracle');">oracleOpen</button>
		<button type="button" onclick="closeSocket();">Close</button>
	</div>
	
	<div id="chatArea"><div id="chatMessageArea"></div></div>
	<br/>
    <input type="text" id="messageinput">
    <input type="button" onclick="send();" value="전송">
	
	<script type="text/javascript">
		var ws;
		var messages = document.getElementById("chatArea");

		function openSocket(room){
			if(ws !== undefined && ws.readyState !== WebSocket.CLOSED){
				writeResponse("이미 연결되어 있습니다.");
				return;
			}

			 //웹소켓 객체 만드는 코드
            ws=new WebSocket("ws://192.168.6.10:8090/ChatRoom/echo.do/"+room);
            
            ws.onopen=function(event){
                if(event.data === undefined) return;
                
                writeResponse(event.data);
            };
            
            ws.onmessage=function(event){
                writeResponse(event.data);
            };
            
            ws.onclose=function(event){
                writeResponse("Connection closed");
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