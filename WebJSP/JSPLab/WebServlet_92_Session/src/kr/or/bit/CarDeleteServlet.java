package kr.or.bit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CarDeleteServlet
 */
@WebServlet("/cardelete")
public class CarDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CarDeleteServlet() {
        super();
    }

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//화면에 출력할 준비
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();

    	//invalidate() : session 삭제
		HttpSession session = request.getSession();
		out.print("<html>");
			out.print("<boby>");
			
				if(session.getAttribute("productlist") != null) {
					session.invalidate();
				}else {
					out.print("장바구니가 이미 비어있습니다.");
				}
		
				out.print("<a href='Product.html'>상품 구매 페이지 이동</a><br>");
			out.print("</boby>");
		out.print("</html>");
		
		//특정한 session 변수값 삭제
		//session.removeAttribute("productlist");
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
