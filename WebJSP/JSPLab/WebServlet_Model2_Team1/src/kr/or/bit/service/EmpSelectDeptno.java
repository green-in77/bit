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
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String deptno = request.getParameter("deptno");
		
		Empdao empdao = new Empdao();
		List<Emp> emplist = empdao.getEmpListDeptno(deptno);
		
		JSONArray emplistjson = JSONArray.fromObject(emplist);
		
		request.setAttribute("emplistjson",emplistjson);
				
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/selectAjax/empSelectDeptno.jsp");
		
		return forward;
	}
}
