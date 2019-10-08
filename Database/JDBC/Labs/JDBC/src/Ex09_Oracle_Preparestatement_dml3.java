import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

public class Ex09_Oracle_Preparestatement_dml3 {
	public static void main(String[] args) {
		//delete from dememp where deptno=deptno;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn=SingletonHelper.getConnection("oracle");
			String sql = "delete from dememp where deptno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 100);
			
			int row = pstmt.executeUpdate(); //insert, update, delete ��� ���๮�� ����
			
			if(row>0) {
				System.out.println("delete row count : " + row);
			}else {
				System.out.println("delete fail");
			}
			
		}catch(Exception e){
			System.out.println("delete fail" + e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
		}

	}

}