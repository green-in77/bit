// 오류
// 1. 에러(error) : 개발자가 코드적으로 해결할 수 없는 문제. (ex. 네트워크 장애, 메모리, 하드웨어 이상 등)
// 2. 예외(Exception) : 개발자의 코드처리문제 ( 로직문제 등...) > 예측가능하다.
//			예외 발생 시 프로그램이 강제종료됨.
// 예외처리 가능 : 프로그램을 정상적으로 수정하는 것이 아니고 문제 발생 시 비정상 종료를 막는 것.
// 정말 예외가 발생했다 : 코드수정 해야함..
/*
 try{
 	문제가 될 수 있는 코드
 }catch(Exception e) { // e 라는 parameter 가 문제 원인의 객체를 참조...
 	처리하는 코드.(문제가 발생 & 문제의 종류 인지.)
 	.. 관리자에게 메일.... or ..log 파일 .... // 처리코드 열어서 별도의 수정을 해야한다!!!!!!!!!
 }finally{
 	문제가 발생하던, 하지않던 강제적으로 수행해야하는 구문.
 	DB 연결 닫기...
 	★★★★★★강제적인 함수종료 (return) 을 하더라도 finally 는 실행됨.★★★★★★
 }
 
 */


public class Ex01_Exception {

	public static void main(String[] args) {
		 System.out.println("Main Start");
		 	System.out.println("Main Logic 처리");
		 	try { // 강제종료만 막은 것, 문제가 해결되지 않음.
		 		
		 		System.out.println(0/0); // java 는 0으로 나누는 코드 에러. >> 이 코드는 개발자가 최종적으로 수정해야 한다.
		 		//Exception in thread "main" java.lang.ArithmeticException: / by zero
		 		//자바는 런타임(실행) 시 예외(Exception)이 발생하면 문제에 해당하는 예외 클래스를 자동생성한다. >> java.lang.ArithmeticException
		 		
		 	} catch(Exception e) {
		 		System.out.println(e.getMessage());
		 	}
		 
		 System.out.println("Main End");
	}

}
