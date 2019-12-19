import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Reader, Writer �۾��� Buffer ����ϸ� ���� ���
// Buffer ���� : Line ���� �۾�����
public class Ex06_FileReader_FileWriter_Buffer {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("Ex01_Stream.java");
			br = new BufferedReader(fr);
			
		
			String line = "";
			for (int i = 0; (line = br.readLine()) != null ; i++) { // ���̻� ���� ���� ������ null ��ȯ // buffer readLine() �� ���پ� �о��..
				//System.out.println(line);
				
				//if(line.indexOf(";") != -1) { // Line �� ; �� �ִ� �͸� ���... ( indexOf  = �ش� ������ index �� ��ȯ )
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
