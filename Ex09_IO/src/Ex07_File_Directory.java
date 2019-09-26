import java.io.File;

/*
 I/O Ŭ����
 ���ϰ� ������ �ٷ�� Ŭ����
 
 JAVA : File Ŭ����(����, ����)
 >> a.txt ����, ����, ����, ������read��
 >> Temp ���� ����, ����, ���� read
 C# : File , Directory ���� 
 
 ���
 ������ : C:\\ , D:\\ 
 ����� : ���� ������ �߽����� ( DOS ���� cd ..)
 */
public class Ex07_File_Directory {
	public static void main(String[] args) {
		String path = "C:\\IOTemp\\file.txt"; // ���� ���� > ���� �������� ����.
		File f = new File(path);
		//f.createNewFile(); ���� �������
		System.out.println("���ϸ� : " + f.getName()); // ���� �̸� ��������
		System.out.println("��ü��� : "+f.getPath()); // ���� ��ü��Ρ�
		System.out.println("������ : " + f.getAbsolutePath()); // ���� ������
		System.out.println("�� ������?"+f.isDirectory()); // ��������? T/F��
		System.out.println("�� �����̴�?" + f.isFile()); // ��������? T/F��
		System.out.println("����ũ�� : "+f.length() + "byte"); // ���� �뷮
		System.out.println("�θ��� : " + f.getParent()); // ���� ������ ���� ��� ��ü
		System.out.println("���翩��(����,����) : "+f.exists()); // ����(����)�� �����ϴ�?�� 
		
		//f.delete(); // return T/F
		//f.canRead(); //���� �� �ִ�???
		
	}
}
