package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
클라이언트 요청
1. 화면주세요(글쓰기, 로그인화면)		write.do
2. 처리해주세요(글쓰기완료, 로그인처리)	wirteok.do

article/newArticle.do 요청주소가 1개
(Get, Post 인지에 따라서 화면인지 처리인지 구분가능)
*/

import com.model.NewArticleCommand;
import com.service.ArticleService;
@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	
	//NewArticleController는 ArticleService에 의존한다.
	private ArticleService articleservice;
	
	@Autowired
	public void setArticleservice(ArticleService articleservice) {
		this.articleservice = articleservice;
	}

	@RequestMapping(method = RequestMethod.GET)
	//화면보여주기
	public String form() {
		return "article/newArticleForm";
		//viewResolver
		// /WEB-INF/views/ + article/newArticleForm + .jsp
	}
//----------------------------------------------------------------------------------------
	
	/*
	1. 전통적인 방법 Client 데이터 받기
		public String submit(HttpServletRequest request) {
			request.getParameter("")
			return null;
		}
		public ModelAndView submit(HttpServletRequest request) {
			NewArticleCommand article = new NewArticleCommand();
			article.setParentId(Integer.parseInt(request.getParameter("parentId")));
			article.setTitle(request.getParameter("title"));
			article.setContent(request.getParameter("content"));
			
			articleservice.wrtieArticle(article);
			//처리완료
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("newArticleCommand", article);
			mv.setViewName("article/newArticleSubmitted");
			return mv;
		}
		
	2. Spring parameter DTO 타입으로 받기	
		전제조건 : <input name="이름"> >> class DTO 의 member field 명이 같아야 한다.
		
		public String submit(NewArticleCommand command) {
		: 1. 자동 DTO 생성 : NewArticleCommand newArticleCommand = new NewArticleCommand();
			앞글자를 소문자로 만들어서 처리 : newArticleCommand 의 주소를 command 가 받아서 사용
		  
		  2. 넘어온 parameter 값을 setter 로 자동주입 ( input name == class DTO member field
		  3. NewArticleCommand 객체는 IOC 컨테이너 안에 생성 id="newArticleCommand"
		  4. mv.addObject("newArticleCommand", article); 자동실행
		  5. String return 으로 view 를 지정하면 알아서 간다..
		  
		public String submit(NewArticleCommand command) {
			articleservice.wrtieArticle(command);
			//처리완료
			return "article/newArticleSubmitted";
		}
		 
	3. 객체의 이름(key) 자동 생성되는 것이 싫다. 이름을 직점 설정하고 싶다.
		public String submit(@ModelAttribute("Articledata")NewArticleCommand command) {
		@ModelAttribute("Articledata") =>> 자동 DTO 생성 : NewArticleCommand Articledata = new NewArticleCommand(); 
	*/
	@RequestMapping(method = RequestMethod.POST)
	//처리하기
	public String submit(@ModelAttribute("Articledata")NewArticleCommand command) {
		articleservice.wrtieArticle(command);
		//처리완료
		return "article/newArticleSubmitted";
	}
}
