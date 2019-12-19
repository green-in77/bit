package kr.or.bit;

import java.util.Random;
import java.util.Scanner;

public class Lotto {
	private int[] numbers; // = new int[6]; ������� ����/ �����ڿ��� �ʱ�ȭ.
	private Random r;
	private Scanner scanner;
	// �� 3���� ������ Lotto class �� �ִ� ��� �Լ��� ����� �� �ִ�.
	
	public Lotto() {
		//[�ʱ�ȭ] �� [������] ����.. �̻ۼ��赵.....
		numbers = new int[6]; //��Ģ������ �ʱ�ȭ�� �����ڿ���.
		r = new Random();
		scanner  = new Scanner(System.in);
		
	}
	// �� ��� �и� : �Լ� : �Լ� �ϳ��� ��� �ϳ�.
	public void selectLottoNumber() {
loop_1:while(true) {
			String selection = showMenu(scanner);
			switch(selection) {
				case "1":
						do {
							makeLottoNumber(r,numbers);
						}while(!checkAverage(numbers));
						showNumbers(numbers);
						break;
				case "2": // ���α׷� ���� (return, System.exit(0), �Լ� ������ )
					System.out.println("Good Lucky");
					break loop_1;
				default : System.out.println("Not in Operation");
					break;
			}	
		}
	}
	
	//�ζǹ�ȣ ����� �Լ�.
	private void makeLottoNumber(Random r, int[] numbers) {
		
		for (int i = 0 ; i < numbers.length ; i++ ) { // 0���� 5���� 1�� ���� / �� 6�� ��ȯ
			numbers[i] = r.nextInt(45) +1; // �濡 1~45 �������� �Ҵ�
			
			for (int j = 0; j  < i ; j++) { // 0���� i���� ������ / ���� ��. 0�����ͺ�. // j < i ä���� �������� ��.
				if( numbers[i] == numbers[j] ) { // �� �� �� ������ 
					i--; // i ���� => i ���� �� ���Ҵ��� ����. // 1���� == 0���� ������ i�� 0�� �ǰ� �ö󰡸鼭 i++�Ǿ� 1���濡 �������� ���Ҵ�.
					break; // j�� �ɸ� for �� Ż��
				}
			}
		}
	}
	
	//��Ģ (�迭�� ���� ��� Ư�� ���� �ش�Ǹ� ����... �׷��� ������ ������)
	private boolean checkAverage (int[] numbers) {
		int sum = 0;
		int average = 0;
		for ( int i = 0 ; i < numbers.length ; i++) {
			sum+= numbers[i];
		}
		average = sum/numbers.length;
		System.out.println("��� : " + average);
		return(average >= 15 && average <= 25);
	}
	
	private void showNumbers(int[] numbers) {
		System.out.println("[������ ��ȣ] ");
		
		for ( int j = numbers.length-1; j > 0 ; j-- ) {// 5���� 1���� 1�� ���� / ���ϴ� Ƚ�� / 5,4,3,2,1
			
			for (int i = 0; i < j ; i++ ) { // 0���� 5 ���� 1�� ���� / ���ϴ� ��1 �� ��ȣ / 0����, 1����, 2����... ( Ƚ���� �ݺ��ɼ��� ���ϴ� ���� �پ��)
				
				if ( numbers[i] > numbers[i+1] ) { // 0����� 1������ ���ؼ� 0������ ũ�� 1����� �� ��ü / 1�� > 2�� , 2�� > 3�� ...
					int result = numbers[i+1];
					numbers[i+1] = numbers[i];
					numbers[i] = result;
				}
			}			
		}
		for (int i = 0 ; i < numbers.length ; i++) {
			System.out.printf("[%2d]",numbers[i]);
		}
		System.out.println();
	}
	

	// �޴� ���� ��� �Լ�
	private String showMenu(Scanner scanner) {
		System.out.println("***********************");
		System.out.println("1. ��÷ ���� ��ȣ �����ϱ� : ");
		System.out.println("2. ���α׷� ����^^");
		System.out.println("***********************");
		System.out.printf("���ϴ� �۾� ��ȣ�� �����ϼ��� : ");
		String selection = scanner.nextLine();
		return selection;
	}
	
}
