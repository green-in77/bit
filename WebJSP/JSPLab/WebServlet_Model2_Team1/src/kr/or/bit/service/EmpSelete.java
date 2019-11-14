package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Emp;

public class EmpSelete implements Action{
	//empno 조건 조회
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String empno = request.getParameter("empno");
		//데이터 받아서 DAO empno 조회함수 실행
		Empdao empdao = new Empdao();
		Emp emp = empdao.getEmpListEmpno(empno);
		//값저장
		request.setAttribute("emp", emp);
		//경로설정
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/views/empEdit.jsp");
		
		return forward;
	}
}
