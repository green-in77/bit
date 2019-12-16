package kr.or.bit.dao;

import java.util.List;

import kr.or.bit.dto.Dept;
import kr.or.bit.dto.Emp;

/*
DB작업
CRUD 작업을 하기위한 함수를 생성하는 곳

memo table 에 데이터 에 대해서
전제조회 : select id, email ,content from memo
조건조회 : select id, email ,content from memo where id=?
수정 : update memo set email=? , content=? where id=?
삭제 : delete from memo where id=?
삽입 : insert into memo(id,email,content) values(?,?,?)

default 5개
필요하시면 함수는 추가 .....^^
*/
public interface Empdao {
	
	//adminLogin 기능
	public int adminLogin(String userid, String pwd);
	
	//게시물 총 건수 구하기
	public int getEmpTotalCount();
	
	//emp 전체 list
	public List<Emp> getEmpListAll(int cp);

	//emp empno조건 조회
	public Emp getEmpListEmpno(String empno);
	
	//emp deptno 조건 조회
	public List<Emp> getEmpListDeptno(String deptno);
	
	//emp 수정
	public int empEdit1(Emp emp);
	public int empEdit2(Emp emp);
	
	//emp 등록
	public int empRegister1(Emp emp);
	public int empRegister2(Emp emp);

	//emp 삭제
	public int empDelete1(int empno);
	public int empDelete2(int empno);
	
	//dept 전체 조회
	public List<Dept> getDeptno();
	
	//chart 조회
	public List<Emp> getEmpListChart();
}
