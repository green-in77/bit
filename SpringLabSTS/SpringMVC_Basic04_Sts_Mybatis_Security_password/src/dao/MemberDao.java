package dao;

import java.sql.SQLException;
import vo.Member;

public interface MemberDao {
	
	//회원정보 얻기
	public Member getMember(String uid) throws ClassNotFoundException, SQLException;
	
	//회원가입
	public int insertMember(Member member) throws ClassNotFoundException, SQLException;
	
	//가입 후 권한처리
	public int insertRoll(String uid) throws ClassNotFoundException, SQLException;
	
	//회원정보 수정하기
	public int updateMember(Member member) throws ClassNotFoundException, SQLException;
	
	//로그인 체크
	public int loginCheck(String username, String password) throws ClassNotFoundException, SQLException; 
	
	//회원 ID 검증
	public int idCheck(String userid) throws ClassNotFoundException, SQLException;
	
}
