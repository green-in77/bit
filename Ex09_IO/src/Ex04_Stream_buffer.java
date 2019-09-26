import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;

// File �� (DISK) (read, write)  ... ���� ���� �۾�...
// �� Byte �� read, write �ϱ� ������ ����..
// �׷��ϱ� �ѹ��� ��Ƽ� read, write ����.
// ������ �۾��� buffer �� �Ѵ�.
// file �� ���ؼ� read, write �Ҷ� �߰��� buffer �� �Ἥ (I/O) �ð��� ������...

//1. I/O ���ɰ���
//2. Line ���� �۾�

// I/O ���� ��Ʈ�� 
// BufferedInputStream, BufferOutputStream
// InputStream ����ؼ� �����ϴ� ��ü�� ��������.
public class Ex04_Stream_buffer {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("data.txt"); //���ϻ�������..
			bos = new BufferedOutputStream(fos);
			
			for (int i = 0 ; i <10 ; i++) {
				bos.write('A'); //65
			}
			/*
			 Java buffer ũ�� : 8 kbyte => 8192 byte
			 buffer �� �뷮�� �� ���ų� ������ close ���� ������ �����ִ� ���� �������� ����.
			 
			 1. buffer �ȿ� ������ 8k �� ä��� �ڵ����� ���.
			 2. buffer ������ ���� : flush() �Լ� ���� ȣ��
			 3. bos.close() : �� ���ο��� fluse() ȣ��
			 */
			bos.flush();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				//bos.close();
				//fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		

	}
}