package kr.or.bit.service;

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

public class EmpUpdate implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ServletContext application = request.getServletContext();
		String imgpath = application.getRealPath("emp_img"); //이미지 저장 실경로
		//System.out.println(imgpath);
		
		int size = 1024*1024*10; //10M 네이버 계산기

		String filename1="";
		String orifilename1="";

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
			String empno = multi.getParameter("empno");
			String job = multi.getParameter("job");
			String mgr = multi.getParameter("mgr");
			String sal = multi.getParameter("sal");
			String comm = multi.getParameter("comm");
			String deptno = multi.getParameter("deptno");

			Enumeration filenames = multi.getFileNames(); //파일이름들
			
			String file1 = (String)filenames.nextElement(); //파일명 : 뒤에서부터 읽어옴..
			filename1 = multi.getFilesystemName(file1); //저장된 파일명
			orifilename1 = multi.getOriginalFileName(file1); //원 파일명
			
//			System.out.println("file1 : " + file1);
//			System.out.println("filename1 : " + filename1);
//			System.out.println("orifilename1 : " + orifilename1);
			
			//이미지 없으면 기본이미지 설정
			if( filename1 == null ) {
				filename1 = "avatar.png";
			}
			
			//객체저장
			Emp emp = new Emp();

			emp.setEmpno(Integer.parseInt(empno));
			emp.setJob(job);
			emp.setMgr(Integer.parseInt(mgr));
			emp.setSal(Integer.parseInt(sal));
			emp.setComm(Integer.parseInt(comm));
			emp.setDeptno(Integer.parseInt(deptno));
			 
			emp.setOrign_picture(orifilename1);
			emp.setSave_picture(filename1);
			emp.setSavefolder(imgpath);
			
			//DAO emp 수정함수 실행
			Empdao empdao = new Empdao();
			int result = empdao.empEdit(emp);
			
			String board_msg = "";
			String board_url = "empList.do";
			
			if(result > 0) { //수정되면
				board_msg = "수정되었습니다.";
			}else {//수정안되면
				board_msg = "수정에 실패하였습니다. 다시 확인바랍니다.";
			}
			
			//값 저장하기
			request.setAttribute("board_msg", board_msg);
			request.setAttribute("board_url", board_url);
			
		} catch (Exception e) {
			System.out.println("수정 이미지 저장 : " + e.getMessage());
		} //파일 업로드 완료
		//경로설정
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/process/redirect.jsp");
		
		return forward;
	}
}
