//Ŭ������ ���赵�̴� , Ŭ������ Ÿ���̴�
//Ŭ���� == ���赵 == Ÿ��
//Ŭ������ ��üȭ(���� ���� ����) �ؼ� ��� 
//���α׷� ���迡���� new ��üȭ (memory) >> �ν��Ͻ�(��ü)

//���赵�� �ۼ�
//Ŭ������ ũ�� 2���� (������(main) ������ Ŭ���� , main �Լ��� ���� Ŭ����)

class Apt{
	int door=10;
	int window=100;
}

public class Ex04_Ref_Type { //main �Լ��� �ִ� ���赵
	public static void main(String[] args) {
		
		//Apt ���赵 ��üȭ(����Ʈ ...)
		Apt lgapt = new Apt();
		//lgapt (�������� , ��ü���� : �ּҸ� ������ �ִ� ����)
		System.out.println("�ּҰ� : " + lgapt);
		
		//lgapt �༮�� ��ü�� �ּҸ� ������ ��� (��Ģ������ new)
		
		Apt ssapt = lgapt; //�Ҵ絵 ����� �ϳ��� ...
		ssapt.door = 1111;
		System.out.println("lgapt.door"+ lgapt.door);

	}

}
