package kr.or.bit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonHelper {
	private static Connection conn;
	
	private SingletonHelper() {}

	public static Connection getConnection(String dsn){
		if ( conn == null) {
			try {
				if(dsn.equals("oracle")) {

					Class.forName("oracle.jdbc.OracleDriver");
					//새로운 연결 객체를 생성하는 코드 getConnection
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser","1004");

				} else if (dsn.equals("mysql")) {

					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitsqldb?useSSL=true","bituser","1004");

				}

			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
		return conn;	
	}
	
	public static void dbclose() { //객체의 주소값을 받아서...
		if(conn != null ) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}