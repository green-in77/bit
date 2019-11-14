package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Emp;
import net.sf.json.JSONObject;

public class EmpSelectEmpno implements Action {
	//사번으로 검색
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//데이터 받아오기
		String empno = request.getParameter("empno");
		
		//DAO 조회함수 실행
		Empdao empdao = new Empdao();
		Emp emp = empdao.getEmpListEmpno(empno);
		
		//객체 -> JSON
		JSONObject empjson = JSONObject.fromObject(emp);
		
		//값 저장
		request.setAttribute("empjson",empjson);
		
		//이동할 경로설정
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/selectAjax/empSelectEmpno.jsp");//JSON 데이터 출력되는 페이지
				
		return forward;
	}

}
