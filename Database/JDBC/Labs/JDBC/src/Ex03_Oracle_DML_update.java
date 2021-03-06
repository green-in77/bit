import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex03_Oracle_DML_update {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //메모리에 로드. >> new Driver
			System.out.println("오라클 드라이버 로딩");
			
			//1. DB연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser","1004");
			System.out.println("연결끊어졌니?? " + conn.isClosed() + " (False >> 연결)"); //너 연결 끊어졌니?? -> 아니!!! false
			
			//2. 명령생성(CRUD)
			stmt = conn.createStatement();
			
			//3. 실행구문
			//입력받는 값을 update
			int deptno=0;
			
			Scanner sc = new Scanner(System.in);
					
			System.out.println("부서번호 입력");
			deptno = Integer.parseInt(sc.nextLine());
			
			//고전적인방법
			String sql = "update dememp set sal=0 where deptno="+deptno;
			
			//현대적인방법(parameter 처리 효율적으로..) >> 실제로 사용하는 것
			//String sql = "insert into dememp(empno,ename,deptno) values (?,?,?)";
			//String sql = "insert into dememp(empno,ename,deptno) values (100,'홍길동',10)";
			
			
			
			//4. 실행 (결과집합X, 반영된 행의 갯수 return)
			int resultrow = stmt.executeUpdate(sql);
			
			//5. 처리
			if(resultrow > 0) {
				System.out.println("반영된 행의 갯수 : " + resultrow);
			}else {
				//의미가 있다. // 반영된 행이 없다면 update는 조건에 맞는 결과가 없을 경우 반영되지 않을 수 있음.(정상적인 update 구분일 경우)
				System.out.println("Update Fail : " + resultrow);
			}		
		}catch(Exception e) {
			System.out.println("Update Fail 예외" + e.getMessage());
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}