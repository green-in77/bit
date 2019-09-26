import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import kr.or.bit.ExceptionClass;

// Ŭ���� ����� ���� ������ �ִ� �ڿ��� ����ϴ� �����ڿ��� ������ ����ó���� �ϵ��� �ϴ� ���.
// ������ �ڿ� Test() throws ����Ŭ������1, ����Ŭ����2, ����Ŭ������3 ���...
// �Լ� �ڿ� void print() throws ����Ŭ������1, ����Ŭ����2, ����Ŭ������3 ���...

public class Ex04_Exception {

	public static void main(String[] args) {
		// ExceptionClass ex = new ExceptionClass("Hello"); try catch ���� ����
		
		ExceptionClass ec;
		try {
			ec = new ExceptionClass("hello");
			ec.call();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		//JAVA API ���� �����ϴ� �ڿ�....
		try {
			FileInputStream fi = new FileInputStream("C:\\temp\\a.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
