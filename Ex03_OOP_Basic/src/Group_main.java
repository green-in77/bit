import java.util.Scanner;

import kr.or.bit.Bitcamp_3;
import kr.or.bit.Department_4;
import kr.or.bit.Goods_2;

//(1층 - 샤넬 / 2층 - 리바이스 / 3층 - 아디다스)
// 층수를 입력하기 전에 사용자에게 몇 층을 입력받을지 질문을 해준다.
// 만약 없는 층이나 잘못된 값을 입력했을 시 층 수를 다시 물어본다.
public class Group_main {

	public static void main(String[] args) {
		/*
		System.out.println("2조");
		//2조 상품--------------------------------------------------------------------------------------------
		Goods_2 g1 = new Goods_2(101010, 3000, "새우깡", "과자", "비할인상품");
		g1.Goods_print();
		g1.setGoodsdiscount("할인상품");
		g1.setGoodsprice(2500);
		g1.Goods_print();
		//---------------------------------------------------------------------------------------------------------
		System.out.println();
		*/
		System.out.println("3조");
		//3조 상품--------------------------------------------------------------------------------------------
		Bitcamp_3 bit1 = new Bitcamp_3("ㅇㅇㅇ", "000-0000-0000");
		bit1.Bit_Print();
		bit1.Choice();
		
		Bitcamp_3 bit2 = new Bitcamp_3("뇽뇽이","111-1111-1111");			
		bit2.setCardnum("1111-1111-2222-2222");
		bit2.Bit_Print();
		bit2.Choice();
		
		//------------------------------------------------------------------------------------------------------
		System.out.println();
		
		
		/*
		System.out.println("4조");
		//4조 백화점----------------------------------------------------------------------
		Scanner sc = new Scanner(System.in);
		int input_floor = 0;
		
		Department_4 dep1 = new Department_4("샤넬", 1);
		Department_4 dep2 = new Department_4("리바이스", 2);
		Department_4 dep3 = new Department_4("아디다스", 3);
			
		do { // 몇 층을 받을 지 질문
			System.out.println("몇 층을 입력하시겠습니까? (1.1층 2.2층 3.3층 4.종료)");
			input_floor = Integer.parseInt(sc.nextLine());
			
			if ( input_floor==1) { // 1이면 
				dep1.Dep_print(); // 1층 출력
			} else if  (input_floor ==2) { // 2이면
				dep2.Dep_print(); // 2층 출력
			} else if ( input_floor ==3){ // 3이면
				dep3.Dep_print(); // 3층 출력
			} else if(input_floor == 4) { //4이면 
				System.out.println("프로그램이 종료됩니다.");
				return; //종료
			} else { // 잘못입력시 
				System.out.println("잘못입력하셨습니다.");
			}
		} while(true);
	//--------------------------------------------------------------------------------------*/		
	}
}
