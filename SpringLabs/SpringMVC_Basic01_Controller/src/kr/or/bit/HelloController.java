package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
	
	public HelloController() {
		System.out.println("HelloController 객체 생성");
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController 요청 실행 : handleRequest 함수 실행");
		
		//업무수행 (게시판 목록보기, 글쓰기....)
		//데이터 담고, view 지정
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("name","hong"); //request.setAttribute();
		mav.setViewName("Hello"); //view 지정...
		
		return mav;
	}

}
