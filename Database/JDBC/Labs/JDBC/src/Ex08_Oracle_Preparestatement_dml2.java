import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

public class Ex08_Oracle_Preparestatement_dml2 {
	public static void main(String[] args) {
		//update dememp set sal=100 where deptno=? and job=?;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn=SingletonHelper.getConnection("oracle");
			String sql = "update dememp set sal=100 where deptno=? and job=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10);
			pstmt.setString(2, "PRESIDENT");
			
			int row = pstmt.executeUpdate(); //insert, update, delete 모두 실행문은 같음
			
			if(row>0) {
				System.out.println("update row count : " + row);
			}else {
				System.out.println("update fail");
			}
			
		}catch(Exception e){
			System.out.println("update fail" + e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
		}

	}

}
