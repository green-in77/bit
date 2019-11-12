package kr.or.bit.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Emp;

public class EmpUpdate implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 데이터 받기.
		String empno = request.getParameter("empno");
		String job = request.getParameter("job");
		String mgr = request.getParameter("mgr");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		String deptno = request.getParameter("deptno");
		
		Emp emp = new Emp();
		emp.setEmpno(Integer.parseInt(empno));
		emp.setJob(job);
		emp.setMgr(Integer.parseInt(mgr));
		emp.setSal(Integer.parseInt(sal));
		emp.setComm(Integer.parseInt(comm));
		emp.setDeptno(Integer.parseInt(deptno));
				
		Empdao empdao = new Empdao();
		int result = empdao.empEdit(emp);
		
		String board_msg = "";
		String board_url = "";
		
		if(result > 0 ) {
			request.setAttribute("emp", emp);
			board_msg = "수정이 완료되었습니다.";
			board_url = "empList.do";
		}else {
			board_msg = "수정을 실패하였습니다. 다시확인바랍니다.";
			board_url = "empEdit.do?empno="+emp.getEmpno();
		}
		
		request.setAttribute("board_msg",board_msg);
		request.setAttribute("board_url",board_url);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/process/redirect.jsp");
		
		return forward;
	}

}
