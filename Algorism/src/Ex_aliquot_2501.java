//6�� ���� ���
//
//6 �� 1 = 6 �� 0
//6 �� 2 = 3 �� 0
//6 �� 3 = 2 �� 0
//6 �� 4 = 1 �� 2
//6 �� 5 = 1 �� 1
//6 �� 6 = 1 �� 0
//�׷��� 6�� ����� 1, 2, 3, 6, �� �� ���̴�.

//� �ڿ��� p�� q�� ���� ��, ���� p�� q�� �������� �� �������� 0�̸� q�� p�� ����̴�. 
//�� ���� �ڿ��� N�� K�� �־����� ��, N�� ����� �� K��°�� ���� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//ù° �ٿ� N�� K�� ��ĭ�� ���̿� �ΰ� �־�����. N�� 1 �̻� 10,000 �����̴�. K�� 1 �̻� N �����̴�.
//ù° �ٿ� N�� ����� �� K��°�� ���� ���� ����Ѵ�. ���� N�� ����� ������ K������ ��� K��° ����� �������� ���� ��쿡�� 0�� ����Ͻÿ�.
import java.util.Scanner;

public class Ex_aliquot_2501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int count = 0;
		
		for (int i = 1; i <= n; i++) { // for (int i = 1; i <= n ; i++) {
			if ( n%i == 0) count++; // if ( n%i == 0 ) k--;
			if(count == k) {            // if ( k == 0 ) {
				System.out.println(i);
				break;
			}
		}

		if(count<k) {                    // if ( k != 0 )
			System.out.println(0);
		}
	}
}