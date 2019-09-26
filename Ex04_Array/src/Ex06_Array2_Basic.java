import kr.or.bit.Emp;

public class Ex06_Array2_Basic {

	public static void main(String[] args) {
		//2����(�����)
		//[��][��]

		int[][] score = new int[3][2];
		System.out.println(score[0][0]);
		System.out.println(score[2][1]);
		
		score[0][0] = 100;
		score[0][1] = 200;
		
		score[1][0] = 300;
		score[1][1] = 400;
		
		score[2][0] = 500;
		score[2][1] = 600;
		
		//���� ��, ���� ��
		System.out.println(score.length); //���� ��
		System.out.println(score[0].length); //0���� ����  ��
		
		//���� ���� : �迭�̸�.length 
		//���� ���� : �迭�̸�[i].length �ڡڡ�
		
		for(int i = 0 ; i < score.length ; i++ ) {
			for (int j = 0 ; j < score[i].length ; j++) {
				System.out.printf("score[%d][%d] = %d\t", i, j, score[i][j]);
			}
			System.out.println();
		}
		
		//Today Point 
		//������ for ��, ���� for ��
		// JAVA : for ( Type ������ : �迭 or collection ) { ���౸��... ����������  }
		// C#     : for ( Type ������ in �迭 or collection ) {  ���౸��...���������� }  
		// javascript : for ( Type ������ in �迭 or collection ) {  ���౸��...���������� }
		
		int[] arr3 = {5,6,7,8,9};
		/*
		for (int i = 0 ; i < arr3.length ; i++ ) {
			System.out.println(arr3[i]);
		}
		*/
		for (int value : arr3) {
			System.out.println(value);
		}
		
		String[] strarr = {"A","B","C","D","FFFF"};
		for ( String value : strarr ) {
			System.out.println(value);
		}
		
		Emp[] list = {new Emp(1,"A"), new Emp(2,"B"), new Emp(3,"C")};
		for ( Emp value : list) {
			value.empInfoPrint();
		}
		
		//���Ŀ������
		int[][] score3 = new int[][] {
														{11,12},
														{13,14},
														{15,16}
		                                              };
		                                              
		//������ for �� 2���� �迭�� �� ��� 
		                                              
		for ( int[] rows : score3 ) { // ���� �ּҰ� ��ȯ
			for (int value : rows) { // �ּҰ����� ���� ã�ư�.
				System.out.println(value);
			}
		}
		
		
	}

}
