// ���ݱ��� ���� �̱����μ���+�̱۾����� ( main �Լ� )
// JVM >> Call stack ����( 1�� )
// Ex01_single_Thread : �Լ� 10���� ������ �ִ���
//											�ѹ��� �ϳ��� �Լ��� [������] ���� - ���ý���� �� ����.
//											stack �� �ϳ��̱� ������.


public class Ex01_single_Thread {

	public static void main(String[] args) {
		System.out.println("�� main �ϲ��̾�");
		worker();
		worker2();
		System.out.println("�� main ����");

	}
	static void worker() {
		System.out.println("�� 1�� �ϲ��̾�");
	}
	static void worker2() {
		System.out.println("�� 2�� �ϲ��̾�");
	}
	
}
