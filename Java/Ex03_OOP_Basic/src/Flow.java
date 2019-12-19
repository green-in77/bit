import java.util.Scanner;

public class Flow {
	static Scanner sc = new Scanner(System.in);
	
	static int unit = 10000; //화폐단위
	static int num; // 화폐매수
	static int sw; // 스위칭변수, 화폐의 다음 단위를 위해
	
	static void cal() {
		System.out.printf("계산할 금액을 입력하세요 : ");
		int money = Integer.parseInt(sc.nextLine()); // 입력받는 금액
		
		do { // 무한루프
			num = (int)(money/unit);  
			
			System.out.println(unit +" " + num + "개");
			if (unit >1 ) {
				money = money - (unit * num);
				if ( sw==0 ) {
					unit = unit /2;
					sw=1;
				} else {
					unit = unit/5;
					sw=0;
				}
			
			}else {
				break;
			}
		}while(true);
		
	}

	public static void main(String[] args) {
		cal();
	}

}
