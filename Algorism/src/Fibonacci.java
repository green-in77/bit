import java.util.Scanner;

/* ����
�Ǻ���ġ �迭�� 0�� 1�� �����ϸ�, ���� �Ǻ���ġ ���� �ٷ� ���� �� �Ǻ���ġ ���� ���� �ȴ�.
���� N�� �־�����, N���� ���� ��� ¦�� �Ǻ���ġ ���� ���� ���Ͽ���.

Input: N = 12
Output: 10 // 0, 1, 1, 2, 3, 5, 8 �� ¦���� 2 + 8 = 10.
*/

public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�Ǻ���ġ ������ ���� ������ �Է��ϼ���.");
		int n = Integer.parseInt(sc.nextLine());
		
		int n1 = 0;
		int n2 = 1;
		int result=0;
		int sum=0;
		
		System.out.printf("%d ���� ���� �Ǻ���ġ ����\n",n);
		System.out.printf("%d %d ",n1,n2);
		
		while((n1+n2)<n) {
			result = n1 + n2; //���� �� ���� ���ϸ� �Ǻ���ġ ����..
			n1 = n2; //��ĭ�� ������ ���鼭 ���ؾ��ϱ� ������ ���� ����
			n2 = result;
			System.out.printf("%d ",result);
			if(result%2==0) { //�Ǻ���ġ ���� ����� ¦����
				sum += result;//�����ֱ�
			}
		}
		System.out.printf("\n���� ���� �� ¦���� �� : %d ",sum);
	}
}