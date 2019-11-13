package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Emp;
import net.sf.json.JSONObject;

public class EmpSelectEmpno implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String empno = request.getParameter("empno");
		
		Empdao empdao = new Empdao();
		Emp emp = empdao.getEmpListEmpno(empno);
		
		JSONObject empjson = JSONObject.fromObject(emp); 
		request.setAttribute("empjson",empjson);
				
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/selectAjax/empSelectEmpno.jsp");
		
		return forward;
	}

}
