import java.io.DataOutputStream;
import java.io.FileOutputStream;

// ������Ʈ��
// Java �� �����ϴ� 8���� �⺻Ÿ������ (Ÿ�Ժ��� write, read)

// DataOutputStream, DataInputStream
// DataOutput ���� ���� �ݵ�� DataInput ���� �о�� ��.

public class Ex13_DataOutPutStream {
	public static void main(String[] args) {
		int[] score = {100,60,55,94,23};
		
		try {
			FileOutputStream fos = new FileOutputStream("score.txt");
			DataOutputStream dos = new DataOutputStream(fos); // 
			
			for(int i = 0 ; i < score.length ; i++) {
				dos.writeInt(score[i]); // �������� write
				//dos.writeUTF(str); 3byte ���� �ν�. �ѱ��� ���� ������ ����.
			}
			dos.close();
			fos.close();
			
		}catch(Exception e) {
			
		}finally {
			
		}

	}
}
