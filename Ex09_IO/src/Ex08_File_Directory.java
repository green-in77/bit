import java.io.File;

public class Ex08_File_Directory {
	public static void main(String[] args) {
		//System.out.println(args.length);
		//System.out.println(args[0]);
		
		if(args.length != 1) {
			System.out.println("���� : java ���ϸ� [���丮��]" );
			System.exit(0); // ���μ��� ��������
		}

		File f = new File(args[0]);
		//java Ex08... C:\\Temp
		
		if(!f.exists() || !f.isDirectory()) { //�������� �ʰų� or ���丮�� �ƴ϶��
			System.out.println("��ȿ���� ���� ����Դϴ�.");
			System.exit(0);
		}
		//���� �����ϴ� ��ζ��
		//dir ó�� ����� �����ְ� ����.
		
		File[] files = f.listFiles(); // listFiles File �迭 �������� ����Ʈ return
		//C:\\Temp\\a.txt
		//C:\\Temp\\b.txt
		//C:\\Temp\\����
		//File[] arryfiles = {new file(C:\\Temp\\a.txt), new file(C:\\Temp\\b.txt), new file(C:\\Temp\\����)} �� ���� �ּҸ� files �� return.
		
		for (int i = 0; i < files.length ; i++ ) {
			String name = files[i].getName(); // ���ϸ�, ������
			System.out.println(files[i].isDirectory()?"[DIR]"+name : name);
		}
		
		
	}
}
