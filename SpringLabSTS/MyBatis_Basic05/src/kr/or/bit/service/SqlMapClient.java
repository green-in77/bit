package kr.or.bit.service;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/*
  
나쁜 냄새가 나는 코드  
public class SqlMapClient {
	private static SqlSession session;
	//static 으로 모두가 공유된 하나의 주소를 사용.
	
	static {
		String resource = "SqlMapConfig.xml";
		try {
			  Reader reader =  Resources.getResourceAsReader(resource);
			  SqlSessionFactory factory=  new  SqlSessionFactoryBuilder().build(reader);
			  
			  session = factory.openSession();
			  //factory 가 공유된다.
			  
		}catch (Exception e) {
			
		}
	}
	
	public static SqlSession getSqlSession() {
		return session;
	}
	
}
*/

public class SqlMapClient {
	private static SqlSessionFactory sqlsessionfactory;
	//팩토리는 공유자원 : 팩토리가 생산하는 것이 session : session 은 공유되서는 안된다. 
	//factory 는 싱글톤
	static {
		String resource = "SqlMapConfig.xml";
		try {
			 Reader reader = Resources.getResourceAsReader(resource);
			 sqlsessionfactory = new SqlSessionFactoryBuilder().build(reader);
			 						//Builder 는 한번 쓰고 소멸
			 
		}catch(Exception e) {
			
		}
 
	}
	 public static SqlSessionFactory getSqlSession(){
		  return sqlsessionfactory;
	  }	
}
