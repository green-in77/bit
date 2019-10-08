/* 3열까지 감소, 4열부터 증가 / 반으로 나누고 시작 또는 끝을 지정해주는 변수 필요 / 1씩 증가되는 숫자 저장 변수 필요
 모래시계 - 2차원배열
01 02 03 04 05 	0 - 01234
    06 07 08		1 - 123
         09			2 - 2
     10 11 12			3 - 123
 13 14 15 16 17    4 - 01234
 */
public class sandglass {
	public static void main(String[] args) {
		int n = 5; //입력받은 수
		int start=n; //
		int num=1; //1씩 증가되는 숫자
		
		int i = 0;
		
		int[][] intarr = new int[n][n];
		
		for(i =0; i<=((n/2)+1);i++) {
			for(int j = i; j<start;j++) {
				intarr[i][j] = num;
				num++;
			}
			start--;
			System.out.println(start);
		}		
		for( i=(i-1); i<5;i++){
			for(int j=start;j<=i;j++) {
				intarr[i][j] = num;
				num++;
			}
			start++;
		}
		
		
		for (int x = 0; x < n; x++) {
			for (int z = 0; z < n; z++) {
				if ( intarr[x][z]==0) {
					System.out.printf(" ");
				}else {
					System.out.printf("%d ",intarr[x][z]);
				}
			}
			System.out.println();
		}
		
	}
}