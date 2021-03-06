package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;

public class MemoIdCheckService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
			String id = request.getParameter("id");
			System.out.println("id : " + id);
			
			memodao dao = new memodao();
			String ischeck = dao.isCheckById(id);
		
			//keyPoint out.print 로 값을 전달
			//out.print(ischeck);
			request.setAttribute("ischeck", ischeck);
			
			forward = new ActionForward();
	    	forward.setRedirect(false);
	    	forward.setPath("/WEB-INF/views/idcheck.jsp");

		return forward;
	}	
}