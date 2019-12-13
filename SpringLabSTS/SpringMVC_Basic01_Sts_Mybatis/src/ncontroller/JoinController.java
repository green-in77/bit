package ncontroller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {
	private MemberDao memberdao;

	@Autowired
	public void setMemberdao(MemberDao memberdao) {
		this.memberdao = memberdao;
	}
	
	//회원가입 페이지
	@RequestMapping(value = "join.htm", method = RequestMethod.GET)
	public String join() {
		return "joinus.join";
	}
	
	//회원가입 처리 (method overloading)
	@RequestMapping(value = "join.htm", method = RequestMethod.POST)
	public String join(Member member) {
		System.out.println(member);
		String view = null;
		
		try {
			int result = memberdao.insert(member);
			if(result>0) {
				view="redirect:/index.htm"; //같은 폴더가 아닐 경우 / root 로 옮겨가게 적어줘야 한다..
			}else {
				view="redirect:join.htm";
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("join : " + e.getMessage());
		}
		return view;
	}
	
	//회원가입 페이지
	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String login() {
		return "joinus.login";
	}
	
	
}
