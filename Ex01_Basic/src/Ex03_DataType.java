/*
1. �ڹٴ�  �ý��ۿ��� �⺻ 8���� Ÿ�� ����(�ڷ���)
2. 8���� �⺻ Ÿ��(���� �����ϴ� Ÿ��)
3. ���� -> ���� (���� ���� , 0 , ���� ����) -> byte(-128~127)
                                  -> char(�� ���ڸ� ǥ���ϴ� �ڷ���)
                                  >>�ѹ���(2Byte) >> �ѱ� 1�� 2byte , ������,Ư��,���� 2byte
                                  >>unicode ����
                                  ->short
                                  ->int(-21 ~ 21��) : **java ���� ���� �⺻ Ÿ��(4byte)**
                                  ->long(8byte) : int ���� ū ��
      -> �Ǽ�(�ε��Ҽ���)  -> float(4byte) , double(8byte)
      -> ���е�(ǥ�� ������ ũ��) >> double  **java �Ǽ� ���� �⺻ ** 
   �� -> �� , ���� -> boolean >> ���α׷��� ���� �帧 ����     
   
 �ñ�����   : ���ڿ��� ǥ�� ??? >> ȫ�浿 , hello , 
 String �� ����Ÿ��(Ŭ����) >> String s = new String("�ȳ�");
 ex)
 String str = "ȫ�浿";   
 �׳� int , double ó�� ����ϼ��� ...  
 
�ڹٴ� ũ�� 
1. ��Ÿ��    >>���� , �� ..  8����
2. ����Ÿ�� >>Ŭ���� , �迭   >> ������ �ּҰ��� ��� ���� ����Ÿ��  
2.1 class == ���赵 == Type             
       
                   
*/
class Car{  //Car ��� Type : ���赵
	String color;
	int window;
}

public class Ex03_DataType {
	public static void main(String[] args) {
		Car c = new Car();
		//c ������ Car Ÿ���� ������ �ִ�
		//c �� �ּҰ��� ������ �ִ� (��������)
		System.out.println("c ��� ������ �� :" + c);
		//Car@15db9742 �ּҰ� : Ŭ������ + @ + �ּ�
		
		Car c2; //����
		c2 = new Car(); //�Ҵ� (�ּҰ� �Ҵ�)
		System.out.println("c2 ��� ������ �� :" + c2);
		
		Car c3 = c; //�ּҰ� �Ҵ� 
		System.out.println(c + " : " + c3); //Car@15db9742 : Car@15db9742
		System.out.println(c == c3); //true
		c3.color = "black";
		System.out.println(c.color);
		
		//�� Ÿ�� (8���� + String)
		int i = 200; //����� �Ҵ�
		System.out.println("i��� ������ �� : " + i);
		
		int j; //����
		j = 1000;//�Ҵ� (�ʱ�ȭ)
		
		int a, b; //���� �ʱ�ȭ  
		a =10;
		b =20; 
		
		int k = 1111;
		int k2 = k; //�� �Ҵ� 
		System.out.println("k2 : " + k2);
		k2 = 2222;
		
		//k �� ��� >> �׷��� 1111
		
		//int(-21 ~ 21)
		//Today Point
		//int p = 10000000000; (x)
		//���� ���ͷ� 10000000000 �� int
		//���� ���ͷ� (����) ������ : int ��
		//���� ���ͷ���  long ũ��� ���� : ������ L
		long number2 = 100; //OK
		long number = 10000000000L;
		//The literal 10000000000 of type int is out of range 
		System.out.println("number : " + number);
		
		//char : 2byte(������)
		//�ѹ��ڸ� ǥ���ϴ� �ڷ���
		//�Ϲ���
		//1. �ѱ����� >> 2byte
		//2. ������ , ���� , Ư������ >> 1byte
		//�ѱ��̴� , �����̴� 2byte �� ǥ�� (unicode)
		//�ƽ�Ű �ڵ�ǥ�� �������� Ȯ��
		
		//java ���ڿ� : "��" , String str = "ȫ�浿" , String str="aaaagggeeffff"
		//java ���� : '��' , char c= 'A';
		
		char single = '��';
		System.out.println(single);
		//char single2 = '����';
		char ch='A';
		System.out.println(ch);
		//�����ϰ� �ִ� ������ ...
		//casting Ÿ�Ժ�ȯ
		int intch = 'A'; //���������� �Ͻ��� ����ȯ
		System.out.println("intch : " + intch);
		System.out.println((int)ch); //type casting  //������ �ƽ�Ű �ڵ�ǥ
		
		char ch2 = 'a';
		System.out.println(ch2);
		System.out.println((int)ch2);
		
		int intch2 = 65; //[[���� �������� Ÿ���� ����]] ^^^^^^^^^^^^^
		char ch3 = (char)intch2; //������(�����)����ȯ ......(ū���� ���������� ������ �ս�)
		System.out.println(ch3);
		
		int intch3 = ch3; //�Ͻ�������ȯ
		//int intch3 = (int)ch3; //���� ���� ū ������ �ڵ� ��ȯ ....
		System.out.println(intch3);
		//Today Point
		//1.������ ������ �ִ� ���� ��������  [������ Ÿ��] �� ����
		//2.������ Ÿ�� ũ�⸦ Ȯ������
		//3.ūŸ�Կ��� ���� Ÿ�� ���� ���� �� �־��
		//4.���� Ÿ�Կ��� ū Ÿ�԰��� �� �־��
		//char <- int     >>>    char <- (char)int
		//int <- char ���� (�������� ��ȯ) >>>   int <- (int)char
		
		//�������� ���� ����� �ִ�. (��������)
		int intvalue =10165468;
		byte bytevalue = (byte)intvalue;
		System.out.println(bytevalue); //�����Ⱚ�� �߻� .....
		
		//String (���ڿ�) Ÿ������ ����
		//String �� Ÿ���� �ƴϰ� Ŭ���� Ÿ��(����� new ���ؼ� �޸𸮿� �ø��� ���)
		//��Ģ : String str = new String("ȫ�浿");
		//POINT : String �� �׳� �Ϲ� Ÿ��ó�� ....... (int , double)....
		
		String str ="hello world";
		System.out.println(str);
		
		String str2 = str + "������"; //DB (oracle  + ������(���) , ���� ������  ||)
		                            //'hello world' || '������' 
		
		System.out.println(str2);
		
		//Tip) java Ư������ ����ϱ�
		//���ڸ� ���� ��Ű�� ���ؼ� : \ ��������
		char sing = '\'';
		System.out.println(sing);
		
		//ȫ"��"��  �̶�� ���ڿ��� ����غ�����
		String name ="ȫ\"��\"��";
		System.out.println(name);
		
		String str3 ="1000";
		String str4 = "10";
		String result = str3 + str4;
		System.out.println(result);
		
		System.out.println("100"+100);//100100
		System.out.println(100+"100");//100100
		System.out.println(100+100+"100");//200100
		System.out.println(100+(100+"100"));//100100100		
		System.out.println(100+"100"+100);//100100100
		
		//C:\Temp ���ڿ��� ����ϼ���
		String path ="C:\\temp";  //C:\temp    \t tab  , \n new line
		System.out.println(path);
		
		//�Ǽ�(�ε��Ҽ���)
		//float(4byte)
		//double(8byte) : "**�Ǽ��� �⺻ Ÿ��(���ͷ�) double" (���е��� ���� (�Ҽ����� �ڸ��� ǥ�� ...))
		
		float f = 3.14f; //��� �Ǽ��� double Ÿ��  >> 3.14 ��� ���ͷ����� double
		                //float Ÿ���� ���ͷ� f ,F
		float f2 = 1.123456789f;
		System.out.println("f2 : " + f2); //1.1234568  �뷫 7 �ڸ� (�ݿø� ó��)
		
		double d = 1.123456789123456789; 
		System.out.println("d :" + d); //1.1234567891234568  �뷫 16�ڸ� ǥ��(�ݿø� ó��)
		
		//Quiz
		//-128 ~ 127
		byte q = (byte)128;
		System.out.println(q);
		
		//double d2 = 100; //�Ͻ��� ����ȯ
		double d2 = (double)100;
		System.out.println(d2);
		
		//Quiz
		double d3 =100;
		int i5 = 100;
		
		//int result2 = d3 + i5;  int = int + double (���� + �Ǽ� >> �Ǽ�)
		
		//1. int -> double  >>int result2 = d3 + i5;
		//double result2 = d3 + i5; ������ �ս��� ����
		
		//2. ū Ÿ���� ���� Ÿ������ ��ȯ�� ������ �ս� ^^!
		//int result2 = (int)d3 + i5; //������ ������ �ȵǿ� .. d3 �� int ���� �Ѵ� ���̶��(������ �ս�)
		
		//3. ������ �ս� �߻� ����
		int result2 = (int)(d3 + i5);
		
		//Today Point
		//����Ÿ�� + ūŸ�� >> ūŸ��
		//Ÿ�԰� ��ȯ >> ������ ������ ���� ���� ���� ������ Ÿ���� ���� �Ǵ�����
		//����� ����ȯ(casting) (int)
		
		int i6 = 100;
		byte b2 = (byte)i6; //����� ����ȯ
		System.out.println(i6);
		
		byte b3 = 20;
		int i7 = b3; //�����Ϸ��� ����������  (int)b3 ����   �Ͻ��� ����ȯ
		
		//���� Ÿ�Կ� ���ؼ� (2���� , 8���� ,,,,,, ƴƴ��)
		
		
	}

}




