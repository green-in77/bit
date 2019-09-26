import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Ex03_Stream_ImageFile {
	public static void main(String[] args) throws Exception {
		String orifile = "C:\\IOTemp\\1.jpg";
		String tagetfile = "copy.jpg"; // App 사용하는 기본 경로(저장)
		
		FileInputStream fis = new FileInputStream(orifile);
		FileOutputStream fos = new FileOutputStream(tagetfile); 
		//C:\SmartWeb\JAVA\Labs\Ex09_IO -> 프로젝트 폴더가 기본
		
		int data = 0;
		while ( (data = fis.read()) != -1 ) {
			//read 데이터를 write 하기
			fos.write(data);
		}
		
		fis.close();
		fos.close();
		System.out.println("작업완료");

	}

}
