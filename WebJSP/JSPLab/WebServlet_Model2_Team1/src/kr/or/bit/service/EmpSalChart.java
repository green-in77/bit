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
	//사원별 급여 chart
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		Empdao empdao = new Empdao();
		//DAO 전체리스트 조회해서 list로 return
		List<Emp> emplist = empdao.getEmpListAll();
		//객체list -> Json
		JSONArray empListJson = JSONArray.fromObject(emplist);
		//값 저장
		request.setAttribute("emplist", empListJson);
		//이동경로
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/chartAjax/empSalChart.jsp");
		
		return forward;
	}

}
