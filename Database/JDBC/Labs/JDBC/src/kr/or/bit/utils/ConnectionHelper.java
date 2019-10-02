package kr.or.bit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
Class.forName("oracle.jdbc.OracleDriver"); //메모리에 로드. >> new Driver
//1. DB연결
conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser","1004");

1. 모든 CRUD 선행 작업 시 위 코드 필수 -> 반복적인 작업을 줄이자(드라이버 로딩, 연결객체, 명령...자원해제) 많이 쓰이는 작업
2. 다른 계정이나 다른 DB 연결 고민..

//5. DB 연결해제
try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
 */
public class ConnectionHelper {
	//기능(연결....) >> 함수 >> 자주사용 static >> overloading >> interface

	//oracle, mysql 등 모두 연결할때 사용하기위해
	public static Connection getConnection(String dsn) {
		Connection conn = null;
		try {
			if(dsn.equals("oracle")) {

				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser","1004");

			} else if (dsn.equals("mysql")) {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitsqldb?useSSL=true","bituser","1004");

			}

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;		
	}

	public static Connection getConnection(String dsn, String id, String pwd) {
		Connection conn = null;
		try {
			if(dsn.equals("oracle")) {

				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",id,pwd);

			} else if (dsn.equals("mysql")) {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitsqldb?useSSL=true",id,pwd);

			}

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;		
	}
	
	public static void close(Connection conn) { //객체의 주소값을 받아서...
		if(conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) { //객체의 주소값을 받아서...
		if(rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) { //객체의 주소값을 받아서...
		if(stmt != null ) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement pstmt) { //객체의 주소값을 받아서...
		if(pstmt != null ) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}