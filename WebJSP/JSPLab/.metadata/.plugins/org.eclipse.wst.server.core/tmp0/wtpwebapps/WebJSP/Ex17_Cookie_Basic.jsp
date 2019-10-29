<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<!--
	정보(데이터)
	
	클라이언트(로컬PC 웹 브라우져)		:		서버(웹 서버 Tomcat or DB 서버)
	
	정보(데이터:자료) >> 어디에 저장(보관)하는 것이 좋을까
	고민 : 어떤 기준으로 보관장소를 정할까
		보안요소(정보의 중요성), 소멸(일시적, 영속적)
	
	Client(Local PC : 웹 브라우져)
	1. Cookie (메모리 쿠키, 파일 쿠키(자동 암호화)) >> 소멸시기
	2. Local Storage (저장소) (키 : 값)
	
	Server (WebServer : Tomcat)
	1. Server Memory : session 객체 (접속한 사용자 식별, 개인정보, 접속시간) -> 서버 꺼지면 없어짐(임시)
	2. Server Memory : application 객체 (접속한 모든 사용자가 사용가능한 공유객체) -> 서버 꺼지면 없어짐(임시)
	3. Server : 파일(txt) >> 영속
	4. DB Server : >> 영속 (RDBMS)
-->
<%
	Cookie mycookie = new Cookie("cname", "1004"); //Tomcat 이 가진 객체 / default 생성자 없음 / 1 : 쿠키의 이름 , 2 : 쿠키 값
	//만든 쿠키를 클라이언트에게 전달 (response)
	
	response.addCookie(mycookie);
%>

서버 설정한 쿠키 이름 : <%= mycookie.getName() %> <br>
서버 설정한 값 : <%= mycookie.getValue() %> <br>
서버 설정한 쿠키 소멸 설정 :(-1 : 소멸시간이 없다 : session) <%= mycookie.getMaxAge() %> <br>
</body>
</html>