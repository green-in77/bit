import java.util.Scanner;

public class Ex08_Statement {

	public static void main(String[] args) {
	
		System.out.println("�Է�");
		Scanner sc = new Scanner(System.in);
				// Ctrl + Shift + 0 (import �ڵ������ϱ�)
		if(sc.hasNextInt()) { // �ǹ��� �Լ� > true or false ���� ��ȯ / has // �Է¹��� ���� �����ΰ�?
			System.out.println("�������̾�");		
		}else {
			System.out.println("�ٸ����ε�");
		}
		
		// sc.hasNextLine() ���ڿ� �������ΰ�? >> True or False
	 
		
		//��� (�ϱ�����!!!!!)
		//���ǹ� ( if 3���� - ����, if-else, if-elseif-else), (switch(){case .... break})
		//�ݺ��� ( for - �ݺ�Ƚ�� ��Ȯ), (while - �ݺ�Ƚ���� ��Ȯ���� ����. true, false), do~while()
		//�б⹮ ( break - ��Ż��, continue -  �Ʒ����� skip)
		
		int count = 0;
		if (count < 1) {
			System.out.println("True �Դϴ�.");
		}
		//���� ���� �������� - 
		//�ڹ� - ; (�����ݷ�)�� ������ ��. (�ؼ��� ����) 
		if (count < 10)    // ���ٷ� �ᵵ �������. if (count < 10) System.out.println("{True}");
			System.out.println("{True}");
		
		//�ڵ带 �ܿ��� ���� �ó������� �ܿ��!!!!!
		
		char data = 'A';
		switch(data) { //switch ���ڰ� : int ����(����), char ����, String ���ڿ� ����)
			case 'A' : System.out.println("���ں�");
				break; // Ż������� switch ��
			default : System.out.println("else ��� ��");
		}
		
		//�ݺ���
		int sum = 0;
		for(int i = 1; i <= 10; i++) { // i�� 1�� �����ؼ� i�� 10���� �۰ų� ������ ���� ��Ű�� i�� ����
			//System.out.println(i);
			//������
			sum += i; //sum = sum + i
		}
		
		System.out.println("sum 1~10 : " +  sum);
		
		// for ���� ����ؼ� 1~10 ������ Ȧ���� �� ���ϱ�
		//�� for �ϳ��� ����.( for ���ȿ� if�� ���� ����)
		
		sum = 0;
		for (int i = 1; ( i <= 10 ) ; i+=2) { // ������ ���� �����ؼ�
			sum += i;
		}
		
		System.out.println("1~10 �� Ȧ���� ��: " +  sum);

		// 1~100 ������ ¦���� ��. (if �� ���)
		int sum3=0;
		for (int i = 0; i <= 100 ; i++) {
			if( i %2 == 0 ) {
				sum3 += i;	// sum3 = sum3 + i
			}
		}
		System.out.println("1~100 ������ ¦���� �� : " + sum3 );
		
		//�Ի���� �ʼ�����
		//������ ¥�� (��ø for �� ����ϱ�)
		//2��(1~9) ~ 9��(1~9) ����
		
		for (int i = 2; i <= 9 ; i++){
			for (int j = 1 ; j <= 9 ; j++) {
				System.out.printf("%d x %d = %d \t", i,j,i*j);
			}
			System.out.println();
		}
		
		System.out.println();
		
		//key point : break - Ż�� , continue -��ŵ
		
		for (int i = 2; i <= 9 ; i++){
			for (int j = 1 ; j <= 9 ; j++) {
				if(i == j ) {
					break; // ���� for �� Ż�� // 2*2 �� ���ķ� �ȳ���
				}
				System.out.printf("%s","*"); // ��1��, 2��, 3��, 4�� ~~ 8������ ���
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 2; i <= 9 ; i++){
			for (int j = 1 ; j <= 9 ; j++) {
				if(i == j ) continue; // �Ʒ��� ������ ��ŵ	 // 2*2, 3*3�� �ȳ����� �������� ����.
				System.out.printf("%d x %d = %d \t", i,j,i*j);
				//System.out.printf("%s","*"); // ��1��, 2��, 3��, 4�� ~~ 8������ ���
			}
			System.out.println();
		}
		
		for (int i = 100; i >= 0 ; i-- ){
			System.out.println(i);
		}
		
		System.out.println("�Ǻ���ġ����");
		
		int a=0, b=1, c=0;
		
		for(int i = 0; i <10; i++) {
			a=b;
			b=c;
			c=a+b;
			System.out.println(c);
			
		}
	
		//���� ���̴� ���� (������ �����ҋ�) �ܿ��α�.
		for(int i = 2 ; i <= 9 ; i++) {
			for(int j = 1 ; j < i  ; j++) {  // j <= 9 
				System.out.print("*");
			}
			System.out.println();
		}
		
		

	}

}
