import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Reader, Writer 작업시 Buffer 사용하면 성능 향상
// Buffer 장점 : Line 단위 작업가능
public class Ex06_FileReader_FileWriter_Buffer {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("Ex01_Stream.java");
			br = new BufferedReader(fr);
			
		
			String line = "";
			for (int i = 0; (line = br.readLine()) != null ; i++) { // 더이상 읽을 값이 없으면 null 반환 // buffer readLine() 이 한줄씩 읽어옴..
				//System.out.println(line);
				
				//if(line.indexOf(";") != -1) { // Line 에 ; 이 있는 것만 출력... ( indexOf  = 해당 문자의 index 값 반환 )
					System.out.println(line); 
				//}
			}
		}catch (Exception e){
			
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}
