/* 3������ ����, 4������ ���� / ������ ������ ���� �Ǵ� ���� �������ִ� ���� �ʿ� / 1�� �����Ǵ� ���� ���� ���� �ʿ�
 �𷡽ð� - 2�����迭
01 02 03 04 05 	0 - 01234
    06 07 08		1 - 123
         09			2 - 2
     10 11 12			3 - 123
 13 14 15 16 17    4 - 01234
 */
public class sandglass {
	public static void main(String[] args) {
		int n = 5; //�Է¹��� ��
		int start=n; //
		int num=1; //1�� �����Ǵ� ����
		
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