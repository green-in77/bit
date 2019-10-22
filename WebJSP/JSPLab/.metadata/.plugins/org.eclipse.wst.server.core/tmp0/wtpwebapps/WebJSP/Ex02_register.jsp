<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	//서버쪽 객체 사용
	//아파치톰캣 : 웹 전용 객체를 제공(request, response)
	// new 없이 사용할 수 있음 : 내장객체
	
	//클라이언트가 서버에 전달한 데이터 받기
	
	String userid = request.getParameter("userid"); // 단일값
	String pwd = request.getParameter("pwd");
	
	String[] hobbys = request.getParameterValues("hobby");
	//JDBC 코드 DB 연결 .....
	
	//★★★★★★★★★ 한글처리★★★★★★★★★
	/*
		전송방식 : GET (Tomcat9 이후는 한글 문제 없음)
		이전버전이라면 
		page 상단에  1. request.setCharacterEncoding("UTF-8");
		server.xml 63번째  URIEncoding="UTF-8" 추가
		<Connector URIEncoding="UTF-8" executor="tomcatThreadPool" port="8090" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" /> 
		
		전송방식 : POST
		반드시 데이터 받기전에 page 상단에  request.setCharacterEncoding("UTF-8");
		
		무조건 받는 페이지에 page 상단에 request.setCharacterEncoding("UTF-8");
	*/
	
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
입력값  : <%=userid%><br>
입력값  : <%=pwd%><br>
당신의 취미는 : <br>
<%
	for(String str : hobbys){%>
		hobby : <%= str %><br>
<%	} %>

</body>
</html>