<%@page import="kr.or.bit.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	//한글처리
	request.setCharacterEncoding("UTF-8");

	//데이터 받기
	String writer = request.getParameter("reply_writer");
	String content = request.getParameter("reply_content");
	String pwd = request.getParameter("reply_pwd");
	String idx_fk = request.getParameter("idx");
	String userid = "empty";
	
	
	
	BoardService service = BoardService.getinstance();
	int result = service.replyWrite(Integer.parseInt(idx_fk), writer, userid, content, pwd);
	
	String msg ="";
	String url ="";
	
	if (result > 0){ //insert 성공
		msg = "reply success";
		url = "board_content.jsp?idx="+idx_fk;
	}else { //insert 실패 (catch를 타기 때문에..여기는 안올듯.)
		msg = "reply fail";
		url = "board_content.jsp?idx="+idx_fk;
	}
	
	request.setAttribute("board_msg", msg);
	request.setAttribute("board_url", url);
%>
<jsp:forward page="redirect.jsp"></jsp:forward>
