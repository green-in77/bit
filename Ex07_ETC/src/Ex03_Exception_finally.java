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
			copyFiles(); // ������ Ŭ������ ����
			startInstall();

			//throw : ������ ���Ƿ� ���� �߻����Ѽ� ����ó�� �ϵ��� ����� ��.
			throw new IOException("Install �� ���� �߻�");  // new ���� ���� ��ü�� �����ϴ� ��. // IOException ������ Ȱ���ؼ� �޽��� ����. 
			
		}catch(Exception e) {
			//���ܹ߻�
			System.out.println("���� �޽��� ��� : " + e.getMessage());
		}finally { // ������ ����� ( ���ܹ߻����ο� ������� ����)
			fileDelete(); 
			// IO �ڿ� ����(close())
			// DB ���� ���� (close())
		}
	
		// ���ǻ��� �ڡڡڡڡڡڡڡڡڡڡڡڡ�
		// �Լ��� �������� : return; �ִ� �ϴ��� finally ���� ������ �����ϰ� ����.
		
		System.out.println("Main END");
	}
	/*
	try {
		
	}catch(Exception e) {
		// ���ܰ� �߻��Ǹ� �����. ( ���ܰ� �߻����� ������ ������� ����.)
		
	}finally { // catch ���̵� �� �� ����.
		//�� ���� ���ܰ� �߻����ο� ������� [������]���� [����Ǵ� ����]
		
	}
	*/
}
