package kr.or.bit;

/*
 * Ŭ����= ���赵= Ÿ��
 * ���α׷� ���迡���� new�� ��üȭ(memory) >> �ν��Ͻ�(��ü)
 * ���赵�� ������ 4byte�� ����
 * 
 * ���赵�� �ۼ�
 */
public class Ex04_Ref_Type {

	public static void main(String[] args) {
		Apt lgApt= new Apt(); //��������: �ּҸ� ���� ����
		System.out.println(lgApt);
		
		Apt ssApt= lgApt; //�ּҸ� ���¹���� ��Ģ������ new ���� �Ҵ絵 ��� �� �ϳ���.
		ssApt.door=1111;
		System.out.println(lgApt.door);
		
	}
}

class Apt{
	int door=10;
	int window=100;
}
