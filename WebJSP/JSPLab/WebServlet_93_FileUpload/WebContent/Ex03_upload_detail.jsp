<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	글쓴이 :${param.name}<br>
	제목:${param.title}<br>
	파일_1: ${param.filename1} / 원본파일명 :${param.orifilename1}<br>
	파일_2: ${param.filename2} / 원본파일명 :${param.orifilename2}<br>
	
	<hr>
	<h3>다운로드(특정 경로 저장)</h3>
	<a href="Ex04_download.jsp?file_name=${param.filename1}">${param.filename1}</a>
	<hr>
	<a href="Ex04_download.jsp?file_name=${param.filename2}">${param.filename2}</a>
	
	<h3>웹 브라우져 보기</h3>
	<!-- 브라우져가 자동으로 사진을 읽어서 보여주는것, 브라우져가 읽을 수 없는 파일이면 다운로드 하라고 나옴...(그건 저장하기 기능이 아님..) -->
	<a href="upload/${param.filename1}">브라우져 보기1</a><br><!-- 경로 upload/ 배포된 서버의 경로..(개발폴더의 upload의 경로가 아님..) -->
	<a href="upload/${param.filename2}">브라우져 보기2</a>
</body>
</html>






