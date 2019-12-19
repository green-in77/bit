import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex12_PrintWriter_String_Finder {
	String baseDir = "C:\\IOTemp"; //검색할 디렉토리
	String word = "HELLO"; // 검색할 단어
	String save = "result.txt"; //HELLO 단어가 들어있는 파일을 찾아서 파일명을 저장
	
	void Find() throws IOException{ //  Find 를 쓰려면 예외처리를 강제로 해야함.
		File dir = new File(baseDir);
		
		if(!dir.isDirectory()) { //디렉토리가 아니면
			System.out.println("baseDir : " + baseDir+ "is not directory");
			System.exit(0);
		}
		PrintWriter writer = new PrintWriter(new FileWriter(save));
		// 생성할 파일 = save -> 안의 내용을 PrintWriter 를 활용해서 쓸 수 있음.
		
		BufferedReader br = null;
		File[] files = dir.listFiles();
		
		for ( int i = 0; i < files.length ; i++ ) {
			if (!files[i].isFile()) { //파일이 아니면
				continue; // 아래코드 skip //for 문으로 돌아감
			}
			//파일이면
			br = new BufferedReader(new FileReader(files[i]));
			
			//a.txt  한 문장씩 read
			//HELLO WROLD 만세
			// 각파일의 데이터 라인단위를 읽어서
			String line="";
			while((line= br.readLine())!= null) {
				if ( line.indexOf(word) != -1) { //해당 문자의 index 값반환 / -1은 없는것 . 문자가 있으면
					writer.write("word" + "="+files[i].getAbsolutePath()+"\n");					
				}
			}
			writer.flush();
		}
		br.close();
		writer.close();
	}
	public static void main(String[] args) {
		Ex12_PrintWriter_String_Finder StringFinder = new Ex12_PrintWriter_String_Finder();
		try {
			StringFinder.Find();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}