import java.util.Scanner;
//����
/* 3������ ����, 4������ ���� / ������ ������ ���� �Ǵ� ���� �������ִ� ���� �ʿ� / 1�� �����Ǵ� ���� ���� ���� �ʿ�
 �𷡽ð� - 2�����迭
01 02 03 04 05 		0 - 01234
    06 07 08			1 - 123
       09					2 - 2
    10 11 12				3 - 123
 13 14 15 16 17     	4 - 01234
 */

public class sandglass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0; //�𷡽ð� ���� ���� �ޱ� ����
		
		do {
			System.out.printf("�𷡽ð� (Ȧ���� �Է��ϼ���.) : ");
			n = Integer.parseInt(sc.nextLine()); //�Է¹��� ��
		} while(!(n%2==1)); // Ȧ������ üũ�ؼ� ¦���� ���Է�
		
		int start=n; //�迭���� �� ���� ���� ������ ���� ������ üũ�ϱ�����
		int num=1; //�迭�� ����Ǵ� 1�� �����Ǵ� ����
		
		int i = 0; //�迭 ���� ���� ���
		
		int[][] intarr = new int[n][n]; //�𷡽ð� ���� �迭 ����
				

		for(i=0;i<n;i++) { // i�� �迭�� �� ��
			
			if(i < ((n/2)+1)) { //�ݱ��� ���� ����, ���ķ� ���� ���� �ϱ� ������ ���ǰ˻� �� for�� 
				
				for(int j = i; j<start;j++) { // j�� �� �� , j�� i���� �����ؼ� start ���� ����������
					intarr[i][j] = num;	// 0,0~4 / 1,1~3 / 2,2
					num++; //���ڰ� �濡 ���� 1�� ����
				}
				
			}else { //�� ���ĺ��ʹ�
				
				for(int j=(start-1);j<=i;j++) { //�� ���ĺ��ʹ� �� ���� ���� 
					intarr[i][j] = num; // 3,1~3 / 4,0~4
					num++;
				}
				
			}
			start--; //�ݱ����� ���� ���� �ٿ��ֱ� ���� / �� ���ķδ� ���� ���� ���������ֱ� ����
		}
//--------------------------------------------------------------------------------------------		
		//2���� �迭 ���
		for (int x = 0; x < n; x++) {
			for (int z = 0; z < n; z++) {
				
				if ( intarr[x][z]==0) { //�迭���� 0�̸�
					//System.out.printf(" ");
					System.out.printf("��");
				}else { //�� �ܿ���...
					System.out.printf("��");
					//System.out.printf("%2d",intarr[x][z]);
					//System.out.printf("(%d,%d)%d ",x,z,intarr[x][z]);
				}
				
			}
			System.out.println(); //1�� ����ϰ� �ٹٲ�
		}
		sc.close();
	}
}