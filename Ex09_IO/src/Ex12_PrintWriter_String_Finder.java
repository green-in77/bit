import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex12_PrintWriter_String_Finder {
	String baseDir = "C:\\IOTemp"; //�˻��� ���丮
	String word = "HELLO"; // �˻��� �ܾ�
	String save = "result.txt"; //HELLO �ܾ ����ִ� ������ ã�Ƽ� ���ϸ��� ����
	
	void Find() throws IOException{ //  Find �� ������ ����ó���� ������ �ؾ���.
		File dir = new File(baseDir);
		
		if(!dir.isDirectory()) { //���丮�� �ƴϸ�
			System.out.println("baseDir : " + baseDir+ "is not directory");
			System.exit(0);
		}
		PrintWriter writer = new PrintWriter(new FileWriter(save));
		// ������ ���� = save -> ���� ������ PrintWriter �� Ȱ���ؼ� �� �� ����.
		
		BufferedReader br = null;
		File[] files = dir.listFiles();
		
		for ( int i = 0; i < files.length ; i++ ) {
			if (!files[i].isFile()) { //������ �ƴϸ�
				continue; // �Ʒ��ڵ� skip //for ������ ���ư�
			}
			//�����̸�
			br = new BufferedReader(new FileReader(files[i]));
			
			//a.txt  �� ���徿 read
			//HELLO WROLD ����
			// �������� ������ ���δ����� �о
			String line="";
			while((line= br.readLine())!= null) {
				if ( line.indexOf(word) != -1) { //�ش� ������ index ����ȯ / -1�� ���°� . ���ڰ� ������
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