
public class Ex02_Exception {

	public static void main(String[] args) {
		int num = 100;
		int result = 0;
		
		try {
			for(int i = 0; i < 10 ; i++) {
				result = num / (int)(Math.random()*10);//0 ~ 9 ���� ���� �� ����.. 0���� ���� �� ����. 
				System.out.println("result : " + result + " i : " + i);
			}
		} catch (ArithmeticException e) { // �ڡڡ� ��ü�� �ּҰ��� �޴´�(ArithmeticException) 
			System.out.println("���� ���� �߻� [������ ���Ϻ�����]");
			System.out.println(e.getMessage());
			// e.printStackTrace(); // ������ �� �ڵ��� ���ι������� �����ͼ� ���.
			
		} catch (Exception e2) { // ���� �̿��� ������ ���ܴ� ���� ó���Ҳ�!! ( ���� ������ ����) // ������. Exception �� ��� ������ �θ�ü.(��Ӱ���)
			// Exception ���� ���� �� �ذ������...
			// � ���ܸ� ������ �� �� ����... �ڵ��� �������� ������..
			// �������� ���ܸ� ������ִ� ���� ����....
		}
		
		System.out.println("Main �Լ� ����");
		
	}
	//������� ���� ��ü �߻� : java.lang.ArithmeticException
	// ���ܰ� �߻��ϸ� �� ������ ���� ��ü�� �����Ѵ�.( new ���� �ʾƵ� �ڵ�����)
	//ArithmeticException aa = new ArithmeticException();
	// aa.setMessage("�����߻�");
}
