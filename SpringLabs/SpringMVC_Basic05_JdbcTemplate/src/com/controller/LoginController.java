package com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;

/*
 *  로그인 화면 : GET 요청 > loginForm
 *  로그인 처리 : POST 요청 > id, pwd > memberCheck 검증 > loginSuccess(빈페이지)
 *  
 *  조건 : 인증 성공하면 session 담기 > [기존 servlet 과 동일]
 * 
 *  public void test(HttpSession session){
 *    session.setAttribute("USERID", "hong")
 *  }
 * 
 */
@Controller
@RequestMapping("/login.do")
public class LoginController {
	@Autowired //memberfield 주입 가능하나 사용하지말자.. xml에서 표현할 수 없다..
	private MemberDAO memberdao;
	
	/*
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}*/

	//Get 로그인 화면
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "loginForm";
	}
	
	//Post 로그인 처리
	@RequestMapping(method = RequestMethod.POST)
	public String submit(String id, String pwd, HttpSession session) {
		String view = null;
		try {
			boolean loginresult = memberdao.memberCheck(id, pwd);
			if(loginresult) {
				session.setAttribute("USERID", id);
				view = "loginSuccess";
			}else {
				view = "loginForm";
			}
		} catch (SQLException e) {
			System.out.println("login : " + e.getMessage());
		}
		return view;
	}

}