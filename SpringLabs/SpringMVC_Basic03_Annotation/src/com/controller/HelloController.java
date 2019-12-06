package com.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
implements Controller > handleRequest
단점 : Controller 가 하나의 요청만을 처리 : 요청이 10개라면 Controller 10개

Annotation 사용하면 method 단위로 매핑할 수 있다.
결국 : 하나의 cController 다수의 요청을 처리할 수 있다. : 대신 함수 10개 생성

1. implements Controller 매핑단위가 클래스
2. @Controller 매핑단위가 함수
	@RequestMapping("*.do") 사용해서 주소 매핑
	>> HelloController >> bean 생성
*/
@Controller
public class HelloController {
	
	@RequestMapping("/hello.do") //<a href="hello.do">hello.do</a>
	public ModelAndView hello() {
		System.out.println("Hello.do Start");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting", getGreeting());
		mv.setViewName("Hello");
		
		return mv;
	}
	
	//필요하다면 일반함수는 만들어서 사용가능
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String data ="";
		
		if(hour >= 6 && hour <=10) {
			data = "학습시간";
		}else if(hour >= 11 && hour <= 15) {
			data = "배고픈시간";
		}else if(hour >= 16 && hour <= 18) {
			data = "졸린시간";
		}else {
			data = "go home";
		}
		
		return data;
	}
}
