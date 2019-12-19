import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

// 출력형식 정의
// 친척 : printf , String.format()
public class Ex11_PrintWriter {
	public static void main(String[] args) {
		try {
			PrintWriter pw = new PrintWriter("C:\\IOTemp\\homework.txt");
			pw.println("*********************************************************");
			pw.println("*                                      HOMEWORK                                   *");
			pw.println("*********************************************************");
			pw.printf("%3s : %5d %5d %5d %5.1f", "아무개",100,90,50,(float)((100+90+50)/3));
			pw.println();
			pw.close();
			
			//homework.txt read(Line 단위 처리) Buffer
			FileReader fr = new FileReader("C:\\IOTemp\\homework.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String s = "";
			while ( (s = br.readLine()) != null ) {
				System.out.println(s);
			}
			br.close();
			fr.close();
			
		}catch (Exception e) {
			
		}finally {
			
		}
	}
}
