package Quiz;

public class GradeMain {

	public static void main(String[] args) {
		GradeSystem gsystem = new GradeSystem();
		do {
			System.out.println("�������� �ý����Դϴ�.");
			System.out.print("<1> �߰� <2> ���� <3>��� <4>���� <5>�ε� <6>���� : ");
			
			switch (gsystem.choice()) {
				case 1: gsystem.add(); // �߰�				
					break;
					
				case 2: gsystem.del(); // ����
					break;
					
				case 3: gsystem.print(); // �ܼ����
					break;
					
				case 4: gsystem.save(); // ����
					break;
				
				case 5: gsystem.load(); // �ε�
					break;
				
				case 6:
					System.out.println("���α׷��� ����˴ϴ�.");
					System.exit(0); // ����

			default: System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;
			}
		}while (true);

	}
}
