import java.util.Scanner;
//정하

/*두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를,둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
24 18 / 6 \n 72*/

/*최대공약수
- 입력받은 m, n 중 작은 수(minimum)를 -1씩 감소시키며, m 과 n을 minimum으로 나누었을 때 0이 되는 수를 출력

최소공배수
- 입력받은 m, n 중 큰 수(maximum)를 1씩 증가시키며, maximum 을 m 과 n으로 나누었을 때 0이 되는 수를 출력

brute force
a,b 를 나누어서 나머지가 0이 되는 수들 중 가장 큰 수 = 최대공약수
a,b의 배수를 구하여 공통된 배수 중 가장 작은 숫자 = 최소공배수
->큰 수에서 작은 수를 ++하면서 나머지가 0인 숫자
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

		while(!ismin) { // 작은수로 --하면서 나눠서 제일처음 나머지가 0인 수 = 최대공약수
			if ( ( m%min == 0 ) && ( n%min == 0 )) {
				System.out.println("최대공약수 : " + min);
				ismin = true;
			}
			min--;
		}

		while(!ismax) {
			if( (max%m == 0) && (max%n == 0)) {
				System.out.println("최소공배수 : " + max);
				ismax = true;
			}
			max++;
		}
	}
}