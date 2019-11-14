package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;

public class AdminLogin implements Action{
	//로그인
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 데이터 받기
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		//2. 데이터 확인
		//System.out.println(userid + " / " + pwd);
		
		//3. 처리
		Empdao empdao = new Empdao();
		Boolean isLogin = empdao.adminLogin(userid, pwd);
		
		String board_msg = "";
		String board_url = "";
		
		if(isLogin) { //id와 pwd가 맞으면..
			//세션 가져와서 login 정보 저장
			HttpSession session = request.getSession();
			session.setAttribute("userid",userid);
			
			board_msg = "관리자 로그인 성공";
			board_url = request.getContextPath()+"/index.jsp";
		}else {
			board_msg = "관리자 로그인 실패, 다시 시도해 주세요.";
			board_url = "adminLogin.do";
		}
		
		//4. 결과저장
		request.setAttribute("board_msg",board_msg);
		request.setAttribute("board_url",board_url);
		
		//5. 객체생성
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/process/redirect.jsp");
		
		return forward;
	}

}
