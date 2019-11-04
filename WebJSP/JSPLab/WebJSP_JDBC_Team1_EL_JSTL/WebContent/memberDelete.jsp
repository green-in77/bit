<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="common/Admin.jsp"></jsp:include>
<%
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
				out.print("location.href='memberlist.jsp'");	
			out.print("</script>");
		}else {
			out.print("<script>");
				out.print("alert('삭제에 실패했습니다. 다시 확인바랍니다.');");	
				out.print("location.href='memberlist.jsp'");	
			out.print("</script>");
		}

	} catch(Exception e){
		
	} finally{
		Singleton_Helper.close(pstmt);
	}
%>