package kr.or.bit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
Class.forName("oracle.jdbc.OracleDriver"); //�޸𸮿� �ε�. >> new Driver
//1. DB����
conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser","1004");

1. ��� CRUD ���� �۾� �� �� �ڵ� �ʼ� -> �ݺ����� �۾��� ������(����̹� �ε�, ���ᰴü, ����...�ڿ�����) ���� ���̴� �۾�
2. �ٸ� �����̳� �ٸ� DB ���� ����..

//5. DB ��������
try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
 */
public class ConnectionHelper {
	//���(����....) >> �Լ� >> ���ֻ�� static >> overloading >> interface

	//oracle, mysql �� ��� �����Ҷ� ����ϱ�����
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
	
	public static void close(Connection conn) { //��ü�� �ּҰ��� �޾Ƽ�...
		if(conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) { //��ü�� �ּҰ��� �޾Ƽ�...
		if(rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) { //��ü�� �ּҰ��� �޾Ƽ�...
		if(stmt != null ) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement pstmt) { //��ü�� �ּҰ��� �޾Ƽ�...
		if(pstmt != null ) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}