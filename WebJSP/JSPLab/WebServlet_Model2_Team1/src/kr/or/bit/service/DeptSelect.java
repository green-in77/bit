package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Dept;
import net.sf.json.JSONArray;

public class DeptSelect implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		Empdao empdao = new Empdao();
		List<Dept> deptlist = empdao.getDeptno();
		
		JSONArray deptlistJson = JSONArray.fromObject(deptlist);
		
		request.setAttribute("deptlist", deptlistJson);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/selectAjax/deptSelete.jsp");
		return forward;
	}

}
