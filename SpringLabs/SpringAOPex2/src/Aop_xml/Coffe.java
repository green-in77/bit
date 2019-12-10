package Aop_xml;

import java.util.Scanner;

public class Coffe implements Drink {
	@Override
	public void menu() {
		Scanner sc = new Scanner(System.in);
		boolean ischoice = false;
		
		System.out.println("1.아메리카노 | 2.카페라떼");
		
		do {
			String choice = sc.next();
			
			if(choice.equals("1")) {
				System.out.println("아메리카노를 선택하셨습니다.");
				ischoice = true;
			}else if(choice.equals("2")){
				System.out.println("카페라떼를 선택하셨습니다.");
				ischoice = true;
			}else {
				System.out.println("잘못선택하셨습니다. 다시 선택하세요.");
			}
		}while(!ischoice);
	}
}