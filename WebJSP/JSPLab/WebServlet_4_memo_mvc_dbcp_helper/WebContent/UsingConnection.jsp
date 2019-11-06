<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Tomcat Connection Pool</title>
</head>
<body>
<%
	Connection conn = null;
	
	Context context = new InitialContext(); // InitialContext : 현재 Web 프로젝트에서 이름 기반으로 검색
	DataSource ds =  (DataSource)context.lookup("java:comp/env/jdbc/oracle"); // java:comp/env/ + name : 자바의 설정환경에서 name을 찾겠다.
	
	//POOL안에서 connection 가지고 오기
	conn = ds.getConnection();
	out.print("DB 연결여부 : " + conn.isClosed() + "<br>"); //false : 접속상태
	
	//POINT
	//POOL에 connection 반환하기
	conn.close(); //반환
	out.print("DB 연결여부 : " + conn.isClosed() + "<br>"); //true : 접속반환
%>
</body>
</html>