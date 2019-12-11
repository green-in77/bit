package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;
import com.model.MemberVO;

@Controller

public class JoinController {
	//DB작업
	//DAO에 의존 MemberDAOImpl
	//member field //interface 타입 : 객체의 생성과 조합(어떠한 부품도 표준화, 다형성..)
	private MemberDAO memberdao;

	@Autowired //by type
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}
	
	@RequestMapping(value="/join.do", method = RequestMethod.GET )
	public String form() {
		return "joinForm";
	}
	
	//@RequestParam(value="input name값", required = true, defaultValue = "기본값")String 받는변수명
	//회원가입, 게시판글쓰기 등은 보편적으로 parameter로 DTO를 받는 편.. 아래는 수업용 소스..
	/*
	Failed to bind request element: org.springframework.beans.TypeMismatchException: Failed to convert value of type [java.lang.String] to required type [int]; nested exception is java.lang.NumberFormatException: For input string: ""
	
	parameter 가 아예 안넘어가면 문제가 생기지 않음.
	숫자타입으로 받는데 parameter 가 오는데 빈 값으로 오는 경우 문제가 생김
		1. 무조건 값을 보낸다.
		2. required = false
		3. Integer 타입으로 받는다.(객체 타입으로)
	*/
	@RequestMapping(value="/join.do", method = RequestMethod.POST )
	public String submit(@RequestParam(value="id", required = true)String id,
						 @RequestParam(value="name")String name,
						 @RequestParam(value="pwd")String pwd,
						 @RequestParam(value="email", defaultValue = "1@1")String email,
						 @RequestParam(value="age", defaultValue = "1")Integer age)  {		
		
		String view = null;
		System.out.println(email + " / " + age);
		
		boolean joinresult = false;//memberdao.memberInsert(id, name, pwd, email, age);
		
		if(joinresult) {
			view = "joinSuccess";
		}else {
			view = "joinForm";
		}
		return view;
	}
}