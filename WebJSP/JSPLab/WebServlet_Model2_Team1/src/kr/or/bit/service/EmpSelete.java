package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Emp;

public class EmpSelete implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String empno = request.getParameter("empno");
		
		Empdao empdao = new Empdao();
		Emp emp = empdao.getEmp(empno);
		
		request.setAttribute("emp", emp);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/views/empEdit.jsp");
		
		return forward;
	}
}
