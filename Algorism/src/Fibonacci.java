import java.util.Scanner;

/* 정하
피보나치 배열은 0과 1로 시작하며, 다음 피보나치 수는 바로 앞의 두 피보나치 수의 합이 된다.
정수 N이 주어지면, N보다 작은 모든 짝수 피보나치 수의 합을 구하여라.

Input: N = 12
Output: 10 // 0, 1, 1, 2, 3, 5, 8 중 짝수인 2 + 8 = 10.
*/

public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("피보나치 수열을 구할 정수를 입력하세요.");
		int n = Integer.parseInt(sc.nextLine());
		
		int n1 = 0;
		int n2 = 1;
		int result=0;
		int sum=0;
		
		System.out.printf("%d 보다 작은 피보나치 수열\n",n);
		System.out.printf("%d %d ",n1,n2);
		
		while((n1+n2)<n) {
			result = n1 + n2; //앞의 두 수를 더하면 피보나치 수열..
			n1 = n2; //한칸씩 앞으로 오면서 더해야하기 때문에 순서 정리
			n2 = result;
			System.out.printf("%d ",result);
			if(result%2==0) { //피보나치 수의 결과가 짝수면
				sum += result;//더해주기
			}
		}
		System.out.printf("\n위의 수열 중 짝수의 합 : %d ",sum);
	}
}