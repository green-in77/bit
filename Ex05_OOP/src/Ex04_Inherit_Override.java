/*
 Today Point : [��Ӱ���] ���� override : ��Ӱ��迡�� �޼��� [������] // ����� ������ override �� ����.
 -��� ���迡�� �ڽ�Ŭ������ �θ�Ŭ������ �޼ҵ带 ������(����ٲ�)
 ������ �ǹ� : Ʋ�� ��ȭ(�Լ��� �̸��� , return type �� ��ȭ�� �ƴ϶� {����}�� ��ȭ
 ����)
 1. �θ��Լ� �̸� ����
 2. �θ��Լ� parameter ����
 3. �θ� �Լ� return type ����
 4. ���븸 �ٲٴ� ��.
 */

class Point2{
	int x = 4;
	int y = 5;
	String getPosition() {
		return "x: " + this.x + "y : " + this.y;
	}
}

class Point3D extends Point2 {
	//int x; ��Ӱ��� �θ� ������ x,y �� ����.
	//int y;
	int z = 6;
	
	// ������  Annotation�� Java code������ ������ �� ���� [�ΰ����� ����]�� [�����Ϸ�]�� [������]�� ������ �� �ִ�.
	//@Override >> Annotation >> ������ �˻��ϴ� ���
	// �����Ǹ� �ϸ� �ڽ����忡�� ���� �θ��� �Լ��� ������ �� ����. ������ �� �Լ��� ���ٰ���. -> �׷��� super �� ����.
	
	@Override
	String getPosition() {
		return "x : " + this.x + ", y : " + this.y + ", z : " + this.z;  //super.getPosition(); // super == �θ�
	}
	
	//�θ� �Լ��� ������ �ְ�.. �̸��� ������ ���!!!
	//�θ��� �Լ��� Ʋ�� �Ȱ���. ���븸 ����
	//������
	//String getPosition() { //�������̵�
		//return "x: " + this.x + " y : " + this.y + " z : " + this.z;
	//}
	
	
	
}


public class Ex04_Inherit_Override {

	public static void main(String[] args) {
		Point3D p3 = new Point3D();
		System.out.println(p3.getPosition());

	}

}
