<%@page import="kr.or.bit.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. board_edit.jsp > 입력값 받기 > board dto 객체에 담기
  
	//방법 1) request.getParameter("subject") > new Board > setter > request > return Board
			//보편적인 방법
			
	//방법 2) usebean 액션태그 (property )통해서 setter  주입
				
	//방법 3) request 객체를 통으로 넘기는 방법 (이 방법) >> 실습코드
	request.setCharacterEncoding("UTF-8");
	String idx = request.getParameter("idx");
	
	if(idx == null || idx.trim().equals("")){
		response.sendRedirect("board_list.jsp");
		return;
	}
	
	BoardService service = BoardService.getinstance();
	int result = service.board_Edit(request);
	
	String msg ="";
	String url ="";
	
	if (result > 0){ //insert 성공
		msg = "edit success";
		url = "board_content.jsp?idx="+idx;
	}else { //insert 실패 (catch를 타기 때문에..여기는 안올듯.)
		msg = "edit fail";
		url = "board_edit.jsp?idx="+idx;
	}
	
	request.setAttribute("board_msg", msg);
	request.setAttribute("board_url", url);
%>
<jsp:forward page="redirect.jsp"></jsp:forward>
