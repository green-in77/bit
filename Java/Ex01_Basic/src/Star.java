
public class Star {

	public static void main(String[] args) {
	 
		
		int Line = 0, Star = 0, Null=0 ;
		
		//�������� �ﰢ��
		System.out.println("�������� �ﰢ��");
		for( Line = 1 ; Line <= 8 ; Line++) { // 1���� 8���� 1�� �����ϸ� �ݺ�. Line ���� 9���Ǹ� �� ( ���� 8���� ��ڴ�. )
			for( Star = 1 ; Star <=  Line  ; Star++) {  //1���� Line ���� Ŀ�������� 1�� �����ϸ� �ݺ�. Star ���� Line ������ ũ�� �� ( ���� �ش��� ��ŭ ��ڴ�. 1���� 1��, 2���� 2�� ...)
				System.out.print("*"); // �����
			}
			System.out.println();// 1ȸ �ݺ��� ���� �ٹٲ�
		}
		System.out.println();
		
		// �������� ���ﰢ��
		System.out.println("�������� ���ﰢ��");
		for(Line = 1 ; Line <= 8 ; Line++) { // 1���� 8���� 1�� �����ϸ� �ݺ�.Line ���� 9���Ǹ� �� ( ���� 8���� ��ڴ�. )
			// System.out.println(i);
			
			for(Star = 8 ; Star >=  Line ; Star-- ) { // 8�� Line���� �۾��������� 1�� �����ϸ� �ݺ�.Star ���� Line ������ ������ �� ( Star ����  Line ���� �� ������ ���� ��ڴ�. - Line �� 1�̶�� 8��, 2��� 7�� )   
				// System.out.print(j);
				System.out.print("*"); //�����
			}
			
			System.out.println(); // 1ȸ �ݺ��� ���� �� �ٲ�
		}
		
		System.out.println();
	
		
		//������ ���� �ﰢ��
		System.out.println("���������� �ﰢ��");
		for(Line = 1; Line <= 8 ; Line++) { //  1���� 8���� 1�� �����ϸ� �ݺ�. Line ���� 9���Ǹ� �� ( ���� 8���� ��ڴ�. )
			for(Null = 8 ; Null >= Line ; Null-- ) { // 8�� Line���� �۾��������� 1�� �����ϸ� �ݺ�.Null ���� Line ������ ������ �� ( Null ���� Line ���� �� ������ ������ ��ڴ�. - Line �� 1�̶�� 8��, 2��� 7��)
				System.out.print(" "); // �������
			}
						
			for( Star = 1 ; Star <= Line ; Star++ ) { // 1�� Line���� Ŀ�������� 1�� �����ϸ� �ݺ�. Star ���� Line ������ ũ�� �� ( ���� �ش��� ��ŭ ��ڴ�. 1���� 1��, 2���� 2�� ...) 
			System.out.print("*"); //�����
			}
			System.out.println(); // 1ȸ �ݺ��� ���� �� �ٲ�
						
		}
		
		System.out.println();
		
		// ������ ���� ���ﰢ��
		System.out.println("���������� ���ﰢ��");
		for ( Line = 1; Line <=8 ; Line++) { //  1���� 8���� 1�� �����ϸ� �ݺ�. Line ���� 9���Ǹ� �� ( ���� 8���� ��ڴ�. )
			for( Null =1; Null <= Line ; Null++ ) { // 1�� Line ���� Ŀ�������� 1�� �����ϸ� �ݺ�. Null ���� Line ������ ũ�� ��.( �ش� �ٸ�ŭ ������ ��ڵ�. 1���� 1��, 2���� 2��...)
				System.out.print(" "); //�������
			}
		
			for (Star = 8; Star >= Line ; Star--) { // 8�� Line ���� �۾����� ���� 1�� �����ϸ� �ݺ�. Star ���� Line ������ ������ ��. (Star ���� Line ���� �� ������ ���� ��ڴ�. - Line�� 1�̶�� 8��, 2��� 7��)
				System.out.print("*");
			}
			
			System.out.println(); // 1ȸ �ݺ��� ���� �� �ٲ�
			
		}
		System.out.println();
		
	// �߾����� �ﰢ��
		
		for (Line = 1; Line <= 5 ; Line++ ) { //1���� 8���� 1�� �����ϸ� �ݺ�. Line ���� 5�� �Ǹ� ��.(���� 5���� ��ڴ�.)
			for (Null = 5 ; Null >= Line ; Null--) { // 5�� Line ���� ���������� 1�� �����ϸ� �ݺ�. Null ���� Line ������ ������ ��.(Null ���� Line �� �ɶ����� �������/Line 1 �̸� 5��, 2�̸� 4,...)
				System.out.print(" "); //�������
			}
			
			for (Star = 1; Star <= (2*Line)-1 ; Star++){ //1���� Ȧ�������� 1�� �����ϸ� �ݺ�(2*1)-1 = 1, (2*2)-1 = 3... (Ȧ����ŭ �����)
				System.out.print("*"); //�����
			}
			System.out.println(); //1ȸ �ݺ��� ���� �� �ٲ�
		}
	}
}
