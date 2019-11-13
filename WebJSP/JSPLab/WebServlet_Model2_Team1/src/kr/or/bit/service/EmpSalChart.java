package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Emp;
import net.sf.json.JSONArray;

public class EmpSalChart implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		Empdao empdao = new Empdao();
		
		List<Emp> emplist = empdao.getEmpListAll();
		
		JSONArray empListJson = JSONArray.fromObject(emplist);
		
		request.setAttribute("emplist", empListJson);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/chartAjax/empSalChart.jsp");
		
		return forward;
	}

}
