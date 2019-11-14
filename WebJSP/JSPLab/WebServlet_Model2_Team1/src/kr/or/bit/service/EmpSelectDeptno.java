package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Emp;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EmpSelectDeptno implements Action{
	//deptno 기준 조회
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String deptno = request.getParameter("deptno");
		//값 받아와서 DAO deptno 조회함수 실행
		Empdao empdao = new Empdao();
		List<Emp> emplist = empdao.getEmpListDeptno(deptno);
		//객체list -> JSON
		JSONArray emplistjson = JSONArray.fromObject(emplist);
		//값 저장
		request.setAttribute("emplistjson",emplistjson);
		//경로설정		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/selectAjax/empSelectDeptno.jsp");
		
		return forward;
	}
}
