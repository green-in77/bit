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
import kr.or.bit.dao.MvcRegisterDao;
import kr.or.bit.dto.MvcRegister;
import kr.or.bit.service.LoginProcessAction;
import kr.or.bit.service.MemberWriteAction;

//@WebServlet("/Register.do")  >> command
//실제로 들어오는 주소는 같아요
//Register.do?cmd=register 회원가입
//Register.do?cmd=registerlist 회원목록

//Url 방식 > 주소가 고정되면 안되요
//"*.do"  > a.do , b.do , aaaaa.do 

@WebServlet("*.do")
public class RegisterFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 받기
    	//String command  = request.getParameter("cmd")
    	//Url 방식은 cmd parameter 없어요
    	
    	//주소값
    	//register.do
    	//registerok.do
    	//regiseterlist.do
    	
    	//주소 요청의 판단 근거 (함수)
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	
    	//requestURI :  /WebServlet_7_Member_Model2_Mvc_Url/Register.do
    	//contextPath : /WebServlet_7_Member_Model2_Mvc_Url
    	//url_Command : /Register.do
    	
    	System.out.println("requestURI : " + requestURI);
    	System.out.println("contextPath : " + contextPath);
    	System.out.println("url_Command : " + url_Command);
    	
    	//추가코드/////////////////////////////////////////////////////////////////////////////////
    	ActionForward forward = null; // redirect 와 path 정보를 갖는 클래스
    	Action action = null; //Action 인터페이스 타입은 모든 자식객체의 주소를 가질 수 있다.
    	////////////////////////////////////////////////////////////////////////////////////////
    	
    	//2. 요청 판단 처리 
    	if(url_Command.equals("/Register.do")) { //회원가입 페이지 전달(업무)
    		//UI만 제공
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/Register/Register.jsp");
    		
    	}else if(url_Command.equals("/ok.do")){ //회원가입 처리 (업무)
    		//UI제공 + 로직처리
    		action = new MemberWriteAction();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/login.do")) { //로그인 화면처리
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/Register/login.jsp");
    		
    	}else if(url_Command.equals("/loginok.do")) { //로그인 로직처리
    		action = new LoginProcessAction();
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
