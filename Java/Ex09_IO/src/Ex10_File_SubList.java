import java.io.File;
import java.util.ArrayList;

public class Ex10_File_SubList {
	static int totalfiles=0;
	static int totaldirs=0;
	
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("���� : java [�������ϸ�] [��θ�]");
			System.out.println("���� : java Ex10_File_SubList C:\\Temp");
			System.exit(0); //���μ��� ����
		}
		
		File f = new File(args[0]); // new File("C:\\Temp");
		if (!f.exists() || !f.isDirectory()) { // �������� �ʰų� ���丮�� �ƴ϶��
			System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			System.exit(0);
		}
		//�������� ���...
		printFileList(f);
		System.out.println("������ ���ϼ� : " + totalfiles);
		System.out.println("������ ������ : " + totaldirs);
	}
	
	static void printFileList(File dir) {
		System.out.println("[Full Path : " + dir.getAbsolutePath()+"]"); //������
		
		ArrayList<Integer> subdir = new ArrayList<Integer>();
		File[] files = dir.listFiles(); //parameter�� ���� ����� ����Ʈ�� ���Ϲ迭�� ����
		
		for (int i = 0; i < files.length ; i++) {
			String filename = files[i].getName(); // ���ϸ� �Ǵ� ������
			
			if (files[i].isDirectory()) { // ���丮��????
				filename = "<DIR> [" + filename + "]";
				subdir.add(i); // arraylist �� ���丮 ���� �ε����� ���
			} else {
				filename = filename + " / " + files[i].length() + "Byte"; 
			}
			System.out.println("    " + filename);
		}
		int dirnum = subdir.size(); // ���� ����� ���丮�� ����
		int filenum = files.length - dirnum; // �ѹ迭�� ���� - ���丮�� ���� = ���� ����� ������ ����
		
		//������ :  
		totaldirs += dirnum; // �� ���丮�� ���� ( ���� ���� ���� )
		totalfiles += filenum; // �� ������ ���� ( ���� ���� ���� )
		
		System.out.println("[Current dirNum] : " + dirnum);
		System.out.println("[Current filenum] : " + filenum);
		System.out.println("*****************************************************");
		
		//Point�ڡڡڡڡڡ�
		// ��ξ��� ���� -> ���� ���� -> ���� ���� �� ���� ��.
		// ����Լ�
		for (int j = 0 ; j < subdir.size() ; j++ ) { //���丮�� ������ŭ
			int index = subdir.get(j); // index�� ���丮�� �� ��ȣ�� �����ͼ�
			printFileList(files[index]); //����� ������ �� ��η� �����ؼ� ����.
		}
		
	}

}
