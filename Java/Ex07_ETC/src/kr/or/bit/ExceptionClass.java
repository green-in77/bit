package kr.or.bit;

import java.io.IOException;

public class ExceptionClass {
	public ExceptionClass (String path) throws IOException{ // throws  : �����ڿ��� ������ ����ó���� �ϰ� ����.
		
	} 
	public void call() throws ArithmeticException, IndexOutOfBoundsException {
		System.out.println("call �Լ� start");
		int i = 0/0;
		System.out.println("call �Լ� end");
	}

}
