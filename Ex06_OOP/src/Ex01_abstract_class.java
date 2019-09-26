/*
 �߻�Ŭ����
 �̿ϼ� Ŭ���� (�̿ϼ� ���赵)
 1. �ϼ��� �ڵ� + �̿ϼ��� �ڵ�
 2. �ϼ�(�Լ�) : ����� �ִ� �� + �̿ϼ�(�Լ�) : ������� ���� ��. public void print();  (����Ұ�)
 3. �ϼ��� �̿ϼ��� ���� ( new ��ü ( �ϼ�) / new ��üX (�̿ϼ�) )
 
 ���� )
 1. �߻�(�̿ϼ�) Ŭ���� ������ ��ü ���� �Ұ� ( new ���Ұ�)
 2. �߻�Ŭ������ �ᱹ �ϼ��� Ŭ������ ���� ��� ���� -> ����� �������� �ϴ� Ŭ����
 3.��� ���迡�� �̿ϼ� �� �ڿ� ( �߻��ڿ�) �ϼ��ض� ( ���� ) -> ������ ( override)
 
 why ) �߻�Ŭ���� >> �����ڰ� �ٶ󺸴� ������ �ǹ� >> ������ ���� ( ������ ���� )
 �ڡڡڡڡڡ� ��Ӱ��迡�� ������ ������ �������� �ϴ� ��.�ڡڡڡڡڡ�
 */

abstract class ABclass { // �߻� Ŭ����
	int pos;

	//�ϼ��� �ڵ�
	void run() {
		pos++;
	}
	
	//�̿ϼ��� �ڵ� = �߻��ڿ� {} ������� ����.
	abstract void stop();
	
	
}
//�߻� Ŭ������ ����� ���ؼ��� �ϼ��ڿ�����...
class Child extends ABclass {

	@Override
	void stop() {
		this.pos = 0;
		System.out.println("stop : "+this.pos);
	}
	
}

public class Ex01_abstract_class {
	public static void main(String[] args) {
		// ABclass ab = new ABclass();  //Cannot instantiate the type ABclass // �߻�Ŭ���� �̿ϼ��̶� new �Ұ�.
		Child ch = new Child();
		ch.run();
		ch.run();
		System.out.println("���� pos ���� : " + ch.pos);
		ch.stop();
		
		//������ ���� ( ����� �������� �� ������ ����)
		
		ABclass ab = ch; // ABclass �θ�Ÿ�� -> �θ�� �ڽ�Ÿ���� �ּҸ� ���� �� �ִ�.  
		ab.run();
		ab.stop(); // ������ �θ��� stop �� ������ override �Ǿ��־ �ڽ��� �ڿ����� �̵��ڡڡڡڡڡڡڡڡڡڡ�
		

	}

}
