<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
	WAS : [여러개의 웹 어플리케이션]을 서비스 할 수 있다.
	WAS 안에 WebJSP 웹 프로젝트(어플리케이션)을 가지고 있다.
	
	http://localhost:8090/WebJSP/Ex10_Application.jsp
	http://localhost:8090/WebJSP2/default.jsp
	
	WebJSP	어플리케이션 이름, 프로젝트 이름, 가상 디렉토리
	WebJSP2	어플리케이션 이름, 프로젝트 이름, 가상 디렉토리
	
	---C:\SmartWeb\WebJSP\JSPLab\WebJSP : 실경로
	---http://192.168.0.146:8090/WebJSP/	: 웹 경로(가상 디렉토리)
	
	어플리케이션이 가지는 default 서비스 경로 : 실 서비스 경로 : WebContent (Context root)
	
	**우리가 만든 소스파일은 (html, htm, jsp, js, css ...)
	WebContent 안에 있어야 한다.
	
	WebContent 안에 있는 모든 page(jsp)가 공유할 수 있는 자원은 없을까..??
		어떤 자원은 a.jsp, b.jsp 에서 사용...
	**웹 어플리케이션은 하나의 설정파일을 가진다.(웹 전체를 설정정보를 가질 수 있다.)
	**web.xml (웹 어플리케이션의 설정정보관리) >> 가장 먼저 실행됨
	**WebContent -> WEB-INF -> web.xml
	
	**WEB-INF (보안폴더) >> 클라이언트가 접속할 수 없는 경로 >> 주소로 접근하면 404
	**WEB-INF > views 폴더 > jsp 생성 (나중에 : forward..)
	
	application 객체 처리(web.xml 자원...)
			
*/
	int sum = 0; //유효범위 : page 생성되면... page 끝나면 소멸(page)
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String param = application.getInitParameter("email");
	//application.getInitParameter : web.xml에서 가져옴
	
	out.print("<h3>" + param + "</h3>");

	String param2 = application.getInitParameter("FilePath");
	out.print("<h3>" + param2 + "</h3>");
%>
</body>
</html>