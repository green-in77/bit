<%@page import="kr.or.bit.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");
	
	/* String writer = request.getParameter("writer");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String email = request.getParameter("email");
	String homepage = request.getParameter("homepage");
	String filename = request.getParameter("filename");
	String pwd = request.getParameter("pwd"); */
%>
<jsp:useBean id="board" class="kr.or.bit.dto.Board" scope="page">
	<jsp:setProperty property="*" name="board" />
</jsp:useBean>
<%
	BoardService service = BoardService.getinstance();
	int result = service.rewriteok(board);
	
	//list 이동시 ... 현재 pagesize, cpage 정보를 가져가고 싶으면...받아서...
	String ps = request.getParameter("ps");
	String cp = request.getParameter("cp");
	
	String msg ="";
	String url ="";
	
	if (result > 0){ //insert 성공
		msg = "rewirte insert success";
		url = "board_list.jsp?ps="+ps+"&cp="+cp;
	}else { //insert 실패 (catch를 타기 때문에..여기는 안올듯.)
		msg = "rewirte insert fail";
		url = "board_content.jsp?idx="+board.getIdx();
	}
	
	request.setAttribute("board_msg", msg);
	request.setAttribute("board_url", url);
%>
<jsp:forward page="redirect.jsp"></jsp:forward>
