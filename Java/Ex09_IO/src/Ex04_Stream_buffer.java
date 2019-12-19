import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;

// File 에 (DISK) (read, write)  ... 가장 느린 작업...
// 한 Byte 씩 read, write 하기 때문에 느림..
// 그러니까 한번에 모아서 read, write 하자.
// 모으는 작업을 buffer 가 한다.
// file 을 통해서 read, write 할때 중간에 buffer 를 써서 (I/O) 시간을 줄이자...

//1. I/O 성능개선
//2. Line 단위 작업

// I/O 보조 스트림 
// BufferedInputStream, BufferOutputStream
// InputStream 상속해서 구현하는 객체와 의존관계.
public class Ex04_Stream_buffer {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("data.txt"); //파일생성도함..
			bos = new BufferedOutputStream(fos);
			
			for (int i = 0 ; i <10 ; i++) {
				bos.write('A'); //65
			}
			/*
			 Java buffer 크기 : 8 kbyte => 8192 byte
			 buffer 는 용량이 다 차거나 강제로 close 하지 않으면 갖고있는 값을 전달하지 않음.
			 
			 1. buffer 안에 내용이 8k 다 채우면 자동으로 비움.
			 2. buffer 강제로 비우기 : flush() 함수 강제 호출
			 3. bos.close() : 이 내부에서 fluse() 호출
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