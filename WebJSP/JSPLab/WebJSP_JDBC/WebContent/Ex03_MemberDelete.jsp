<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
/*
	1. 권한검사
	2. id값 받기
	3. DB > delete from koreamember where id=?
	4. PAGE 이동처리 >> 삭제완료시 list로 이동
*/	
	//1. 권한검사
	if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")){ //값이 없거나, admin이 아니면
		//강제로 페이지 이동
		response.sendRedirect("Ex02_JDBC_Main.jsp");
	}

	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	int row = 0;
	
	try {
		conn = Singleton_Helper.getConnection("oracle");
		String sql = "delete from koreamember where id=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		row = pstmt.executeUpdate();
		 
		if(row > 0) {
			out.print("<script>");
				out.print("alert('삭제가 완료되었습니다.');");	
				out.print("location.href='Ex03_Memberlist.jsp'");	
			out.print("</script>");
		}else {
			out.print("<script>");
				out.print("alert('삭제에 실패했습니다. 다시 확인바랍니다.');");	
				out.print("location.href='Ex03_Memberlist.jsp'");	
			out.print("</script>");
		}

	} catch(Exception e){
		
	} finally{
		Singleton_Helper.close(pstmt);
	}
%>