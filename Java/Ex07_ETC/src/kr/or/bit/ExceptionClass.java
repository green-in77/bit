package kr.or.bit;

import java.io.IOException;

public class ExceptionClass {
	public ExceptionClass (String path) throws IOException{ // throws  : 개발자에게 강제로 예외처리를 하게 만듬.
		
	} 
	public void call() throws ArithmeticException, IndexOutOfBoundsException {
		System.out.println("call 함수 start");
		int i = 0/0;
		System.out.println("call 함수 end");
	}

}
