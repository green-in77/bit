package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Emp;

public class EmpInsert implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 데이터 받기.
		String ename = request.getParameter("ename");
		String empno = request.getParameter("empno");
		String job = request.getParameter("job");
		String mgr = request.getParameter("mgr");
		String hiredate = request.getParameter("hiredate");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		String deptno = request.getParameter("deptno");
		
		
		Emp emp = new Emp();
		emp.setEname(ename);
		emp.setEmpno(Integer.parseInt(empno));
		emp.setJob(job);
		emp.setMgr(Integer.parseInt(mgr));
		emp.setHiredate(hiredate);
		emp.setSal(Integer.parseInt(sal));
		emp.setComm(Integer.parseInt(comm));
		emp.setDeptno(Integer.parseInt(deptno));
		
		Empdao empdao = new Empdao();
		int result = empdao.empRegister(emp);
		
		String board_msg = "";
		String board_url = "";
		
		if(result > 0) {
			board_msg = "등록되었습니다.";
			board_url = "empList.do";
		}else {
			board_msg = "등록에 실패하였습니다. 다시 확인바랍니다.";
			board_url = "empAdd.do";
		}
		
		request.setAttribute("board_msg", board_msg);
		request.setAttribute("board_url", board_url);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/process/redirect.jsp");
		
		return forward;
	}

}
