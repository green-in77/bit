package kr.or.bit;

public class Ex05_Operation {

	public static void main(String[] args) {
//		int result= 100/100;
//		System.out.println(result);
//		result=13%2;
//		System.out.println(result);
//		
//		//����, ���� ������
//		int i= 10;
//		++i; //��ġ ����
//		i++; //��ġ ����
//		System.out.println(i);
		
		/*
		 * ��ġ, ��ġ�����ڴ� ���� ������ ���̰� ����.
		 * �ٸ� �����ڿ� ���������� ��ġ�� �������� ����(��)�ϰ� ��ġ�� ������ ���� �Ŀ� ����(��)�Ѵ�.
		 */
		int i2=5;
		int j2=4;
		
		//int result2= i2 + ++j2;//��ġ
		int result3= i2 + j2++;//��ġ
		//System.out.println(result2);
		System.out.println(result3);
		
		/*
		 * Point
		 * �ڹ��� �����Ģ
		 * [����]�� ��� [����]�� [int]�� [��ȯ] �� ó��
		 * byte + byte = �����Ϸ��� int + int�� ó��
		 */
		byte b= 100;
		byte c= 1;
		//byte d= b+c; ����, b+c�� �⺻������ int�� ����ϱ⶧��.
		
		long lResult= 1000000000L;
		float fResult= 1.2f;
		float lfResult= lResult + fResult; //�Ǽ��� ǥ�������� �� ����
		System.out.println(lfResult);
		
		float num2= 10.45f;
		int num3= 20;
		int result5=(int)num2+num3;
		System.out.println(result5);
		
		char c2= '!';
		char c3= '!';
		System.out.println(c2+c3);
		
//		char ch='A';
//		for (int i = 0; i < 10; i++) {
//			System.out.println((char)(ch+i));
//		}
		int sum=0;
		int sum2=0;
		for(int i=1; i<=100; i++) {
			if(i%2==0) {
				sum+=i;
			} else
				sum2+=i;
		}
		System.out.println(sum);
		System.out.println(sum2);
		
		if(10==10.0f) {
			System.out.println("True");
		}
		else
			System.out.println("False");
		
		//Point(�ϱ�)
		//���� ������
		int p= 10;
		int k= -10;
		
		int result8= p==k ? p : k;
		System.out.println(result8);
		
		int result9=0;
		if(p==k) 
			result9=p;
		result9=k;
		System.out.println(result9);
		
		/*
		 *  				OR		AND
		 *  |	0 0	|	 0		|	  0		|
		 *  |	0 1	|	 1		|	  0		|
		 *  |	1 0	|	 1		|	  0		|
		 *  |	1 1	|	 0		|	  1		|
		 *  
		 *  ��Ʈ������
		 *  | or ������
		 *  & and ������
		 *  0�� 1�� ��ȯ�ؼ� bit ������ �ض�
		 *  || ������
		 *  && ������
		 */
		
		int x= 3;
		int y= 5;
		System.out.println("x|y: " + (x|y));
		//x�� y�� �������� ��ȯ�� �� �������� or�� ������.
		System.out.println("x&y: " + (x&y));
		
		/*
		 * Point ������( &&(and), ||(or) )
		 * if(10 > 0 && -1 > 1 && 100 > 2 && 1 > -1 && ....) { ���๮};
		 * if(10 > 0 || -1 > 1 || 100 > 2 || 1 > -1 || ....) { ���๮};
		 */
	}
	

}
