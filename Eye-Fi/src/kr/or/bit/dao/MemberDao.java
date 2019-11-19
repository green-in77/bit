package kr.or.bit.dao;
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.or.bit.dto.Member;
import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.DB_Close;

public class MemberDao {
	public Member login(String userid, String userpw) {
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			String sql_login = "select userid, admin, code from member where userid=? and userpw=?";
			pstmt = conn.prepareStatement(sql_login);
			
			System.out.println(userid + "/" + userpw);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // ID와 PW가 모두 맞았다
				member = new Member();
				member.setUserid(rs.getString("userid"));
				member.setAdmin(rs.getInt("admin"));
				member.setCode(rs.getInt("code"));
			}
			
		}catch(Exception e) {
			System.out.println("login : " + e.getMessage());
		} finally {
			DB_Close.close(pstmt);
			DB_Close.close(rs);
			DB_Close.close(conn);
		}
		return member;
	}
}
