import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

public class Ex07_Oracle_Preparestatement_dml {
	public static void main(String[] args) {
		//insert into dememp(empno, ename, sal, deptno)
		//values(?,?,?,?)
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn=SingletonHelper.getConnection("oracle");
			String sql = "insert into dememp(empno, ename, sal, deptno) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 5555);
			pstmt.setString(2, "������");
			pstmt.setInt(3, 1000);
			pstmt.setInt(4, 10);
			
			int row = pstmt.executeUpdate(); //insert, update, delete ��� ���๮�� ����
			
			if(row>0) {
				System.out.println("insert row count : " + row);
			}else {
				System.out.println("insert fail");
			}
			
		}catch(Exception e){
			System.out.println("insert fail" + e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
		}

	}

}