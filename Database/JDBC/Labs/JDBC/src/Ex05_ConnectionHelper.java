import java.sql.Connection;
import java.sql.SQLException;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

public class Ex05_ConnectionHelper {
	public static void main(String[] args) throws Exception {
		/*
		Connection conn = null;
		conn = ConnectionHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		System.out.println("���Ῡ�� : " + conn.isClosed());
		
		ConnectionHelper.close(conn);
		System.out.println("���Ῡ�� : " + conn.isClosed());
		System.out.println();
		
		Connection conn2 = null;
		conn2 = ConnectionHelper.getConnection("oracle","hr","1004");
		System.out.println(conn2.toString());
		System.out.println(conn2.getMetaData().getDatabaseProductName());
		System.out.println(conn2.getMetaData().getDatabaseProductVersion());
		System.out.println("���Ῡ�� : " + conn2.isClosed());
		
		ConnectionHelper.close(conn2);
		System.out.println("���Ῡ�� : " + conn2.isClosed());
		
		System.out.println();
		
		conn2 = null;
		conn2 = ConnectionHelper.getConnection("oracle","hr","1004");
		System.out.println(conn2.toString());
		System.out.println(conn2.getMetaData().getDatabaseProductName());
		System.out.println(conn2.getMetaData().getDatabaseProductVersion());
		System.out.println("���Ῡ�� : " + conn2.isClosed());
		
		ConnectionHelper.close(conn2);
		System.out.println("���Ῡ�� : " + conn2.isClosed());
		*/
		//1.���ᰴü�ּ� oracle.jdbc.driver.T4CConnection@7fac631b
		//2.���ᰴü�ּ� oracle.jdbc.driver.T4CConnection@5b87ed94
		//�ϳ��� APP �����Ҷ����� ��ü�� �����ϰ� ����ϴ� ���� �³�??
		//�ϳ��� ��ü�� ����� �����ϴ� ���.... = singleton >> JDBC �������� �ƴ�.... >> �����뤻����������
		/*
		Connection conn3 = null;
		conn3 = SingletonHelper.getConnection("oracle");
		System.out.println(conn3.toString());
		System.out.println(conn3.getMetaData().getDatabaseProductName());
		System.out.println(conn3.getMetaData().getDatabaseProductVersion());
		System.out.println("���Ῡ�� : " + conn3.isClosed());
		//oracle.jdbc.driver.T4CConnection@4629104a
		ConnectionHelper.close(conn3); //���������� �ǵ� conn�� null�� ���� ����.
		System.out.println("���Ῡ�� : " + conn3.isClosed());
		*/
		//*************************************************
		//�Ʒ� ����Ǵ� �̱����� ���ο� ���ᰴü�� �޾ƿ��� �ؾ���...
		//conn �� null �� �Ǿ�� ��!!!
		//*************************************************		
		/*
		Connection conn4 = null;
		conn4 = SingletonHelper.getConnection("oracle"); //������ ���ᰴü�� �ް� ��.(�ּҸ� �ְ� ������ X)
		System.out.println(conn4.toString());
		System.out.println(conn4.getMetaData().getDatabaseProductName());
		System.out.println(conn4.getMetaData().getDatabaseProductVersion());
		System.out.println("���Ῡ�� : " + conn4.isClosed());*/
		//oracle.jdbc.driver.T4CConnection@4629104a
		
		//DB������������. ������ �ּҰ� �ٲ�.. ���� �̱����� �� �ʿ䰡 ����....
		Connection conn3 = null;
		conn3 = SingletonHelper.getConnection("oracle");
		System.out.println(conn3.toString());
		System.out.println(conn3.getMetaData().getDatabaseProductName());
		System.out.println(conn3.getMetaData().getDatabaseProductVersion());
		System.out.println("���Ῡ�� : " + conn3.isClosed());
		
		SingletonHelper.dbclose();
		System.out.println("���Ῡ�� : " + conn3.isClosed());
		System.out.println();
		
		Connection conn4 = null;
		conn4 = SingletonHelper.getConnection("oracle");
		System.out.println(conn4.toString());
		System.out.println(conn4.getMetaData().getDatabaseProductName());
		System.out.println(conn4.getMetaData().getDatabaseProductVersion());
		System.out.println("���Ῡ�� : " + conn4.isClosed());
		SingletonHelper.dbclose();
		System.out.println("���Ῡ�� : " + conn3.isClosed());
	}
}