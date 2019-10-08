import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

/*
Statement stmt = conn.createStatement();
String sql = "select empno, ename, sal from emp";
ResultSet rs = stmt.executeQuery(sql);
 
���� : query���� �ٲ㼭 ������ �����ϴ�. (������ query ��, �÷�,���̺�,���� ����)
���� : query���� �����ϸ� ������ ������ ��ȭ�� ����� ������ ������
select empno, ename, sal from emp where deptno=10;
select empno, ename, sal from emp where deptno=20;
parameter ���� �ٲ� �ٸ� query �� �ν�

���
select empno, ename, sal from emp where deptno=? ���� DB���� ������ �ְ� �ϰ�
parameter �� �ٲ� ���� query �� �����ϰ� ����� ���.

�������
PreparedStatement pstmt = conn.preparStatement("select * from emp");
//�������� DB�� �̸� ������ -> ������ -> ������ ������ ������ ��ü���� -> ����
pstmt.executeQuery();

���� : ���Ȼ� ��ŷ������ ����, �̸� �������� ������ ���ѳ��� ������ parameter �� ���� (���ɿ��)
���� : ���뼺�� ������
*/
public class Ex06_Oracle_Preparestatement {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select empno, ename, deptno from emp where deptno=?";
			//where empno=? and ename=? and sal>?
			//����ǥ�� ������ �߿��� : ������ ���� ���� ����
			pstmt = conn.prepareStatement(sql); //���ఴü�� ���� �� �̸� query ���� ������ �� ��ü�� ������ ��´�.

			//parameter ����
			pstmt.setInt(1, 100); // ù��° ����ǥ 30 // pstmt.setInt(2, 3); // �ι�° ����ǥ 3 
			//parameter �� �ٲ㼭.. �׻� ���� ������ �ν�, �����м��� �������� ���� -> ������ ���̴� ��(����)
			
			rs = pstmt.executeQuery();
			
			//************************************************************************************************************
			//���İ��� ����.. �����Ͱ� ���� ��� , �����Ͱ� 1���� ���, �����Ͱ� 2���̻��� ���
			if(rs.next()) {
				
				do {//�����Ͱ� ������ ��� ���.
					System.out.println(rs.getInt("empno") + "/" + rs.getString("ename")+"/"+rs.getString("deptno"));
				}while(rs.next()); //�����Ͱ� ������ if Ż��.
				
			}else { //�����Ͱ� ���� ���
				System.out.println("��ȸ�� �����Ͱ� �����ϴ�.");
			}
			//************************************************************************************************************
		}catch(Exception e) {
			
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
		}

	}
}