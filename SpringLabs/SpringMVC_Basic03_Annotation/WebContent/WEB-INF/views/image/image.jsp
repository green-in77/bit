<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		이름:<input type="text" name="name"><br>
		나이:<input type="text" name="age"><br>
		사진:<input type="file" name="file"><br>
		<!--  private CommonsMultipartFile file; -->
		<input type="submit" value="파일업로드">
		<img src="../upload/Spring_MVC.jpg">
		<!-- 현재 image 폴더안에 있기 때문에 하나 나가서 upload 를 찾아야 한다. -->
	</form>
</body>
</html>