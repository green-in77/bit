package kr.or.bit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/carbasket")
public class CarBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CarBasketServlet() {
        super();
    }

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//화면에 출력할 준비
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	
    	//장바구니 목록보기
    	//session.setAttribute("productlist", list); //세션에 담아놨다...
    	HttpSession session = request.getSession();
    	System.out.println("sessionID : " + session.getId());
    	
/*
    	1. getSession() or getSession(true)
    		- HttpSession 타입의 session 객체가 이미 존재한다면 그 session 객체의 주소를 반환
    											존재하지 않으면 새로운 session 을 생성
    	
		2. getSession(false)
			- HttpSession 타입의 session 객체가 이미 존재한다면 그 session 객체의 주소를 반환
    											존재하지 않으면 null return
*/
    	out.print("<html>");
		out.print("<boby>");
			out.print("<h3>장바구니</h3>");
			if( session != null) {
				//구매한 상품 리스트를 볼 수 있다.
				List<String> list = (ArrayList<String>) session.getAttribute("productlist");
				out.print("상품목록 : " + list.toString() + "<br>");
			}else {
				out.print("장바구니가 비어있습니다.<br>");
			}
			out.print("<a href='Product.html'>상품 구매 페이지 이동</a><br>");
			out.print("<a href='cardelete'>장바구니 비우기</a>");
		out.print("</boby>");
	out.print("</html>");
    	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
