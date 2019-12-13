package main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.bit.dto.User;
import kr.or.bit.service.SqlMapClient;

public class program {
	public static void main(String[] args) {
		//method scope
	    SqlSessionFactory sqlsession=SqlMapClient.getSqlSession(); //팩토리를 받아오는 것.
	    
	    SqlSession session= sqlsession.openSession();//scope 가 쓰레드 안(main)
	    
	    User user = (User)session.selectOne("Emp.getone", "ALLEN");
	    						//selectOne : 객체 하나 반환 
	    System.out.println(user.getEmpno());
	    
	    session.close();
	    //쓰레드 안에서 사용을 다 했으면 session 을 닫는다.
	    

	}

}



