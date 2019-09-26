import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.or.bit.UserInfo;

//UserData.txt
//��ü�� write...���صǾ....

//UserData.txt ��ü�� read ....... UserInfo ��ü ����

public class Ex16_ObjectDataInputStream {
	public static void main(String[] args) {
		String filename = "UserData.txt";
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream in = null;

		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			in = new ObjectInputStream(bis);
			
			// ������ȭ
			/*
			UserInfo r1 = (UserInfo)in.readObject();
			UserInfo r2 = (UserInfo)in.readObject();
			
			System.out.println(r1.toString());
			System.out.println(r2.toString());
			*/
			
			Object users = null;
			while((users = in.readObject())!=null) {
				System.out.println(users.toString());
			}				
			
		}catch(Exception e) {
			try {
				in.close();
				bis.close();
				fis.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
