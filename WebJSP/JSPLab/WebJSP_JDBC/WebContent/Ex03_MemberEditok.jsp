<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
	1. 권한처리
	2. 한글처리
	3. 데이터받기
	4. 로직처리
	5. 이동
	
*/
	if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")){ //값이 없거나, admin이 아니면	
		//강제로 페이지 이동
		response.sendRedirect("Ex02_JDBC_Main.jsp");
	}
	
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String email = request.getParameter("email");
	String gender = request.getParameter("gender");
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	int row = 0;
	
	try {
		conn = Singleton_Helper.getConnection("oracle");
		String sql = "update koreamember set name=?, age=?, email=?, gender=? where id=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, age);
		pstmt.setString(3, email);
		pstmt.setString(4, gender);
		pstmt.setString(5, id);
		
		row = pstmt.executeUpdate();

		if(row > 0) {
			out.print("<script>");
				out.print("alert('수정이 완료되었습니다.');");	
				out.print("location.href='Ex03_Memberlist.jsp'");	
			out.print("</script>");
		}else {
			out.print("<script>");
				out.print("alert('수정에 실패했습니다. 다시 확인바랍니다.');");	
				out.print("location.href='Ex03_Memberlist.jsp'");	
			out.print("</script>");
		}

	} catch(Exception e){
		
	} finally{
		Singleton_Helper.close(pstmt);
	}
%>
 