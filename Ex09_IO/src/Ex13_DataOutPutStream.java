import java.io.DataOutputStream;
import java.io.FileOutputStream;

// 보조스트림
// Java 가 제공하는 8가지 기본타입지원 (타입별로 write, read)

// DataOutputStream, DataInputStream
// DataOutput 으로 쓰면 반드시 DataInput 으로 읽어야 함.

public class Ex13_DataOutPutStream {
	public static void main(String[] args) {
		int[] score = {100,60,55,94,23};
		
		try {
			FileOutputStream fos = new FileOutputStream("score.txt");
			DataOutputStream dos = new DataOutputStream(fos); // 
			
			for(int i = 0 ; i < score.length ; i++) {
				dos.writeInt(score[i]); // 정수값을 write
				//dos.writeUTF(str); 3byte 까지 인식. 한글이 절대 깨지지 않음.
			}
			dos.close();
			fos.close();
			
		}catch(Exception e) {
			
		}finally {
			
		}

	}
}
