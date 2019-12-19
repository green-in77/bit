import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/*
 I/O
 1. stream (�������, ��������, �߰��Ű�ü, ����)
 2. stream (���ũ�� - 1Byte) >> ������� �⺻���� Byte >> Byte[]
 3. JAVA API �����ϴ� Ŭ����
 3.1 I/O ����� ���� ó�� �� �� ����. ( ������� Ŭ������ ����ϴ� �� )
 3.2 �⺻���� ó�������� Byte
 
 *�߻�Ŭ����
 InputStream, OutputStream
 �ΰ��� �߻�Ŭ������ ���(������) Ŭ����...
 
  ��� ���� ����
  	1.memory  : ByteArrayInputStream, ByteArrayOutputStream
  	2. File			: FileInputStream, FileOutputStream
  	
  �߰����� ����Ŭ���� : File ����
  : ��ǻ�Ϳ��� ���� ���� �۾� : DISK read, write
  	Buffer ( I/O ���� ��� ) : �����͸� ��� ��Ƶ״ٰ� ...
  		BufferedInputStream (read) / BufferedOutPutStream (write)
  	 
 */
public class Ex01_Stream {
	public static void main (String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9}; // -128~127 ����
		//System.out.println(inSrcc[5]);
		
		byte[] outSrc = null; // �޸𸮸� ������ ���� �ʴ�.
		
		//�����͸� read, write ����� �迭(memory)
		ByteArrayInputStream input = null; // �޸𸮷� ���� read
		ByteArrayOutputStream output = null; //�޸𸮿� write
		
		input = new ByteArrayInputStream(inSrc);
		//�����ڸ� ���ؼ� inSrc �迭�� �ּҸ� �޾Ƽ� read �� �غ�
		
		output = new ByteArrayOutputStream(); //write
		
		System.out.println("output before : " + Arrays.toString(outSrc));
		
		//���İ��� ���� ( �ϱ� )
		int data =0;
		while ((data = input.read()) != -1) { // read() �� ���� ������ -1�� ��ȯ�ԡڡڡڡڡڡڡڡڡ�
			System.out.println("data : " + data);
			//read �� next() ����� �����ϰ� ����.
			
			output.write(data); // int ���� ������ �ֱ� ������ �ϴ� �ӽ�����
			// �ڱ��ڽſ��� data ������ ���� read �ؼ� write ���� ���� ��.
			// write �� ��� : ByteArrayOutputStream �� �ڽ��� ��ο� read data �� ���� ������ �ִ� ��
		}
		//write >> outsrc Array
		outSrc = output.toByteArray(); // ���� int Ÿ���� ByteŸ�� �迭�� ���� ��������.
		// �ڱⰡ ������ �ִ� read data �� Byte ������ Array �� ���� ������.
		// �迭�� �ּҰ��� outSrc �������� �Ҵ��ϴ� ��.
		System.out.println("output after : " + Arrays.toString(outSrc));
	}
}
