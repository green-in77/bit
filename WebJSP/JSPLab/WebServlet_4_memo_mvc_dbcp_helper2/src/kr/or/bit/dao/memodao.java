package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import kr.or.bit.dto.memo;
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
public class memodao {

	//1건의 데이터 read (where 조건으로 사용되는 컬럼은 반드시 unique , primary key)
	public memo getMemoListById(String id) {
		/*
		  select id, email ,content from memo where id=?
		  memo m = new memo();
		  m.setId(rs.getInt(1)) ...
		  return m
		*/
		return null;
	}
	
	//전채 데이터 read (where 조건절이 없어요)
	public ArrayList<memo> getMemoList(){
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<memo> memolist = new ArrayList<>();
		
		try {
			String sql="select id, email , content from memo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				memo m = new memo();
				m.setId(rs.getString("id"));
				m.setEmail(rs.getString("email"));
				m.setContent(rs.getString("content"));
				memolist.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//반환하기
		}
		
		return memolist;
	}
	
	//Insert
	//parameter (id, email, content)
	//권장방법 : public int insertMemo(memo m){} >> FrameWork 자동화..
	public int insertMemo(String id, String email, String content) {
		Connection conn = ConnectionHelper.getConnection("oracle");
		int resultrow=0;
		PreparedStatement pstmt = null;
		
		try {
						
			String sql = "insert into memo(id, email, content) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			pstmt.setString(3, content);
			
			resultrow = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Insert : " + e.getMessage());
		}finally{
			DB_Close.close(pstmt);
			
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("insert 실패 : " + e.getMessage());
			}
			
		}
		return resultrow;
	}
	
	//Update
	public int updateMemo(memo m) {
		//update memo set email=? , content=? where id=?
		//m.getId();
		return 0;
	}
	
	//Delete
	public int deleteMemo(String id) {
		//delete from memo where id=?
		return 0;
	}
	
	//추가함수(ID존재유무 판단
	public String isCheckById(String id) {
		//아이디가 존재하면 : false
		//존재하지 않으면 : true
		Connection conn = ConnectionHelper.getConnection("oracle");
		String ischeck = "true";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql="select count(id) content from memo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt(1) > 0) {
					ischeck = "false";
				}
			}

		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {	
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ischeck;
	}

}







