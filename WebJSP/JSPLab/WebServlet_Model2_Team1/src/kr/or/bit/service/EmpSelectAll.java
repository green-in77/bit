package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Emp;

public class EmpSelectAll implements Action {
	//전체조회
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		Empdao empdao = new Empdao();
		//DAO 전체조회함수 실행 //객체 list return
		List<Emp> emplist = empdao.getEmpListAll();
		//값 저장
		request.setAttribute("emplist", emplist);
		//이동경로설정		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/views/empList.jsp");
		
		return forward;
	}

}