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

/**
 * Servlet implementation class CarSaveServlet
 */
@WebServlet("/carsave")
public class CarSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CarSaveServlet() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//화면에 출력할 준비
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	    	
    	String product = request.getParameter("product");
    	
    	//Point(session)
    	//JSP : session.getId(); 기본적으로 내장객체 session 지원
    	//servlet : session 얻어서 사용해야함 >> request 한테서...
    	HttpSession session = request.getSession();
    	
    	System.out.println("session Id : " + session.getId());
    	
    	List<String> list = (ArrayList<String>) session.getAttribute("productlist");
    	System.out.println("list Collection : " + list);
    	
    	if(product == null) {
    		System.out.println("상품을 선택하지 않으셨습니다.");
    	}else {
    		if(list == null) {
    			System.out.println("list Collection is null");
    			list = new ArrayList<String>();
    			list.add(product);
    			session.setAttribute("productlist", list); //다른 페이지에서 공유하려면....
    		}else {
    			System.out.println("list Collection is not null");
    			list.add(product);
    		}
    	}
    	
    	out.print("<html>");
    		out.print("<boby>");
    			out.print("<a href='carbasket'>장바구니 보기</a>");
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
