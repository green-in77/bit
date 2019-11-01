<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id"); 
	String pwd = request.getParameter("pwd"); 
	String name = request.getParameter("name"); 
	int age = Integer.parseInt(request.getParameter("age")); 
	String gender = request.getParameter("gender"); 
	String email = request.getParameter("email"); 
	
	out.print(id + "/"+pwd + "/"+name + "/"+age + "/"+gender + "/"+email);
	out.print(request.getRemoteAddr());
	 
	Class.forName("oracle.jdbc.OracleDriver");
	Connection conn = null;
	PreparedStatement pstmt=null;
	
	try{
		conn = Singleton_Helper.getConnection("oracle");
		
		String sql="insert into koreamember(id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, name);
		pstmt.setInt(4, age);
		pstmt.setString(5, gender);
		pstmt.setString(6, email);
		pstmt.setString(7, request.getRemoteAddr());
		
		int result = pstmt.executeUpdate();
		if(result !=0){
			out.print("<script>");
			out.print("alert('가입되었습니다 :)');");
				out.print("location.href='login.jsp'");	
			out.print("</script>");
		}else{ //실행될 확률 거의없다 ...
			out.print("<script>");
				out.print("alert('가입실패');");	
			out.print("</script>");		
		}
		
	}catch(Exception e){
		// pstmt.executeUpdate(); 실행시  PK 위반 예외 발생    if 타지 않고 ....
		out.print("<script>");
			out.print("alert('가입실패');");	
			out.print("location.href='signup.jsp'");	
		out.print("</script>");
	}finally{
		Singleton_Helper.close(pstmt);
	}

	
%>