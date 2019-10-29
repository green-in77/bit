<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 한글처리
	request.setCharacterEncoding("UTF-8");

	//2. 데이터 받기
	String uid = request.getParameter("uid");
	String upw = request.getParameter("upw");
	
	//3. 확인하기
	//out.print(uid + " / " + upw);
	
	//4. 로직(업무)처리
	//DB연결 > select > 회원테이블 > id(o) > pw(o)
	
	//id, pw 같으면 회원
	boolean success = false;
	if(uid.equals(upw)){ //로그인성공
		//session 변수에 id 값 담기
		//★★★★★★★★★★★★			session 변수의 scope :	모든 PAGE			★★★★★★★★★★★★★★★ 
		session.setAttribute("memberid", uid);
		success = true;
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	if(success == true){
		out.print("<b>로그인 성공</b><br>");
		String user = (String)session.getAttribute("memberid");
		out.print(user + "님 로그인 되었습니다.<br>");
		out.print("<a href='Ex23_Session_Member.jsp'>회원전용</a>");
	}else{
%>
		<script type="text/javascript">
			alert("다시 로그인 해 주세요")
			window.history.go(-1); //이전페이지로 이동(로그인 페이지로 이동)
			//location.href="" 가능
		</script>
<%	
	}
%>
</body>
</html>