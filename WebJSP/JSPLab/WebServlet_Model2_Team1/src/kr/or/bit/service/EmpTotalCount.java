package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;

public class EmpTotalCount implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		Empdao empdao = new Empdao();
		int totalcount = empdao.getEmpTotalCount();
		
		request.setAttribute("totalcount", totalcount);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/views/empList.jsp");
		return forward;
	}

}
