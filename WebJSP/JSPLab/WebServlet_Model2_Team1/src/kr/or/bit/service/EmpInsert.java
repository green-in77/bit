package kr.or.bit.service;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Emp;

public class EmpInsert implements Action {
	//등록
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 데이터 받기.
		ServletContext application = request.getServletContext();
		String imgpath = application.getRealPath("emp_img"); //이미지 저장 실경로
		//System.out.println(imgpath);
		
		int size = 1024*1024*10; //10M 네이버 계산기

		String filename1=""; //저장되는 파일 명 변수
		String orifilename1=""; //원 파일명 변수

		MultipartRequest multi;
		
		try {
			multi = new MultipartRequest(
					request, //기전에 있는  request 객체의 주소값 
					imgpath, //실 저장 경로 (배포경로)
					size, //10M
					"UTF-8",
					new DefaultFileRenamePolicy() //파일 중복(upload 폴더 안에:a.jpg -> a_1.jpg(업로드 파일 변경) )
			);
			
			//값 받아오기
			String ename = multi.getParameter("ename");
			String empno = multi.getParameter("empno");
			String job = multi.getParameter("job");
			String mgr = multi.getParameter("mgr");
			String hiredate = multi.getParameter("hiredate");
			String sal = multi.getParameter("sal");
			String comm = multi.getParameter("comm");
			String deptno = multi.getParameter("deptno");

//			System.out.println(ename +"/" + ename + "/" + job + "/" + mgr);
//			System.out.println(hiredate +"/" + sal + "/" + comm + "/" + deptno);
			
			Enumeration filenames = multi.getFileNames(); //파일이름들
			
			String file1 = (String)filenames.nextElement(); //파일명 : 뒤에서부터 읽어옴..
			filename1 = multi.getFilesystemName(file1); //저장된 파일명
			orifilename1 = multi.getOriginalFileName(file1); //원 파일명
			
			if( filename1 == null ) {
				filename1 = "avatar.png";
			}
			
//			System.out.println("file1 : " + file1);
//			System.out.println("filename1 : " + filename1);
//			System.out.println("orifilename1 : " + orifilename1);
			
			//날짜 변환
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date date = sdf.parse(hiredate);
            Date sqlDate = new Date(date.getTime());
			
            //데이터 객체에 저장
			Emp emp = new Emp();
			emp.setEname(ename);
			emp.setEmpno(Integer.parseInt(empno));
			emp.setJob(job);
			emp.setMgr(Integer.parseInt(mgr));
			emp.setHiredate(sqlDate);
			emp.setSal(Integer.parseInt(sal));
			emp.setComm(Integer.parseInt(comm));
			emp.setDeptno(Integer.parseInt(deptno));
			 
			emp.setOrign_picture(orifilename1);
			emp.setSave_picture(filename1);
			emp.setSavefolder(imgpath);
			 
			//DAO 가입함수 실행(DB insert)
			Empdao empdao = new Empdao();
			int result = empdao.empRegister(emp);
			
			String board_msg = "";
			String board_url = "";
			
			if(result > 0) { //insert 성공시
				board_msg = "등록되었습니다.";
				board_url = "empList.do";
			}else { //insert 성공시
				board_msg = "등록에 실패하였습니다. 다시 확인바랍니다.";
				board_url = "empAdd.do";
			}
			//값 저장
			request.setAttribute("board_msg", board_msg);
			request.setAttribute("board_url", board_url);
			
		} catch (Exception e) {
			System.out.println("이미지 저장 : " + e.getMessage());
		} //파일 업로드 완료
		
		//이동경로 설정
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/process/redirect.jsp");
		
		return forward;
	}

}
