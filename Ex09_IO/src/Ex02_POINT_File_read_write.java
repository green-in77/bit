import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.FieldPosition;

// ��� : File ( read, write ) : �������� ����
// FileInputStream, FileOutputStream

//txt ��� �۾� : C:\\IOTemp\\a.txt >> HELLO

public class Ex02_POINT_File_read_write {
	public static void main(String[] args) {
		// POINT : I/O �۾��� ��κ� ������ �÷��� ����� �ƴϴ�.
		// ������� �ڿ��� ���� �۾��� �ؾ� �Ѵ�. ( close() >> ���������� �Ҹ��ڸ� ȣ�� )
		FileInputStream fs = null;
		FileOutputStream fos = null;
		String path = "C:\\IOTemp\\a.txt";
		try {
			//FileInputStream fs = new FileInputStream("C:\\IOTemp\\a.txt"); ////�������� ������ ��θ� ���� ������ // ������ scope �� try ��
			fs=new FileInputStream(path); // �д� ���
			fos = new FileOutputStream("C:\\IOTemp\\new.txt"); //�����Ϸ��� ���
			//write - new.txt �� ���� ���� ����.
			//FileOutputStream ���� ��������� ������ ������??
			// ������ write �Ҷ� ������ �������� ������ ������ �����մϴ�.

			//new FileOutputStream(path, true)
			//new FileOutputStream(C:\\IOTemp\\new.txt, true)
			//������ �ι�° ���ڰ� true : ���� ������ + ���ο� ������ : append (�߰�)
			//������ �ι�° ���ڰ� false : default - ����� overwrite ( ������ �״�� �ΰ� �ȿ� ���븸 ����� )
			
			int data = 0;
			while ((data = fs.read()) != -1) {
				//System.out.println("���� : " + data); //72,69,76,76,79
				//�ƽ�Ű�ڵ尪���� ��ȯ�Ǽ� ������..
				//char c = (char)data; // �ƽ�Ű �ڵ� ���� ���ڷ� ��ȯ
				//System.out.println(c);
				fos.write(data); // write �ϴ� ����� new.txt // ������ ���� parameter �� �����.
				//�������� �������.
				
			}
			
		} catch (Exception e) { //��翡���� �θ�Ÿ������ ����.(������� �߻��ϵ� catch �� �̵�)
			e.printStackTrace();
		}finally {
			//fs.close(); // ���� �� ����. �ݾ��ֱ�. ( �ڿ����� ) fs �� try �ȿ��� ����.... scope �� try �� �ȿ� ����...
			try {
				fs.close(); // �ڿ��� ���µ� �������� �ϸ� ���??�Ф�
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		
	}
}
