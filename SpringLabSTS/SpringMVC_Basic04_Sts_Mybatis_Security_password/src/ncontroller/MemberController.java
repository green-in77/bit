package ncontroller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import service.MemberService;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class MemberController {
	
	@Autowired
	private View jsonview;
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//회원가입페이지
	@RequestMapping(value="join.htm" , method=RequestMethod.GET)
	public String join() {
		return  "joinus.join"; //"join.jsp"; 
	}
	
	@RequestMapping(value = "idcheck.htm", method = RequestMethod.POST)
	public View idCheck(@RequestParam("userid") String userid, Model model) {
		int result = service.idCheck(userid);
		
		if (result > 0) {
			model.addAttribute("result", "fail");
		} else {
			model.addAttribute("result", "success");
		}
		return jsonview;
	}
	
	//회원가입처리
	@RequestMapping(value="join.htm" , method=RequestMethod.POST)
	public String join(Member member) {
		System.out.println(member.toString());
		
		int result = 0;
		String viewpage = "";
		member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd()));
		
		try {
			result = service.insertMember(member);
			if (result > 0) {
				System.out.println("삽입 성공");
				viewpage = "redirect:/index.htm";
			} else {
				System.out.println("삽입 실패");
				viewpage = "join.htm";
			}
		} catch (Exception e) {
			System.out.println("트랜잭션 : " + e.getMessage());
		}
		return viewpage;
	}
	
	//로그인화면
	@RequestMapping(value="login.htm",method = RequestMethod.GET)
	public String login(){
		return "joinus.login"; //Tiles 적용
	}
	
	//수정-비밀번호화면
	@RequestMapping(value="memberConfirm.htm",method=RequestMethod.GET)
	public String memberConfirm(){
		return "joinus.memberConfirm";
	}
	
	//수정-비밀번호 일치확인
	@RequestMapping(value="memberConfirm.htm",method=RequestMethod.POST)
	public String memberConfirm(@RequestParam("password") String rawPassword,Principal principal){
		String viewpage="";
		
		//회원정보
		Member member = service.getMember(principal.getName());
		
		//DB에서 가져온 암호화된 문자열
		String encodedPassword = member.getPwd();
		
		boolean result = bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
		
		if(result){
			viewpage="redirect:memberupdate.htm";
		}else{
			viewpage="redirect:memberConfirm.htm";
		}
		return viewpage;
	}
	
	//수정화면
	@RequestMapping(value="memberupdate.htm", method=RequestMethod.GET)
	public String memberUpdate(Model model, Principal principal){
		Member member = service.getMember(principal.getName());
		model.addAttribute("member", member);
		return "joinus.memberUpdate";
	}
	
	//수정처리
	@RequestMapping(value="memberupdate.htm", method=RequestMethod.POST)
	public String memberUpdate(Model model, Member member, Principal principal){
		
		Member updatemember = service.getMember(principal.getName());
		
		updatemember.setName(member.getName());
		updatemember.setCphone(member.getCphone());
		updatemember.setEmail(member.getEmail());
		updatemember.setPwd(bCryptPasswordEncoder.encode(member.getPwd()));
		
		service.updateMember(updatemember);
		
		return "redirect:/index.htm";
	}
}











