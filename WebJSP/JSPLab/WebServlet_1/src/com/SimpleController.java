package com;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
서블릿(servlet)
java 파일로 웹 서비스를 할 목적으로 만든 파일
서블릿 파일 조건 : (웹 : request, response) 객체 사용 가능

1. extends HttpServlet 반드시 상속(웹 환경에서 요청, 응답) 처리 가능

2. SimpleController 서블릿

3. 서블릿은 이벤트 기반 동작(특정 함수들이 상황에 맞게 자동 호출)
	ex) 페이지가 로드되고 나면.. 함수 호출
	protected void doGet / protected void doPost
	2개의 함수가 자동호출 시점 ) 어느 이벤트 시 호출??
	클라이언트가 SimpleController 요청하면
	요청방식(GET)	 : 자동호출(doGet)		: protected void doGet(HttpServletRequest request, HttpServletResponse response)
		doGet() -> <a href="board.do?id=kglim>클릭<a>
		
	요청방식(POST)	 :  자동호출(doPOST)	: protected void doPost(HttpServletRequest request, HttpServletResponse response)
		doPost() -> <form method="post" action=""></form>
	
	3.1 클라이언트 정보를 얻는다 request.getParameter("");

4. jsp > localhost:8090/WebSite/index.jsp (요청)

	servlet > localhost:8090/WebSite/SimpleController.java(X)
	
	<url-pattern>/simple</url-pattern>
	servlet > localhost:8090/WebSite/simple
	
	서블릿(java) -> 컴파일 -> class 파일 생성 -> 실행 -> 결과 리턴
	기본적으로 서블릿은 멀티 쓰레드 환경을 제공
	
	12시 서버오픈 -> SimpleController (java) 파일
	-> 최초요청(localhost:8090/webSite/simple) -> servlet 컴파일(class 파일 : 실행파일)
	-> 요청 (doGet() or doPost()) 자동호출 -> Client 응답
	
	-> 재요청 -> 실행 -> doGet() or doPost() -> 응답
	
	-> 서버리부팅, 개발자 수정 등 다시 컴파일 됨
	
5. Model1 방식(Model2 기반의 MVC 패턴)
	5.1 JSP 만 가지고 개발 : Model1 방식(DAO, DTO) + JSP
	5.2 클라이언트의 모든 요청을 JSP 처리 합니다.
	5.3 UI + 업무(로직) : JSP 처리(단점 : 유지보수)
	
	5.4 Model2 기반의 MVC
	MVC(Model, View, Controller)
	--Model(순수한 자바 파일) : DTO(Emp.java), DAO(EmpDao.java : DB연결, 실행함수)
	--View : JSP(서버쪽 생산된 코드 : 화면출력 : EL & JSTL) ,HTML
	--Controller : Servlet(112 상황실)
	1. 클라이언트의 요청 파악(로그인, 게시판 글쓰기, 게시판 상세보기 업무 파악)
	2. 요청을 파악(처리 : 화면만 전달, DB연결 Insert, 객체 생성) 결정
	
6.
     <form action="loginok.jsp" method="post">
     >>192.168.0.3:8090/WebSite/loginok.jsp   
       
       
   <servlet>
	  	<servlet-name>simplecontroller</servlet-name>
	  	<servlet-class>com.SimpleController</servlet-class>
   </servlet>
   <servlet-mapping>
	  	<servlet-name>simplecontroller</servlet-name>
	  	<url-pattern>/simple</url-pattern>
   </servlet-mapping>  
       
     <form action="/simple" method="post">
     >>192.168.0.3:8090/WebSite/simple
*/
/**
 * Servlet implementation class SimpleController
 */
//@WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleController() {
        super();
        System.out.println("생성자 호출");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 요청");
		
		//1. 한글처리
		
		//2. 사용자 요청 파악(요청값 받기)
		String type = request.getParameter("type");
		
		//3. 요청에 따른 업무 수행
		Object resultobj = null;
		if(type == null || type.equals("greeting")) {
			resultobj = "hello world";
		}else if(type.equals("date")) {
			resultobj = new Date();
		}else {
			resultobj = "invalid String type";
		}
		
		//4. 요청 완료에 따른 결과를 저장하기
		//결과를 저장하는 방법 : request(현재 Page + include,forward), session(현재 프로젝트), application 객체
		request.setAttribute("result", resultobj);
		
		//5. 저장한 결과를 클라이언트에게 저장하기(View 지정)
		//화면을 출력할 페이지를 정하고 -> 출력할 데이터를 넘겨주고  => forward(제어권)
		RequestDispatcher dis = request.getRequestDispatcher("/simpleview.jsp");
		//출력할 페이지 정의
		//화면단 지정하고, 데이터 전달
		dis.forward(request, response); //request 객체의 주소
		//simpleview.jsp 에게 request 객체의 주소를 전달..
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
