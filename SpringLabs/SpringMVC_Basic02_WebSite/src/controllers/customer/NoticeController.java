package controllers.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

//게시판 목록보기 업무

public class NoticeController implements Controller {

	public NoticeController() {
		System.out.println("[NoticeController]");
	}
	
	//spring 코드 상에서 new 작업(X) -> xml에서 객체생성
	private NoticeDao noticedao;
	//noticecontroller 는 noticedao가 필요하다(의존) -> xml 에서 생성하고 객체를 받아서 사용함 -> 멤버필드로 필요하다
	
	public void setNoticedao(NoticeDao noticedao) { //setter 로 Injection
		this.noticedao = noticedao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		//DAO 만들고 연결하고 실행하고 modelandview 에 결과물 저장하고 화면 전달
		
		//검색처리
		String _page = request.getParameter("pg");
		String _field = request.getParameter("f");
		String _query = request.getParameter("p");
		
		//default
		int page =1;
		String field = "TITLE";
		String query = "%%";
		
		//조건처리
		if(_page != null && !_page.equals("")) {
			page = Integer.parseInt(_page);
		}
		
		if(_field != null && !_field.equals("")) {
			field = _field;
		}
		
		if(_query != null && !_query.equals("")) {
			query = _query;
		}
		
		//DAO 데이터 받아오기
		List<Notice> list = noticedao.getNotices(page, field, query);
		
		//Spring > ModelAndView or Model 객체 제공
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("notice.jsp");
		
		return mav;
	}

}
