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
import kr.or.bit.service.AdminLogin;
import kr.or.bit.service.AdminLogout;
import kr.or.bit.service.EmpSelectAll;
import kr.or.bit.service.EmpSelete;
import kr.or.bit.service.EmpUpdate;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("*.do")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmpServlet() {
        super();
    }

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//들어오는 요청을 URI로 판단해서 service로 ....
		String requestURI = request.getRequestURI(); //전체경로
		String contextPath = request.getContextPath(); //home 경로
		String url_Command = requestURI.substring(contextPath.length()); //자르면 /*.do 만 나온다...
		
    	System.out.println("requestURI : " + requestURI);
    	System.out.println("contextPath : " + contextPath);
    	System.out.println("url_Command : " + url_Command);
		
		ActionForward forward = null; //path
		Action action = null; //action인터페이스를 사용하는 모든 자식객체(service)의 주소를 가질 수 있다.
		
		if(url_Command.equals("/adminLogin.do")) {
			//화면처리
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/adminLogin.jsp");
			
		}else if(url_Command.equals("/adminLoginOk.do")) {
			//로그인	//로직처리
			action = new AdminLogin();
			forward = action.execute(request, response);
		}else if(url_Command.equals("/adminLogout.do")) {
			//로그아웃
			action = new AdminLogout();
			forward = action.execute(request, response);
		}else if(url_Command.equals("/empList.do")) {
			//전체조회
			action = new EmpSelectAll();
			forward = action.execute(request, response);
		}else if(url_Command.equals("/empEdit.do")) {
			//1건 조회
			action = new EmpSelete();
			forward = action.execute(request, response);
		}else if(url_Command.equals("/empEditOk.do")) {
			//수정
			action = new EmpUpdate();
			forward = action.execute(request, response);
		}
		
//-------------------------------------------------------------------------------------------------------------
		
		if( forward!=null ) {
			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
			dis.forward(request, response);
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
