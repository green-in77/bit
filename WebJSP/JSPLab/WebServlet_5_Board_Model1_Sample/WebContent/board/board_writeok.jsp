<%@page import="kr.or.bit.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//1.한글처리
	request.setCharacterEncoding("UTF-8");

	//2.데이터 받기
	
%>
<jsp:useBean id="board" class="kr.or.bit.dto.Board"><!--  Board board = new Board -->
	<jsp:setProperty property="*" name="board" /> <!-- getParameter >> board.set~~~~ -->
</jsp:useBean>
<!--
	DTO객체 생성 > 데이터 받고 > 받은 데이터 setter 넣는 것까지 자동
	조건 : input name과 DTO객체의 멤버필드명과 같아야함
-->
<%
	/* out.print(board.getSubject() + "<br>");
	out.print(board.getWriter() + "<br>");
	out.print(board.getEmail() + "<br>");
	out.print(board.getHomepage() + "<br>");
	out.print(board.getPwd() + "<br>");
	out.print(board.getFilename() + "<br>"); */
	
	BoardService service = BoardService.getinstance();
	int result = service.writeok(board);
	
	String msg ="";
	String url ="";
	
	if (result > 0){ //insert 성공
		msg = "insert success";
		url = "board_list.jsp";
	}else { //insert 실패 (catch를 타기 때문에..여기는 안올듯.)
		msg = "insert fail";
		url = "board_write.jsp";
	}
	
	request.setAttribute("board_msg", msg);
	request.setAttribute("board_url", url);
%>
<jsp:forward page="redirect.jsp"></jsp:forward>
