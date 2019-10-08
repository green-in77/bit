import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex02_Oracle_DML {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //�޸𸮿� �ε�. >> new Driver
			System.out.println("����Ŭ ����̹� �ε�");
			
			//1. DB����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser","1004");
			System.out.println("�����������?? " + conn.isClosed() + " (False >> ����)"); //�� ���� ��������?? -> �ƴ�!!! false
			
			//2. ���ɻ���(CRUD)
			stmt = conn.createStatement();
			
			//3. ���౸��
			//String sql = "insert into dememp(empno,ename,deptno) values (100,'ȫ�浿',10)";
			
			//�Է¹޴� ���� insert
			int empno=0;
			String ename="";
			int deptno=0;
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("��� �Է�");
			empno = Integer.parseInt(sc.nextLine());
			
			System.out.println("�̸� �Է�");
			ename = sc.nextLine();
			
			System.out.println("�μ���ȣ �Է�");
			deptno = Integer.parseInt(sc.nextLine());
			
			//�������ι��
			String sql = "insert into dememp(empno,ename,deptno) values ("+empno+",'"+ename+"',"+deptno+")";
			
			//�������ι��(parameter ó�� ȿ��������..) >> ������ ����ϴ� ��
			//String sql = "insert into dememp(empno,ename,deptno) values (?,?,?)";
			//String sql = "insert into dememp(empno,ename,deptno) values (100,'ȫ�浿',10)";
			
			//4. ���� (�������X, �ݿ��� ���� ���� return)
			int resultrow = stmt.executeUpdate(sql);
			
			//5. ó��
			if(resultrow > 0) {
				System.out.println("�ݿ��� ���� ���� : " + resultrow);
			}else {
				//�ǹ̰� ����. �ݿ��� ���� ���ٸ� // insert �� �ȵƴٸ�... ����!!!!!catch ���ܷ� ����...
				System.out.println("Insert Fail : " + resultrow);
			}		
		}catch(Exception e) {
			System.out.println("Insert Fail ����" + e.getMessage());
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