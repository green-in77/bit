import java.io.File;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_File_Format {
	public static void main(String[] args) {
		// format Ŭ���� https://cafe.naver.com/bitsmartweb/352
		
		//ȭ�����ó��
		DecimalFormat df = new DecimalFormat("#,###.0"); 
		String result = df.format(1234567.89); // ���ڿ� �̱� ������ ����Ұ�
		String result2 = df.format(1000000000); // ���ڿ� �̱� ������ ����Ұ�
		System.out.println(result);
		System.out.println(result2);
		
		//��¥����ó��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		String strDate = sdf.format(new Date());
		System.out.println(strDate);
		
		/*
		//��������ó�� // printf ����... //Web ������ �����Ҷ�...(printf ������ ����...)
		String userId = "green";
		String message = "ȸ�� Id :{0} \nȸ�� �̸� : {1} \nȸ�� ��ȭ��ȣ : {2}";
		String result3 = MessageFormat.format(message, userId, "�ʷ�", "010-1111-1111");
		System.out.println(result3);
		*/
		
		File dir = new File("C:\\IOTemp");
		File[] files = dir.listFiles(); //IOTemp ���� �Ʒ��ִ� ���ϰ� ��������� ����... // �ش� ������ ����Ʈ�� ���Ϲ迭�� return
		
		for (int i = 0 ; i < files.length; i++) {
			File file = files[i];
			String name = file.getName();
			//System.out.println(name);
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH-mma");
			String attribute = "";
			String size="";
			if (files[i].isDirectory()) { // �� ������??
				attribute = "<DIR>";
			}else {
				size = file.length() + "byte"; // ������ �뷮
				attribute = file.canRead() ? "R" : ""; //�������ִ�?
				attribute += file.canWrite() ? "W" : ""; // ���� �ִ�?
				attribute += file.isHidden() ? "H" : ""; //���������̴�?
			}
																												//������ ������������¥(long Ÿ��)
			System.out.printf("%s	%3s		%10s		%s	\n",dt.format(new Date(file.lastModified())), attribute, size, name );
		}
		
	}
}
