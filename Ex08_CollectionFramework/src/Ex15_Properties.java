import java.util.Properties;

/*
 Map �������̽��� ������ Ŭ����
 Ư���� ������ Ŭ���� < String , String > key type, value type
 ������Ų Ŭ����. : Properties
 ������
 APP ����Ӽ����� (ȯ�溯��) : ���α׷��� ����, ���ϰ��, ���뺯��
 ex)
 datasample.properties ����
 DB ����� ID, PWD ��Ƴ��� �ҷ�����
 �ٱ���ó��
  
 */
public class Ex15_Properties {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("master", "bit@bit.or.kr");
		prop.setProperty("version", "1.1.1.1");
		prop.setProperty("defalutpath","C:\\Temp\\images" );
		//////////////////////////////////////////////////////////////
		// ������ ���� ����������...
		System.out.println(prop.getProperty("master")); // Ű ���� �ָ� value ���� ��..
		System.out.println(prop.getProperty("version"));
		System.out.println(prop.getProperty("defalutpath"));

	}
}
