
<%@page import="kr.or.bit.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String idx_fk = request.getParameter("idx"); //댓글의 원본 게시글 번호
	String no = request.getParameter("no"); //댓글의 순번(고유값 : PK)
	String pwd = request.getParameter("delpwd"); //댓글의 비번
	
	if(idx_fk == null || no == null || pwd == null || no.trim().equals("")){
%>
	<script type="text/javascript">
		history.back();
	</script>
<%	
	return;
	}else {
		BoardService service = BoardService.getinstance();
		int result = service.replyDelete(no, pwd);
		
		String msg ="";
		String url ="";
		
		if (result > 0){ //insert 성공
			msg = "reply delete success";
			url = "board_content.jsp?idx="+idx_fk;
		}else { //insert 실패 (catch를 타기 때문에..여기는 안올듯.)
			msg = "reply delete fail";
			url = "board_content.jsp?idx="+idx_fk;
		}
		
		request.setAttribute("board_msg", msg);
		request.setAttribute("board_url", url);
%>
		<jsp:forward page="redirect.jsp"></jsp:forward>
<%	
	}
%>