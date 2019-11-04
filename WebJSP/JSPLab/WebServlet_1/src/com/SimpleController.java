package com;

import java.io.IOException;
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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
