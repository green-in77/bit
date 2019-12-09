package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	//요청 당 필요한 함수 구
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) {
		response.addCookie(new Cookie("auth", "1004"));
		//servlet 사용 방법과 동일
		
		return "cookie/CookieMake";
	}
	
	@RequestMapping("/cookie/view.do")
	//public String view(HttpServletRequest request) { 전통적인방식
	public String view(@CookieValue(value="auth", defaultValue = "1000") String auth) {
		System.out.println("클라이언트에서 read 한 쿠키 값 : " + auth);
		return "cookie/CookieView";
	}
}
