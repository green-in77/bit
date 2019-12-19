import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/*
 I/O
 1. stream (연결통로, 입출력통로, 중간매개체, 빨대)
 2. stream (통로크기 - 1Byte) >> 입출력의 기본단위 Byte >> Byte[]
 3. JAVA API 제공하는 클래스
 3.1 I/O 입출력 관련 처리 할 수 있음. ( 만들어진 클래스를 사용하는 것 )
 3.2 기본적인 처리단위는 Byte
 
 *추상클래스
 InputStream, OutputStream
 두개의 추상클래스를 상속(재정의) 클래스...
 
  대상에 따라서 구분
  	1.memory  : ByteArrayInputStream, ByteArrayOutputStream
  	2. File			: FileInputStream, FileOutputStream
  	
  추가적인 보조클래스 : File 관련
  : 컴퓨터에서 가장 느린 작업 : DISK read, write
  	Buffer ( I/O 성능 향상 ) : 데이터를 잠시 모아뒀다가 ...
  		BufferedInputStream (read) / BufferedOutPutStream (write)
  	 
 */
public class Ex01_Stream {
	public static void main (String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9}; // -128~127 정수
		//System.out.println(inSrcc[5]);
		
		byte[] outSrc = null; // 메모리를 가지고 있지 않다.
		
		//데이터를 read, write 대상이 배열(memory)
		ByteArrayInputStream input = null; // 메모리로 부터 read
		ByteArrayOutputStream output = null; //메모리에 write
		
		input = new ByteArrayInputStream(inSrc);
		//생성자를 통해서 inSrc 배열의 주소를 받아서 read 할 준비
		
		output = new ByteArrayOutputStream(); //write
		
		System.out.println("output before : " + Arrays.toString(outSrc));
		
		//공식같은 로직 ( 암기 )
		int data =0;
		while ((data = input.read()) != -1) { // read() 가 값이 없으면 -1을 반환함★★★★★★★★★
			System.out.println("data : " + data);
			//read 가 next() 기능을 포함하고 있음.
			
			output.write(data); // int 값을 가지고 있기 때문에 일단 임시저장
			// 자기자신에게 data 변수의 값을 read 해서 write 까지 가는 것.
			// write 의 대상 : ByteArrayOutputStream 이 자신의 통로에 read data 의 값을 가지고 있는 것
		}
		//write >> outsrc Array
		outSrc = output.toByteArray(); // 받은 int 타입을 Byte타입 배열로 만들어서 내보낸다.
		// 자기가 가지고 있는 read data 를 Byte 형태의 Array 로 만들어서 보낸다.
		// 배열의 주소값을 outSrc 변수에게 할당하는 것.
		System.out.println("output after : " + Arrays.toString(outSrc));
	}
}
