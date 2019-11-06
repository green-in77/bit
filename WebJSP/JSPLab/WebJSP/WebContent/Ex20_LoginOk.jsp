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
	ID, PW, CHK 값 받아서
	1. id와 pw 같다면 로그인 성공( if (id.equals(pwd)...)
		chk 값이 체크되어있다면 > cookie 생성해서 사용자의 id값을 쿠키에 담는다.
		쿠키의 유효타임은 24시간
		
	2. id와 pw 같다면 로그인 성공
		chk 값이 체크되어있지 않으면 기존 생성했던 쿠키 삭제 > setMaxage(0)
	
	3. id와 pw 같지 않다면 로그인 페이지 다시 호출
		response.sendRedirect() >> Ex19_Login.jsp
-->
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("uid");
	String pw = request.getParameter("upw");
	String chk = null;
	chk = request.getParameter("chk"); //value 값이 없으면 "on"
	
	//out.print(id + " / " + pw + " / " + chk);
	
	if(id.equals(pw)){ //1. 2. 로그인 성공
		
		if(chk != null){
			
			if( chk.equals("on") ){ // 1. 쿠키생성
				Cookie co = new Cookie("UID",id);
				co.setMaxAge(24*60*60); //24시간
				response.addCookie(co);
			}
		} 
		
		else { // 2. 쿠키삭제
			Cookie delco = new Cookie("UID", ""); //쿠키의 같은 값이 있을 경우 덮어쓰기
			delco.setMaxAge(0); // 소멸시간 0
			response.addCookie(delco);
		}
		out.print("<script>location.href='Ex19_Login.jsp'</script>");
	}else {
		response.sendRedirect("Ex19_Login.jsp"); // 서버에게 해당 페이지 요청
	}
%>
</body>
</html>