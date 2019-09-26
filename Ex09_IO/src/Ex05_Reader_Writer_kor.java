import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// char[]
// �ѱ� �۾� : �ѱ� 1���ڴ� 2byte => Stream �� 1byte �� �ѱ��۾� �Ұ���
// -> Reader, Writer �߻�Ŭ����


public class Ex05_Reader_Writer_kor {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("Ex01_Stream.java"); //�о
			fw = new FileWriter("copy_Ex01.txt"); // ������ / ���Ͼ����� ��������\
			
			
			int data = 0;
			while ((data = fr.read())!=-1) {
				fw.write(data);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				fw.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//compressde ����..
			//\n(����), \r(����). \t(��) ���ֱ�
			//if( data!= '\n' && data != '\r' && data != '\t' &&)
		}

	}
}
