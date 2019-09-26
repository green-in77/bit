public class Ex02_Array_Quiz {
	public static void main(String[] args) {
		// ���а� �л����� �⸻��� ��������
		int[] score = new int[] {79,88,97,54,56,95};
		int max = score[0]; //79
		int min = score[0]; //79
		
		// ����� ����ؼ� max ��� ������ �������� �ִ밪, min ������ �ּҰ�.
		// max = 97, min = 54
		//�� for ���� �ѹ��� ���.
		
		for (int i = 1 ; i < score.length; i++) { // 1������� 5���� ���� 1�� ����
			max = (max < score[i]) ? score[i] : max; // max ���� score ���� ���� ũ�� score/ ������ �״�� 
			min = (min > score[i]) ? score[i] : min; // min ���� score ���� ���� ������ score/ ũ�� �״��
			
		}
		
		System.out.printf("max = %d , min = %d\n", max, min);
		
		int[] number = new int[10];
		//10���� ���� ���� 1~10 ������ ������ �ʱ�ȭ
		
		for ( int i = 0 ; i < number.length ; i++ ) { // 0���� 9���� 1�� ����
			number[i] = i+1; // number �濡 i+1 �Ҵ� 
			System.out.printf("number[%d] = %d \t", i, number[i]);
		}
		
		System.out.println();
		//��� �л��� �⸻��� ��������(5����)
		int sum = 0;
		float average = 0f;
		int[] jumsu = {100,55,90,60,78};
		
		//1. �� �����
		//2. ������ ��
		//3. ������ ����� ���ϼ���.
		// ��. 2, 3 �ϳ��� for ���
		
		for (int i = 0 ; i < jumsu.length ; i++) {
			sum += jumsu[i];
			average = (( i == jumsu.length-1) ? sum /(float) jumsu.length : 0);
			/*
			if( i == jumsu.length-1) {
				average = sum / (float)jumsu.length;
			}*/
		}
		
		//average = (float)sum / jumsu.length;
		
		System.out.printf("�� ����� : [%d], ���� : [%d], ��� [%f]", jumsu.length, sum, average);
		

	}

}
