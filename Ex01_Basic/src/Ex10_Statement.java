import java.util.Scanner;

//�ݺ���(while , do~while)
public class Ex10_Statement {

	public static void main(String[] args) {
		int i = 10;
		while( i >= 10) { // ������ true ���ѹݺ� // (int i >= 10 ) while ���� �̷��� ���� ����.
			System.out.println(i);
			//�ݵ�� ������� ������!!
			i--;
		}
		
		//while (1~100) ������ ��
		
		int j = 1;
		int sum=0;
		
		while( j <= 100) {
			sum += j; //sum = sum + j;
			j++; //������� ������ // ���� !! �����۾� �� �������ϱ�
		}
		System.out.println("1~100������ ���� : "+sum);
		
		// while ������
		
		int k = 2;
		int p = 1;
		
		while ( k <= 9 ) {
			p = 1; // p�� �ٽ� 1�� �Ҵ�.
			while ( p <= 9 ) {
				System.out.printf("%d x %d = %d \t",k,p,k*p);
				p++;
			}
			k++;
			System.out.println();
		}
		System.out.println(k);
		
		
		
		//do ~ while : ������ ����(����) -> ������ 1���� �����ϰڴ�.
		// do {���๮} while (����)
		// �޴�����
		// 1. �λ���� 
		// 2. �޿�����
		// ����� ���ϴ� ���� ��ȣ�� �Է��ϼ���. (������ �ѹ�...)
		// 3. �Է��ϸ� ���ǿ��� true ������ ���� �ٽ� �Է� �޵��� �����ϴ� ���.
		
		Scanner sc = new Scanner(System.in); // �����͸� �Է¹ޱ� ���� ��
		int inputdata=0;
		// 0~10 ���� �Է¹ޱ� / 10���� ū ���� �Է��ϸ� �ٽ� �Է¹޴� ������ ���ư�.
		do {
			System.out.println("�����Է���(0~10)");
			inputdata = Integer.parseInt(sc.nextLine());
		}while(inputdata > 10); // ���� true �� do ���� ��� ����
		// 10���� �� ���� ���� true .. do �ݺ�����
		//0~10������ ���� �ԷµǸ� false while Ż��!
		System.out.println("����� �Է��� ���� : " + inputdata);

		
		
		
	}

}
