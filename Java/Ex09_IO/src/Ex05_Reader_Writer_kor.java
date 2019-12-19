import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// char[]
// 한글 작업 : 한글 1글자는 2byte => Stream 은 1byte 라 한글작업 불가능
// -> Reader, Writer 추상클래스


public class Ex05_Reader_Writer_kor {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("Ex01_Stream.java"); //읽어서
			fw = new FileWriter("copy_Ex01.txt"); // 쓸꺼야 / 파일없으면 생성가능\
			
			
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
			//compressde 압축..
			//\n(엔터), \r(공백). \t(탭) 없애기
			//if( data!= '\n' && data != '\r' && data != '\t' &&)
		}

	}
}
