package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Emp;
import net.sf.json.JSONArray;

public class EmpSelectAll implements Action {
	//전체조회
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String cp = request.getParameter("cp");
		
		if(cp == null || cp.trim().equals("") || cp.equals("null")){
			//default 값 설정
			cp = "1";
		}
		
		Empdao empdao = new Empdao();
		//DAO 전체조회함수 실행 //객체 list return
		List<Emp> emplist = empdao.getEmpListAll(Integer.parseInt(cp));

		JSONArray emplistJson = JSONArray.fromObject(emplist);
		
		//값 저장
		request.setAttribute("emplist", emplistJson);
		
		//이동경로설정		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/selectAjax/empListPageing.jsp");
		
		return forward;
	}

}
