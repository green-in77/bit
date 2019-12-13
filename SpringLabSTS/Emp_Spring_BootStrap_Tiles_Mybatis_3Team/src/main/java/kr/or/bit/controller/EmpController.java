package kr.or.bit.controller;

import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Emp;

@Controller
public class EmpController {
	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	//로그인 화면
	@RequestMapping(value="adminLogin.htm", method = RequestMethod.GET )
	public String login() {
		return "views/adminLogin";
	}
	
	//로그인 처리
	@RequestMapping(value="adminLogin.htm", method = RequestMethod.POST)
	public String login(String userid, String pwd, HttpSession session) {
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		int isLogin = empdao.adminLogin(userid, pwd);
		
		String view = "";
		
		if(isLogin > 0) { //id와 pwd가 맞으면..
			session.setAttribute("userid",userid);
			view = "redirect:index.htm";
		}else {
			view = "views/adminLogin";
		}
		return view;
	}
	
	//로그아웃 처리
	@RequestMapping(value="adminLogout.htm")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index.htm";
	}
	
	//총 사원수 조회 조회
	@RequestMapping(value="empList.htm")
	public String empTotalCount(String cp,Model model) {
		
		if(cp == null || cp.trim().equals("") || cp.equals("null")){
			//default 값 설정
			cp = "1";
		}
		
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		int totalcount = empdao.getEmpTotalCount();
		List<Emp> emplist = empdao.getEmpListAll(Integer.parseInt(cp));
		
		model.addAttribute("emplist", emplist);
		model.addAttribute("totalcount", totalcount);
		
		return "views/empList";
	}
	
	//전체 사원 리스트 조회
	@RequestMapping(value="empListOk.htm")
	public String empList(String cp, Model model) {
		if(cp == null || cp.trim().equals("") || cp.equals("null")){
			//default 값 설정
			cp = "1";
		}
		
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		List<Emp> emplist = empdao.getEmpListAll(Integer.parseInt(cp));
		//JSONArray emplistJson = JSONArray.fromObject(emplist);
		
		model.addAttribute("emplist", emplist);
		
		return "selectAjax/empListPageing";
	}
	
	//사원 1건 조회(수정화면) 
	@RequestMapping(value="empEdit.htm")
	public String empSelOne(String empno, Model model) {
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		Emp emp = empdao.getEmpListEmpno(empno);
		model.addAttribute("emp", emp);
		return "views/empEdit";
	}
	
	//수정처리
	@RequestMapping(value="empEditOk.htm")
	public String empEdit(Emp emp, HttpServletRequest request) {
		CommonsMultipartFile file = emp.getFile();
		String filename = "";
		
		filename = file.getOriginalFilename();
		String path = request.getServletContext().getRealPath("emp_img"); //서버의 실 경로
				
		String fpath = path + "\\" + filename;
				
		if(!filename.equals("")) { //실제 파일 업로드
			FileOutputStream fs=null;

			try {
				fs = new FileOutputStream(fpath);
				fs.write(file.getBytes());
				fs.close();
			} catch (Exception e) {
				System.out.println("filewrite : " + e.getMessage());
			}
		}
		
		emp.setOrign_picture(filename);
		emp.setSave_picture(filename);
		emp.setSavefolder(path);
		
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		int result1 = empdao.empEdit1(emp);
		
		if(result1 > 0) {
			int result2 = empdao.empEdit2(emp);
			System.out.println("성공1");
			if(result2 > 0) {
				System.out.println("성공2");
			}else {
				System.out.println("실패2");
			}
		}else {
			System.out.println("실패1");
		}
		return "redirect:empList.htm";
	}
	
	//사원등록 화면
	@RequestMapping(value="empAdd.htm")
	public String empAdd() {
		return "views/empAdd";
	}
	
	//사원등록 처리
	@RequestMapping(value="empAddOk.htm", method = RequestMethod.POST)
	public String empAdd(Emp emp, HttpServletRequest request) {
		CommonsMultipartFile file = emp.getFile();
		String filename = "";
		
		filename = file.getOriginalFilename();
		String path = request.getServletContext().getRealPath("emp_img"); //서버의 실 경로
				
		String fpath = path + "\\" + filename;
				
		if(!filename.equals("")) { //실제 파일 업로드
			FileOutputStream fs=null;

			try {
				fs = new FileOutputStream(fpath);
				fs.write(file.getBytes());
				fs.close();
			} catch (Exception e) {
				System.out.println("filewrite : " + e.getMessage());
			}
		}
		
		emp.setOrign_picture(filename);
		emp.setSave_picture(filename);
		emp.setSavefolder(path);
		
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		
		int result = empdao.empRegister1(emp);
		
		if(result > 0 ) {
			System.out.println("성공1");
			int result2 = empdao.empRegister2(emp);
			if(result2 > 0 ) {
				System.out.println("성공2");
			}else {
				System.out.println("실패2");
			}
		}else {
			System.out.println("실패1");
		}
		
		return "redirect:empList.htm";
	}
	
	//삭제처리
	@RequestMapping(value="empDelete.htm")
	public String empDel(int empno) {
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		int result1 = empdao.empDelete1(empno);
		if(result1 > 0) {
			System.out.println("성공1");
			int result2 = empdao.empDelete2(empno);
			if(result2 > 0) {
				System.out.println("성공2");
			}else {
				System.out.println("실패2");
			}
		}else {
			System.out.println("실패1");
		}	
		return "redirect:empList.htm";
	}	
}