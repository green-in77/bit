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
import kr.or.bit.service.DeptSelect;
import kr.or.bit.service.EmpDelete;
import kr.or.bit.service.EmpInsert;
import kr.or.bit.service.EmpSalChart;
import kr.or.bit.service.EmpSelectAll;
import kr.or.bit.service.EmpSelectDeptno;
import kr.or.bit.service.EmpSelectEmpno;
import kr.or.bit.service.EmpSelete;
import kr.or.bit.service.EmpTotalCount;
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
		
//    	System.out.println("requestURI : " + requestURI);
//    	System.out.println("contextPath : " + contextPath);
//    	System.out.println("url_Command : " + url_Command);
		
		ActionForward forward = null; //path
		Action action = null; //action인터페이스를 사용하는 모든 자식객체(service)의 주소를 가질 수 있다.
		
		if(url_Command.equals("/adminLogin.do")) {
			//로그인 //화면이동
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/adminLogin.jsp");
			
		}else if(url_Command.equals("/adminLoginOk.do")) {
			//로그인	//로직처리
			action = new AdminLogin();
			forward = action.execute(request, response);
			
		}else if(url_Command.equals("/adminLogout.do")) {
			//로그아웃 //로직처리
			action = new AdminLogout();
			forward = action.execute(request, response);
			
		}else if(url_Command.equals("/empList.do")) {
			//리스트화면조회 //로직처리
			action = new EmpTotalCount();
			forward = action.execute(request, response);
			
		}else if(url_Command.equals("/empListOk.do")) {
			//전체조회 //로직처리
			action = new EmpSelectAll();
			forward = action.execute(request, response);
		}else if(url_Command.equals("/empEdit.do")) {
			//1건 조회 //로직처리
			action = new EmpSelete();
			forward = action.execute(request, response);
			
		}else if(url_Command.equals("/empEditOk.do")) {
			//수정처리 //로직처리 
			action = new EmpUpdate();
			forward = action.execute(request, response);
			
		}else if(url_Command.equals("/empAdd.do")) {
			//등록화면 //화면이동
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/empAdd.jsp");
			
		}else if(url_Command.equals("/empAddOk.do")) {
			//등록처리 //로직처리
			action = new EmpInsert();
			forward = action.execute(request, response);
			
		}else if(url_Command.equals("/empDelete.do")) {
			//삭제처리 //로직처리
			action = new EmpDelete();
			forward = action.execute(request, response);
			
		}else if(url_Command.equals("/empSeleteEmpno.do")){
			//사원번호검색 //로직처리
			action = new EmpSelectEmpno();
			forward = action.execute(request, response);
			
		}else if(url_Command.equals("/empSeleteDeptno.do")){
			//부서번호 검색 //로직처리
			action = new EmpSelectDeptno();
			forward = action.execute(request, response);
			
		}else if(url_Command.equals("/empchart.do")) {
			//차트 //화면이동
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/empChart.jsp");
			
		}else if(url_Command.equals("/empSalChart.do")) {
			//사원별 급여 차트 //로직처리
			action = new EmpSalChart();
			forward = action.execute(request, response);
			
		}else if(url_Command.equals("/deptNo.do")) {
			//이미지 다운로드 //로직처리
			action = new DeptSelect();
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
