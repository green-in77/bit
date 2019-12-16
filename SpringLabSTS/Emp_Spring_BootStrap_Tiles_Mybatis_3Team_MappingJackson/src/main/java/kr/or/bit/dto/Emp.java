package kr.or.bit.dto;

import java.text.SimpleDateFormat;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
/*
	CREATE TABLE EMP
		(EMPNO number not null,
		ENAME VARCHAR2(10),
		JOB VARCHAR2(9),
		MGR number ,
		HIREDATE date,
		SAL number ,
		COMM number ,
		DEPTNO number );
	--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';
	
	create table emp_img (
 		empno number not null, --사번 
 		orign_picture varchar2(30), -- 원본사진이름 
 		save_picture varchar2(40), -- 저장사진이름 
 		savefolder varchar2(30) -- 저장경로 
	);
	
	alter table emp
 	add
  	constraint pk_empno
  	primary key (
   		empno
  	);
  
	alter table emp_img
 	add
  	constraint fk_emp_to_img
  	foreign key (
   		empno
  	)
  	references emp (
   		empno
  	);
	
*/
//사원 1명을 담을 객체
public class Emp {
	private int empno; //사번
	private String ename; //이름
	private String job; //직종
	private int mgr; //사수
	private String hiredate; //입사일
	private int sal; //급여
	private int comm; //수당
	private int deptno; //부서번호
	
	private String orign_picture; // 원본사진이름
	private String save_picture; // 저장사진이름
	private String savefolder; //저장경로
	
	public Emp() {}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}
	
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getOrign_picture() {
		return orign_picture;
	}

	public void setOrign_picture(String orign_picture) {
		this.orign_picture = orign_picture;
	}

	public String getSave_picture() {
		return save_picture;
	}

	public void setSave_picture(String save_picture) {
		this.save_picture = save_picture;
	}

	public String getSavefolder() {
		return savefolder;
	}

	public void setSavefolder(String savefolder) {
		this.savefolder = savefolder;
	}

	//다중 파일업로드를 위해서
	private CommonsMultipartFile file;

	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}	
	
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + ", orign_picture=" + orign_picture
				+ ", save_picture=" + save_picture + ", savefolder=" + savefolder + "]";
	}

}
