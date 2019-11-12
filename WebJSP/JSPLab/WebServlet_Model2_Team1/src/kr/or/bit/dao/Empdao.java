package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.bit.dto.Emp;
import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.DB_Close;

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
public class Empdao {
	
	//adminLogin 기능
	public boolean adminLogin(String userid, String pwd) {
		//관리자이면 True 아니면 False
		boolean isLogin = false;
		
		//DB연결
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			//관리자 테이블에 id,pw 맞는 데이터가 있는지...
			String sql_Login = "select userid from adminlist where userid=? and pwd=?";
			pstmt = conn.prepareStatement(sql_Login);
			
			pstmt.setString(1, userid);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //맞는 데이터가 있으면
				isLogin = true;
			}
			
		} catch(Exception e){
			System.out.println("AdminLogin : " + e.getMessage());
		} finally{
			DB_Close.close(pstmt);
			DB_Close.close(rs);
			DB_Close.close(conn);
		} 
		return isLogin;
	}
	
	//emp 전체 list
	public List<Emp> getEmpListAll(){
		List<Emp> emplist = new ArrayList<Emp>();
		
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql_select = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
			pstmt = conn.prepareStatement(sql_select);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Emp emp = new Emp();
				
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				
				emplist.add(emp);
			}
		} catch(Exception e) {
			System.out.println("Select All : " + e.getMessage());
		} finally {
			DB_Close.close(pstmt);
			DB_Close.close(rs);
			DB_Close.close(conn);
		}
		return emplist;
	}

	//emp 1건 조회
	public Emp getEmp(String empno) {
		Emp emp = new Emp();
		
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql_select = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where empno=?";
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setString(1, empno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
			}
		} catch(Exception e) {
			System.out.println("Select 1 : " + e.getMessage());
		} finally {
			DB_Close.close(pstmt);
			DB_Close.close(rs);
			DB_Close.close(conn);
		}
		return emp;
	}
	
	//emp 수정
	public int empEdit(Emp emp) {
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			String sql_update = "update emp set job=?, mgr=?, sal=?, comm=?, deptno=? where empno=?";
			pstmt = conn.prepareStatement(sql_update);
			
			pstmt.setString(1, emp.getJob());
			pstmt.setInt(2, emp.getMgr());
			pstmt.setInt(3, emp.getSal());
			pstmt.setInt(4, emp.getComm());
			pstmt.setInt(5, emp.getDeptno());
			pstmt.setInt(6, emp.getEmpno());
			
			row = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("update : " + e.getMessage());
		} finally {
			DB_Close.close(pstmt);
			DB_Close.close(conn);
		}
		return row;
	}
	
	
}
