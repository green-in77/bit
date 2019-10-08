import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
JDBC
1. Java �� ���ؼ� Oracle ���� �ϰ� C(insert)R(select)U(update)D(delete) �۾�
2. ��� DB ����Ʈ���� ��� ���� (Oracle , mysql , ms-sql) 
2.1 ��ǰ�� �´� ����̹��ʿ� (�� ���� ����Ʈ���� �ٿ�ε� �޾Ƽ� ���)
2.2 ����Ŭ (���� PC ����Ŭ DB ���� ��ġ) >> ojdbc6.jar (����̹� ����)
	C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
		->C:\SmartWeb\Database\JDBC\Connect_utils\oracleDriver
		
3. Cmd ����� Java Project ������ ����̹� ����ϱ� ���ؼ� ���� 
3.1 java Build Path (jar �߰�) �ϴ� �۾�
3.2 ����̹� ����غ� �Ϸ�  >> ����̹� ����� �� �ֵ��� �޸� (new ..)
3.3 class.forName("class �̸�") >> new ������ ȿ��
	�ڹ� 1.6 �̻���ʹ� 
	Console ����� ������Ʈ���� ������Ʈ ���� ������ ��� ��� �����մϴ�
	���񽺷δ�(http://docs.oracle.com/javase/6/docs/api/java/util/ServiceLoader.html)) ������� JDBC Driver�� �ڵ����� ��ϵ˴ϴ�.
	�׷��� Class.forName("com.mysql.jdbc.Driver") ���� �ڵ带 ȣ������ �ʾƵ� �˴ϴ�. :)

4.JAVA ( JDBC API)
4.1 import java.sql.*; �����ϴ� �ڿ� (��κ��� �ڿ��� : interface , class)
4.2 �����ڴ� interface �� ���ؼ� �۾� ( �ñ��� : why interface �ϱ�?  hint) Oracle �Ӹ� �ƴ϶� �پ��� ��� ��� )

5. DB����  -> ���� -> ���� -> ó��  -> �ڿ�����
5.1 ���� (CRUD) : select , insert , update , delete
5.2 ó�� : select ȭ�� ����Ҳ���  �ƴϾ�  �� Ȯ�θ� ...........
5.3 �ڿ����� (����)

*���� ���ڿ� (ConnectionString) ����
ä�� (client  ->  server �����ϱ� ���ؼ�)
��Ʈ��ũ DB (���� IP , PORT , SID(���� �����ͺ��̽� �̸�) , ���Ӱ��� , ���� ���) 
*/

public class Ex01_Oracle_Connection {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		//�޸𸮿� �ε�. >> new Driver
		System.out.println("����Ŭ ����̹� �ε�");
		
		//1. DB����
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser","1004");
														//����DB�� Port, id, pw
		//getConnection ���ο��� new Connection ���� -> connection �������̽��� �θ�� �ΰ��ֱ⶧����... ����Ŭ,mysql ��� ��� Ŀ�ؼ����� ����/ ������ ��ü�� ����.
		System.out.println("�����������?? " + conn.isClosed() + " (False >> ����)"); //�� ���� ��������?? -> �ƴ�!!! false
		
		//2. ���ɻ���(CRUD)
		Statement stmt = conn.createStatement();
		String sql = "select empno, ename, sal from emp";
		
		//3. ���ɽ���(ó��) >> ��ȸ
		//select != insert, update, delete (��� ������ ����)
		ResultSet rs = stmt.executeQuery(sql); // DB ������ ������ �������(memory) �����ؼ� Data read
		
		//4. ó��(��ȸ)
		while(rs.next()) { //next = select �� ��������� �ִ�???
			System.out.println(rs.getInt("empno") + "/" + rs.getString("ename")+"/"+rs.getInt("sal"));
			//							  1��°�÷�						2��°�÷�				  3��°�÷�
			//System.out.println(rs.getInt("1") + "/" + rs.getString("2")+"/"+rs.getInt("3")); ����
		}
		
		//5. ��������
		rs.close();
		conn.close();
		System.out.println("�����������?? " + conn.isClosed() + " (True >> ���������)"); //�� ���� ��������??
		
	}
}