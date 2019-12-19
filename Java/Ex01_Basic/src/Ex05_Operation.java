//������
public class Ex05_Operation {
	public static void main(String[] args) {
		int result = 100/100;
		System.out.println(result);
		
		result = 13/2; //��
		System.out.println(result);
		
		//�������� ���ϴ� ������ (%)
		result = 13%2; //������
		System.out.println(result);
		
		//���� , ���� (������ ������ : ++ , --) 1�� ���� , 1�� ����
		int i =10;
		//i = i+1;
		++i;//��ġ����
		System.out.println("��ġ i : " + i);
		i++;//��ġ����
		System.out.println("��ġ i : " + i);
		//���� ȥ�� : ��ġ , ��ġ ����
		
		//POINT : ��ġ ��ġ��  �ٸ� �����ڿ� ����(����)
		int i2 = 5;
		int j2 = 4;
		
		int result2 = i2 + ++j2;
		System.out.println("result2 :" + result2 + " j2:" + j2);
		//result2:10 , i2=5  , j2=5
		result2 = i2 + j2++;
		System.out.println("result2 :" + result2 + " j2:" + j2);
		
		//POINT
		//�ڹ��� ���� ��Ģ
		//[����]�� ��� [����]�� [ int ] [��ȯ] �� ó��
		//byte + byte => �����Ϸ��� int + int
		byte b = 100; //-128 ~ 127
		byte c = 1;
		byte d = (byte)(b + c);
		//1. int d = b + c;
		//2. byte d = (byte)(b+c) ������ �ս��� �ü���
		
		//byte + short => �����Ϸ�  int + int
		//char + char  => �����Ϸ�  int + int
		//����ó����
		//POINT : ���꿡�� int ���� ���� Ÿ���� int ��ȯ (long ����)
		//����(byte , char , short -> int )�ٲپ ó��
		
		//��Ģ �ǿ����� �� ǥ�� ������ [ū Ÿ��]���� �� ��ȯ
		//byte + short -> int + int  >>int
		//char + int -> int + int    >>int
		//int + long -> long + long  >>long
		
		//���� + �Ǽ� 
		long ll = 10000000000L;
		float ff = 1.2f;
		float fresult = ll + ff; //���� �Ǽ�
		System.out.println("fresult : " + fresult);
		
		float num2 = 10.45f;
		int num3 = 20;
		//num2 + num3
		//�޴� ���� ū Ÿ�� : float + int >>  float + float
		//float result5 = num2 + num3;
		//System.out.println(result5); //30.45
		
		int result5 = (int)(num2 + num3);
		System.out.println(result5); //�����θ� ....
		
		char c2 = '!'; //char ����Ÿ�� (���������� ....����)
		char c3 = '!';
		
		//c2 + c3 ����� ...
		//char result6 = c2 + c3; �ȵǿ� ... int + int
		int result6 = c2 + c3;
		System.out.println("result6 : " + result6);
		//���� ���� ���ڷ� ��� : ������ 66�� �ƽ�Ű�ڵ�ǥ ���� ..
		System.out.println((char)result6);
		
		//��� 
		//�߼ұ�� ���蹮��(������ ���) >> �����
		//2~9
		//2 >> 1~9
		//3 >> 1~9
		
		//main �Լ� �ȿ� �ִ� local variable
		
		int sum = 0;
		for(int j =1; j<= 100 ; j++) {
			System.out.println("j++ : " + j);
			if(j%2 == 0) {  // == true , false
				//System.out.println("j :" + j);
				sum+=j;//sum=sum+j;
			}
		}
		System.out.println(sum);
		
		// ==������ (���� ���ϴ� ������)
		if(10 == 10.0f) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		//! ����������
		if('A' != 65) { //���� �ʴ�
			System.out.println("�� ���� �ʾ� ...");
		}else {
			System.out.println("�� ���� ���̾�");
		}
		
		//�ϱ����� (POINT)
		//���׿����� 
		int p =10;
		int k =-10;
		int result8 = (p == k)? p : k;   //  ?   :
		//System.out.println("result3 :" + result8);
		//���׿����� if ���� ȣȯ ����
		//if��
		//int result8 = 0;
		if(p==k) {
			result8 = p;
		}else {
			result8 = k;
		}
		System.out.println("result3 :" + result8);
		
		//����ǥ
		/*
		  (������)
		  0 : false
		  1 : true
		        OR     AND
		  0 0   0       0
		  0 1   1       0 
		  1 0   1       0
		  1 1   1       1
		  
		 sql�� (oracle)  
		 select *
		 from emp
		 where empno=1000 and sal > 2000  //�׸���  
		 
		 select *
		 from emp
		 where empno=1000 or sal > 2000  //�Ǵ�  , �̰ų�
		 
		 ������
		 | or ������
		 & and ������
		 0 �� 1 ��ȯ�ؼ� bit ����
		 
		 || ������
		 && ������ 	 
		*/
		
		int x = 3;
		int y = 5;
		System.out.println("x|y:" +(x|y));
		//������ 3�� -> 2���� (0�� 1�θ� �̷���� ������ �ٲپ)
		//2 0�� , 2 1��
		// 128 64 32 16 8 4 2 1
		//              0 0 1 1  >> 3 2������
		//              0 1 0 1  >> 5 2������
		//OR            0 1 1 1  >> 4+2+1 > 7
		//AND           0 0 0 1  >> 1
		
		System.out.println("x&y:" +(x&y));
		
		//POINT ������( &&(and) , ||(or) )
		//if(10 > 0 && -1 > 1 && 100 > 2 && 1 > -1 && .....){���๮} 
		//if(10 > 0 || -1 > 1 || 100 > 2 || 1 > -1 || .....){���๮}
	}

}



