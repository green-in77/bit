package kr.or.bit.service;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;
import kr.or.bit.dto.memo;

public class MemoListService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		memodao dao = new memodao();
		ArrayList<memo> memolist = dao.getMemoList();
		
		//요청결과 저장
		request.setAttribute("memolist", memolist);
		
		//view 페이지 설정
		ActionForward forward = new ActionForward();
    	forward.setRedirect(false);
    	forward.setPath("/WEB-INF/views/memolist.jsp");
    	
		return forward;
	}

}
