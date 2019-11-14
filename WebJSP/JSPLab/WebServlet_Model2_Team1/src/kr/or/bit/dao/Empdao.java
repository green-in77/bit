package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import kr.or.bit.dto.Dept;
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
			String sql_select ="select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno, i.ORIGN_PICTURE, i.SAVE_PICTURE, i.SAVEFOLDER from emp e join emp_img i on e.EMPNO = i.EMPNO"; 
			
			pstmt = conn.prepareStatement(sql_select);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	            java.util.Date date = sdf.parse(rs.getString("hiredate"));
	            Date sqlDate = new Date(date.getTime());
	            
				Emp emp = new Emp();
				
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(sqlDate);
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				
				emp.setOrign_picture(rs.getString("orign_picture"));
				emp.setSave_picture(rs.getString("save_picture"));
				emp.setSavefolder(rs.getString("savefolder"));
				
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

	//emp empno조건 조회
	public Emp getEmpListEmpno(String empno) {
		Emp emp = new Emp();
		
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql_select = "select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno, i.ORIGN_PICTURE, i.SAVE_PICTURE, i.SAVEFOLDER from emp e join emp_img i on e.EMPNO = i.EMPNO where e.empno=?";
			
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setString(1, empno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	            java.util.Date date = sdf.parse(rs.getString("hiredate"));
	            Date sqlDate = new Date(date.getTime());
	            
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(sqlDate);
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				
				emp.setOrign_picture(rs.getString("orign_picture"));
				emp.setSave_picture(rs.getString("save_picture"));
				emp.setSavefolder(rs.getString("savefolder"));
				
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
	
	//emp deptno 조건 조회
	public List<Emp> getEmpListDeptno(String deptno) {
		List<Emp> emplist = new ArrayList<Emp>();
		
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql_select = "select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno, i.ORIGN_PICTURE, i.SAVE_PICTURE, i.SAVEFOLDER from emp e join emp_img i on e.EMPNO = i.EMPNO where e.deptno=?";
			
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setString(1, deptno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Emp emp = new Emp();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	            java.util.Date date = sdf.parse(rs.getString("hiredate"));
	            Date sqlDate = new Date(date.getTime());
				
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(sqlDate);
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				
				emp.setOrign_picture(rs.getString("orign_picture"));
				emp.setSave_picture(rs.getString("save_picture"));
				emp.setSavefolder(rs.getString("savefolder"));
				
				emplist.add(emp);
			}
		} catch(Exception e) {
			System.out.println("Select * : " + e.getMessage());
		} finally {
			DB_Close.close(pstmt);
			DB_Close.close(rs);
			DB_Close.close(conn);
		}
		return emplist;
	}
	
	//emp 수정
	public int empEdit(Emp emp) {
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			conn.setAutoCommit(false); 
			
			String sql_emp_update = "update emp set job=?, mgr=?, sal=?, comm=?, deptno=? where empno=?";
			String sql_emp_img_update = "update emp_img set orign_picture=?, save_picture=?, savefolder=? where empno=?";
			
			pstmt = conn.prepareStatement(sql_emp_update);
			
			pstmt.setString(1, emp.getJob());
			pstmt.setInt(2, emp.getMgr());
			pstmt.setInt(3, emp.getSal());
			pstmt.setInt(4, emp.getComm());
			pstmt.setInt(5, emp.getDeptno());
			pstmt.setInt(6, emp.getEmpno());
			
			row = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(sql_emp_img_update);
			pstmt.setString(1, emp.getOrign_picture());
			pstmt.setString(2, emp.getSave_picture());
			pstmt.setString(3, emp.getSavefolder());
			pstmt.setInt(4, emp.getEmpno());
			
			row = pstmt.executeUpdate();
			
			if(row > 0 ) {
				conn.commit(); //2개의 delete 실 반영
			}
			
		} catch(Exception e) {
			System.out.println("update : " + e.getMessage());
		} finally {
			DB_Close.close(pstmt);
			DB_Close.close(conn);
		}
		return row;
	}
	
	//emp 등록
	public int empRegister(Emp emp) {
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			conn.setAutoCommit(false); //트랜잭션 : commit 수동처리..
			
			String sql_insert_emp = "INSERT INTO EMP(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql_insert_emp);
			
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			
			row = pstmt.executeUpdate();
			
			String sql_insert_emp_img = "INSERT INTO EMP_IMG(empno, orign_picture, save_picture, savefolder) VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql_insert_emp_img);
			
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getOrign_picture());
			pstmt.setString(3, emp.getSave_picture());
			pstmt.setString(4, emp.getSavefolder());
			
			row = pstmt.executeUpdate();
			
			if(row > 0 ) {
				conn.commit(); //2개의 insert 완료시
			}
			
		}catch(Exception e) {
			System.out.println("insert : " + e.getMessage());
		} finally {
			DB_Close.close(pstmt);
			DB_Close.close(conn);
		}
		return row;
	}

	//emp 삭제
	public int empDelete(String empno) {
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			conn.setAutoCommit(false); //트랜잭션 commit 수동
			String sql_emp_img_delete = "delete from emp_img where empno=?";
			
			String sql_emp_delete = "delete from emp where empno=?";
			pstmt = conn.prepareStatement(sql_emp_img_delete);
			pstmt.setInt(1, Integer.parseInt(empno));
			row = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(sql_emp_delete);
			pstmt.setInt(1, Integer.parseInt(empno));
			row = pstmt.executeUpdate();
			
			if(row > 0 ) {
				conn.commit(); //2개의 delete 실 반영
			}
			
		} catch(Exception e) {
			System.out.println("delete : " + e.getMessage());
		} finally {
			DB_Close.close(pstmt);
			DB_Close.close(conn);
		}
		return row;
	}
	
	//dept 전체 조회
	public List<Dept> getDeptno(){
		List<Dept> deptlist = new ArrayList<Dept>();
		
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql_dept_select = "select deptno, dname, loc from dept";
			pstmt = conn.prepareStatement(sql_dept_select);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Dept dept = new Dept();
				
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				
				deptlist.add(dept);
			}
		} catch(Exception e) {
			System.out.println("dept select : " + e.getMessage());
		} finally {
			DB_Close.close(pstmt);
			DB_Close.close(rs);
			DB_Close.close(conn);
		}
		return deptlist;
	} 
}
