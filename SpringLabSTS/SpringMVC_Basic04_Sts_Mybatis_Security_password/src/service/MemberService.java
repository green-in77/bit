package service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MemberDao;
import vo.Member;

@Service
public class MemberService {
	@Autowired
	private SqlSession sqlsession;
	
	public int idCheck(String userid){
		MemberDao dao = sqlsession.getMapper(MemberDao.class);
		int result=0;
		try {
			result = dao.idCheck(userid);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("ID중복 : " + e.getMessage());
		}
		return result;
	}
	
	@Transactional
	public int insertMember(Member member) throws Exception {
		int result = 0;
		MemberDao dao = sqlsession.getMapper(MemberDao.class);
		try {
			result = dao.insertMember(member);
			System.out.println(member.getUserid());
			result = dao.insertRoll(member.getUserid());
			
		} catch (Exception e) {
			System.out.println("회원가입 : " + e.getMessage());
			throw e;
		}
		return result;
	}
	
	public int loginCheck(String username, String password){
		MemberDao dao = sqlsession.getMapper(MemberDao.class);
		int result = 0;
		try {
			result = dao.loginCheck(username, password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("로그인체크 : " + e.getMessage());
		}
		return result;
	}
	
	public Member getMember(String userid){
		MemberDao dao = sqlsession.getMapper(MemberDao.class);
		Member member=null;
		try {
			member = dao.getMember(userid);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("회원조회 : " + e.getMessage());
		}
		return member;
	}
	
	public int updateMember(Member member){
		MemberDao dao = sqlsession.getMapper(MemberDao.class);
		int result = 0;
		try {
			result = dao.updateMember(member);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("정보수정 : " + e.getMessage());
		}
		return result;
	}
	
	
	
}
