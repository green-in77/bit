import java.io.IOException;

public class Ex03_Exception_finally {
	
	static void startInstall() {
		System.out.println("Install");
	}
	static void copyFiles() {
		System.out.println("Copy Files");
	}
	static void fileDelete() {
		System.out.println("Delete Files");
	}
	
	public static void main(String[] args) {
		
		//Ex03_Exception_finally.copyFiles();
		try {
			copyFiles(); // 내꺼라 클래스명 생략
			startInstall();

			//throw : 개발자 임의로 문제 발생시켜서 예외처리 하도록 만드는 것.
			throw new IOException("Install 중 문제 발생");  // new 예외 문제 객체를 생성하는 것. // IOException 생성자 활용해서 메시지 전달. 
			
		}catch(Exception e) {
			//예외발생
			System.out.println("예외 메시지 출력 : " + e.getMessage());
		}finally { // 강제적 실행블럭 ( 예외발생여부와 상관없이 실행)
			fileDelete(); 
			// IO 자원 해제(close())
			// DB 연결 해제 (close())
		}
	
		// 주의사항 ★★★★★★★★★★★★★
		// 함수의 강제종료 : return; 있다 하더라도 finally 블럭은 무조건 실행하고 종료.
		
		System.out.println("Main END");
	}
	/*
	try {
		
	}catch(Exception e) {
		// 예외가 발생되면 실행됨. ( 예외가 발생되지 않으면 실행되지 않음.)
		
	}finally { // catch 없이도 쓸 수 있음.
		//이 블럭은 예외가 발생여부와 상관없이 [강제적]으로 [실행되는 구문]
		
	}
	*/
}
