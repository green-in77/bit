package kr.or.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.memodao;
import kr.or.bit.dto.memo;

@WebServlet("/Memoservlet")
public class Memoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Memoservlet() {
        super();
    }
    
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); //클라언트에게 전달한 페이지의 정보 구성
		PrintWriter out = response.getWriter();
		
		//2. 요청파악
		String cmd = request.getParameter("cmd");
		
		//3. 요청에 따른 업무 수행

		//id존재여부 체크
		if (cmd.equals("check")) {
			
			String id = request.getParameter("id");
			System.out.println("id : " + id);
			
			memodao dao = new memodao();
			String ischeck = dao.isCheckById(id);
			
			//keyPoint out.print 로 값을 전달
			out.print(ischeck);
		
		//글쓰기
		}else if(cmd.equals("write")) {
			String id = request.getParameter("id");
			String email = request.getParameter("email");
			String memo = request.getParameter("memo");
			//out.print(id + "," + email + "," + memo);

			try{
				memodao dao = new memodao();
				int n = dao.insertMemo(id, email, memo);
			   
			   	if(n>0){
				    
			   		out.print("<script>");
			     	out.print("alert('등록되었습니다.');");
			     	out.print("</script>");
			     	
			     	RequestDispatcher dis = request.getRequestDispatcher("Memoservlet?cmd=list");
		    		dis.forward(request, response);
		    		
			   	}else{ //insert 실패 -> 보통 DB insert catch 를 타기 때문에 탈 가능성 없음..
				    out.print("<script>");
				    out.print("alert('등록실패..');");
				    out.print("location.href='memo.html';");
				    out.print("</script>");
			   	}
			   
			  }catch(Exception e){
				  out.print("<script>");
				  out.print("alert('등록실패 : "+ e.getMessage()+"');");
				  out.print("location.href='memo.html';");
				  out.print("</script>");
			  }
		//리스트
		}else if(cmd.equals("list")) {
			//view 단 페이지 별도 사용 : memolist.jsp  (이 방식이 추구하는 방식!!)
	    	try {
	    		//전체 데이터 조회 처리
	    		memodao dao = new memodao();
	    		ArrayList<memo> memolist = 
	    				dao.getMemoList();
	    		
	    		//요청결과 저장
	    		request.setAttribute("memolist", memolist);
	    		
	    		//view 페이지 설정
	    		RequestDispatcher dis = request.getRequestDispatcher("/memolist.jsp");
	    		dis.forward(request, response);
	    		
	    	}catch(Exception e) {
	    		System.out.println(e.getMessage());
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
