import java.util.Scanner;
//����

/*�� ���� �ڿ����� �Է¹޾� �ִ� ������� �ּ� ������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
ù° �ٿ��� �� ���� �ڿ����� �־�����. �� ���� 10,000������ �ڿ����̸� ���̿� �� ĭ�� ������ �־�����.
ù° �ٿ��� �Է����� �־��� �� ���� �ִ�������,��° �ٿ��� �Է����� �־��� �� ���� �ּ� ������� ����Ѵ�.
24 18 / 6 \n 72*/

/*�ִ�����
- �Է¹��� m, n �� ���� ��(minimum)�� -1�� ���ҽ�Ű��, m �� n�� minimum���� �������� �� 0�� �Ǵ� ���� ���

�ּҰ����
- �Է¹��� m, n �� ū ��(maximum)�� 1�� ������Ű��, maximum �� m �� n���� �������� �� 0�� �Ǵ� ���� ���

brute force
a,b �� ����� �������� 0�� �Ǵ� ���� �� ���� ū �� = �ִ�����
a,b�� ����� ���Ͽ� ����� ��� �� ���� ���� ���� = �ּҰ����
->ū ������ ���� ���� ++�ϸ鼭 �������� 0�� ����
*/

public class Ex_Common_2609 {
	public static void main(String[] args) {
		//		Scanner sc = new Scanner(System.in);
		//		int m = sc.nextInt();
		//		int n = sc.nextInt();

		boolean ismin = false;
		boolean ismax = false;

		int m = 24;
		int n = 18;

		int min = 0;
		int max = 0;

		if ( m < n ) {
			min = m;
			max = n;
		} else {
			min = n;
			max = m;
		}

		while(!ismin) { // �������� --�ϸ鼭 ������ ����ó�� �������� 0�� �� = �ִ�����
			if ( ( m%min == 0 ) && ( n%min == 0 )) {
				System.out.println("�ִ����� : " + min);
				ismin = true;
			}
			min--;
		}

		while(!ismax) {
			if( (max%m == 0) && (max%n == 0)) {
				System.out.println("�ּҰ���� : " + max);
				ismax = true;
			}
			max++;
		}
	}
}