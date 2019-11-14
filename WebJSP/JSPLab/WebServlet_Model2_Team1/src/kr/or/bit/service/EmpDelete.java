package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;

public class EmpDelete implements Action {
	//삭제
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String empno = request.getParameter("empno");
		//사번 받아오기
		
		Empdao empdao = new Empdao();
		//DAO 삭제 실행
		int result = empdao.empDelete(empno);
		
		String board_msg = "";
		String board_url = "empList.do";
		
		if(result > 0 ) { //삭제 성공시 
			board_msg = "삭제가 완료되었습니다.";
		}else {//삭제 실패시
			board_msg = "삭제를 실패하였습니다. 다시확인바랍니다.";
		}
		
		//값 저장하기
		request.setAttribute("board_msg",board_msg);
		request.setAttribute("board_url",board_url);
		
		//redirect로 가도록 경로저장
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/process/redirect.jsp");
		return forward;
	}

}
