<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}

tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}

td {
	border: solid 1px red;
}
</style>
</head>
<body>
	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px">
				<jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<!-- MAIN PAGE CONTENT  -->
				<%
					String id = null;
					id = (String)session.getAttribute("userid");
					
					if ( id != null){ //회원이면
						out.print(id + " 회원님 반갑습니다 :)<br>");
						
						if(id.equals("admin")){ //관리자이면
							out.print("<a href='Ex03_Memberlist.jsp'>회원관리</a>");
						}
					}else{//비회원
						//메인페이지는 회원만 볼 수 있다...(강제링크코드 추가)
						out.print("방문을 환영합니다 :)<br>회원가입  또는 로그인 후 이용바랍니다!");
					}
				%>				
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>