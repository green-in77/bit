/*
 1. 1~45������ ������ �߻����� 6���� �迭�� ��������
 2. �迭�� ��� 6���� �迭���� �ߺ����� ������ �ȵǿ�.
 3. �迭�� �ִ� 6���� ���� ���� ������ ���� ��Ű����. (���� : �ڸ��ٲ�)
 4. �� ����� ����ִ� �迭�� ����ϼ���.
 
 ���Ŀ��� ������ Ŭ������ �и��ؼ� Lotto.java �� �и� / ����� main �ȿ��� ����...
 */
public class Ex03_Lotto_Main {

	public static void main(String[] args) {
		int[] lotto = new int[6]; //�ζ� ��ȣ�� ������ 6���� ���� ����.
		
		for (int i = 0 ; i < lotto.length ; i++ ) { // 0���� 5���� 1�� ���� / �� 6�� ��ȯ
			lotto[i] = (int)(Math.random()*45)+1; // �濡 1~45 �������� �Ҵ�
			
			for (int j = 0; j  < i ; j++) { // 0���� i���� ������ / ���� ��. 0�����ͺ�. // j < i ä���� �������� ��.
				if( lotto[i] == lotto[j] ) { // �� �� �� ������ 
					i--; // i ���� => i ���� �� ���Ҵ��� ����. // 1���� == 0���� ������ i�� 0�� �ǰ� �ö󰡸鼭 i++�Ǿ� 1���濡 �������� ���Ҵ�.
					break; // j�� �ɸ� for �� Ż��
				}
			}
		}
		
		//------------------------------------���� (���� �� ä���� ����)
		
		//--------------------------------------��������
		for ( int j = lotto.length-1; j > 0 ; j-- ) {// 5���� 1���� 1�� ���� / ���ϴ� Ƚ�� / 5,4,3,2,1
			
			for (int i = 0; i < j ; i++ ) { // 0���� 5 ���� 1�� ���� / ���ϴ� ��1 �� ��ȣ / 0����, 1����, 2����... ( Ƚ���� �ݺ��ɼ��� ���ϴ� ���� �پ��)
				
				if ( lotto[i] > lotto[i+1] ) { // 0����� 1������ ���ؼ� 0������ ũ�� 1����� �� ��ü / 1�� > 2�� , 2�� > 3�� ...
					int result = lotto[i+1];
					lotto[i+1] = lotto[i];
					lotto[i] = result;
				}
				
			}
			
		}
		
		//swap ����
		for ( int i = 0 ; i < lotto.length ; i++ ) {
			for ( int j = i+1 ; j < lotto.length ; j++) {
				if ( lotto[i] > lotto[j] ) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		for (int i = 0 ; i < lotto.length; i++) {
			System.out.printf("lotto[%d] %d \t", i, lotto[i]);
		}

	}
}