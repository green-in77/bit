import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Ex03_Stream_ImageFile {
	public static void main(String[] args) throws Exception {
		String orifile = "C:\\IOTemp\\1.jpg";
		String tagetfile = "copy.jpg"; // App ����ϴ� �⺻ ���(����)
		
		FileInputStream fis = new FileInputStream(orifile);
		FileOutputStream fos = new FileOutputStream(tagetfile); 
		//C:\SmartWeb\JAVA\Labs\Ex09_IO -> ������Ʈ ������ �⺻
		
		int data = 0;
		while ( (data = fis.read()) != -1 ) {
			//read �����͸� write �ϱ�
			fos.write(data);
		}
		
		fis.close();
		fos.close();
		System.out.println("�۾��Ϸ�");

	}

}
