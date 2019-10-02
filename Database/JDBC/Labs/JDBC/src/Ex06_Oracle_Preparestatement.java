import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

/*
Statement stmt = conn.createStatement();
String sql = "select empno, ename, sal from emp";
ResultSet rs = stmt.executeQuery(sql);
 
장점 : query문을 바꿔서 실행이 가능하다. (고정된 query 문, 컬럼,테이블,조건 고정)
단점 : query문이 동일하면 성능이 좋지만 변화가 생기면 성능이 떨어짐
select empno, ename, sal from emp where deptno=10;
select empno, ename, sal from emp where deptno=20;
parameter 값만 바꿔어도 다른 query 로 인식

대안
select empno, ename, sal from emp where deptno=? 먼저 DB에서 가지고 있게 하고
parameter 가 바뀌어도 같은 query 로 인정하게 만드는 방법.

권장사항
PreparedStatement pstmt = conn.preparStatement("select * from emp");
//쿼리문을 DB에 미리 보내서 -> 컴파일 -> 쿼리의 정보를 가지고 객체리턴 -> 실행
pstmt.executeQuery();

장점 : 보안상 해킹위험이 적음, 미리 쿼리문을 컴파일 시켜놨기 때문에 parameter 만 설정 (성능우수)
단점 : 재사용성이 떨어짐
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
			//물음표는 순서가 중요함 : 순서에 따라 값을 설정
			pstmt = conn.prepareStatement(sql); //실행객체를 얻을 떄 미리 query 문을 보내서 그 객체의 정보를 얻는다.

			//parameter 설정
			pstmt.setInt(1, 100); // 첫번째 물음표 30 // pstmt.setInt(2, 3); // 두번째 물음표 3 
			//parameter 만 바꿔서.. 항상 같은 쿼리로 인식, 구문분석등 실행하지 않음 -> 성능을 높이는 것(재사용)
			
			rs = pstmt.executeQuery();
			
			//************************************************************************************************************
			//공식같은 로직.. 데이터가 없는 경우 , 데이터가 1건인 경우, 데이터가 2건이상인 경우
			if(rs.next()) {
				
				do {//데이터가 있으면 계속 출력.
					System.out.println(rs.getInt("empno") + "/" + rs.getString("ename")+"/"+rs.getString("deptno"));
				}while(rs.next()); //데이터가 없으면 if 탈출.
				
			}else { //데이터가 없는 경우
				System.out.println("조회된 데이터가 없습니다.");
			}
			//************************************************************************************************************
		}catch(Exception e) {
			
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
		}

	}
}