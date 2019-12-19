import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.FieldPosition;

// 대상 : File ( read, write ) : 물리적인 파일
// FileInputStream, FileOutputStream

//txt 기반 작업 : C:\\IOTemp\\a.txt >> HELLO

public class Ex02_POINT_File_read_write {
	public static void main(String[] args) {
		// POINT : I/O 작업은 대부분 가비지 컬렉터 대상이 아니다.
		// 명시적인 자원의 해제 작업을 해야 한다. ( close() >> 내부적으로 소멸자를 호출 )
		FileInputStream fs = null;
		FileOutputStream fos = null;
		String path = "C:\\IOTemp\\a.txt";
		try {
			//FileInputStream fs = new FileInputStream("C:\\IOTemp\\a.txt"); ////읽으려는 파일의 경로를 적음 파일의 // 변수의 scope 이 try 안
			fs=new FileInputStream(path); // 읽는 경로
			fos = new FileOutputStream("C:\\IOTemp\\new.txt"); //저장하려는 경로
			//write - new.txt 는 현재 없는 파일.
			//FileOutputStream 파일 생성기능을 가지고 있을까??
			// 파일을 write 할때 파일이 존재하지 않으면 파일을 생성합니다.

			//new FileOutputStream(path, true)
			//new FileOutputStream(C:\\IOTemp\\new.txt, true)
			//생성자 두번째 인자가 true : 기존 데이터 + 새로운 데이터 : append (추가)
			//생성자 두번째 인자가 false : default - 덮어쓰기 overwrite ( 파일은 그대로 두고 안에 내용만 덮어쓰기 )
			
			int data = 0;
			while ((data = fs.read()) != -1) {
				//System.out.println("정수 : " + data); //72,69,76,76,79
				//아스키코드값으로 변환되서 가져옴..
				//char c = (char)data; // 아스키 코드 값을 문자로 변환
				//System.out.println(c);
				fos.write(data); // write 하는 대상은 new.txt // 쓰려는 값을 parameter 로 써야함.
				//쓸때마다 덮어쓰기함.
				
			}
			
		} catch (Exception e) { //모든에러의 부모타입으로 받음.(어떤에러가 발생하든 catch 로 이동)
			e.printStackTrace();
		}finally {
			//fs.close(); // 파일 다 썼음. 닫아주기. ( 자원해제 ) fs 를 try 안에서 만들어서.... scope 이 try 블럭 안에 있음...
			try {
				fs.close(); // 자원이 없는데 닫으려고 하면 어떡해??ㅠㅠ
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		
	}
}
