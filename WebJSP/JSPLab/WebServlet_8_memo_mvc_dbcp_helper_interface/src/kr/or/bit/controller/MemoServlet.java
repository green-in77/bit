package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.MemoAddService;
import kr.or.bit.service.MemoIdCheckService;
import kr.or.bit.service.MemoListService;

/**
 * Servlet implementation class MemoServlet
 */
@WebServlet("*.do")
public class MemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemoServlet() {
        super();
    }

	private void doProcess (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청의 판단(X) 통으로 >> Insert에만 해당하는 Servlet
		String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	
    	ActionForward forward = null; // redirect 와 path 정보를 갖는 클래스
    	Action action = null; //Action 인터페이스 타입은 모든 자식객체의 주소를 가질 수 있다.
    	
    	if(url_Command.equals("/idcheck.do")) { //회원가입 페이지 전달(업무)
    		action = new MemoIdCheckService();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/memowrite.do")){ //회원가입 처리 (업무)
    		//UI제공 + 로직처리
    		action = new MemoAddService();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/memolist.do")) { //로그인 화면처리
    		action = new MemoListService();
    		forward = action.execute(request, response);
    		
    	}
    	
    	//4. 뷰 지정하고 forward
    	if(forward != null) {
    		if(forward.isRedirect()) { //true 없음..(URL 변경될 일이 없음..)
    			response.sendRedirect(forward.getPath());
    			
    		}else { //주소가 변하지 않기 때문에 모두 else 탐...
    			//forward view 단 페이지가 데이터를 처리
    			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	} 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
