package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.bit.dto.memo;
import kr.or.bit.utils.Singleton_Helper;

/*
DB작업
CRUD 작업을 하기위한 함수를 생성하는 곳

memo table 에 데이터에 대해서
전체조회 : select id, email. content from memo;
조건조회 : select id, email, content from memo where id=?
수정	  : update memo set email=?, content=? where id=?
삭제	  : delete from memo where id=?
삽입	  : insert into memo(id, email, content) values(?,?,?)

default 5개
필요하시면 함수는 추가....
*/
public class memodao {
	Connection conn = null;
	
	public memodao() {
		conn=Singleton_Helper.getConnection("oracle");
	}
	
	//1건의 데이터 read(where 조건으로 사용되는 컬럼은 반드시 unique, primary key)
	public memo getMemoListById(String id) {
		/*
		 조건조회 : select id, email, content from memo where id=?
		 memo m = new memo();
		 m.setId(rs.getString(1));....
		 return m
		*/
		return null;
	}
	
	//전체 데이터 read(where 조건 없음)
	public List<memo> getMemoList(String id) throws SQLException{
		PreparedStatement pstmt = null;
		String sql = "select id, email, content from memo";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<memo> memolist = new ArrayList<memo>();
		
		while(rs.next()) {
			memo m = new memo();
			m.setId(rs.getString("id"));
			m.setEmail(rs.getString("email"));
			m.setContent(rs.getString("content"));
			
			memolist.add(m);
		}
		
		Singleton_Helper.close(rs);
		Singleton_Helper.close(pstmt);
		
		return memolist;
	}
}
