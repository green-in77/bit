import java.util.Scanner;
//정하
/* 3열까지 감소, 4열부터 증가 / 반으로 나누고 시작 또는 끝을 지정해주는 변수 필요 / 1씩 증가되는 숫자 저장 변수 필요
 모래시계 - 2차원배열
01 02 03 04 05 		0 - 01234
    06 07 08			1 - 123
       09					2 - 2
    10 11 12				3 - 123
 13 14 15 16 17     	4 - 01234
 */

public class sandglass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0; //모래시계 기준 값을 받기 위해
		
		do {
			System.out.printf("모래시계 (홀수를 입력하세요.) : ");
			n = Integer.parseInt(sc.nextLine()); //입력받은 수
		} while(!(n%2==1)); // 홀수인지 체크해서 짝수면 재입력
		
		int start=n; //배열길이 및 값을 넣을 마지막 방의 갯수를 체크하기위해
		int num=1; //배열에 저장되는 1씩 증가되는 숫자
		
		int i = 0; //배열 행의 값을 계산
		
		int[][] intarr = new int[n][n]; //모래시계 만들 배열 생성
				

		for(i=0;i<n;i++) { // i는 배열의 행 값
			
			if(i < ((n/2)+1)) { //반까지 열이 감소, 이후로 열이 증가 하기 때문에 조건검사 후 for문 
				
				for(int j = i; j<start;j++) { // j는 열 값 , j가 i부터 시작해서 start 보다 작을때까지
					intarr[i][j] = num;	// 0,0~4 / 1,1~3 / 2,2
					num++; //숫자가 방에 들어가면 1씩 증가
				}
				
			}else { //반 이후부터는
				
				for(int j=(start-1);j<=i;j++) { //반 이후부터는 열 값이 증가 
					intarr[i][j] = num; // 3,1~3 / 4,0~4
					num++;
				}
				
			}
			start--; //반까지는 열의 값을 줄여주기 위해 / 반 이후로는 열의 값을 증가시켜주기 위해
		}
//--------------------------------------------------------------------------------------------		
		//2차원 배열 출력
		for (int x = 0; x < n; x++) {
			for (int z = 0; z < n; z++) {
				
				if ( intarr[x][z]==0) { //배열값이 0이면
					//System.out.printf(" ");
					System.out.printf("◇");
				}else { //그 외에는...
					System.out.printf("★");
					//System.out.printf("%2d",intarr[x][z]);
					//System.out.printf("(%d,%d)%d ",x,z,intarr[x][z]);
				}
				
			}
			System.out.println(); //1줄 출력하고 줄바꿈
		}
		sc.close();
	}
}