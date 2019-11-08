<%@page import="kr.or.bit.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글처리
	request.setCharacterEncoding("UTF-8");
	
	//데이터받기
	String idx = request.getParameter("idx");
	String pwd = request.getParameter("pwd");
	
	//서비스객체
	BoardService service = BoardService.getinstance();
	int result = service.board_delete(idx, pwd);
	
	String msg ="";
	String url ="";
	
	if (result > 0){ //insert 성공
		msg = "delete success";
		url = "board_list.jsp";
	}else { //insert 실패 (catch를 타기 때문에..여기는 안올듯.)
		msg = "delete fail";
		url = "board_list.jsp";
	}
	
	request.setAttribute("board_msg", msg);
	request.setAttribute("board_url", url);
%>
<jsp:forward page="redirect.jsp"></jsp:forward>
