package kr.or.bit.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;

public class MemoAddService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		  
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String memo = request.getParameter("memo");
		//out.print(id + "," + email + "," + memo);
		  
		String board_msg="";
		String board_url = "";
		
		memodao dao = new memodao();
		int result = dao.insertMemo(id, email, memo);
		  
		if(result > 0){
			board_msg ="등록완료";
			board_url = "memolist.do";
		}else{ //insert 에서 현실적으로 경우 ...
			board_msg = "등록실패";
			board_url = "/memo.html";
		}
		//3. 결과 저장하기 
    	request.setAttribute("board_msg", board_msg);
    	request.setAttribute("board_url", board_url);
   	
    	//4. ActionForwade 객체 생성하기
    	ActionForward forward = new ActionForward();
    	forward.setRedirect(false);
    	forward.setPath("/WEB-INF/views/redirect.jsp");
    	
		return forward;
	}

}
