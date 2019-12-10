package Aop_anno2;

import java.util.Scanner;

public class Tea implements Drink {
	@Override
	public void menu() {
		Scanner sc = new Scanner(System.in);
		boolean ischoice = false;
		
		System.out.println("1.버블티 | 2.밀크티");
		
		do {
			String choice = sc.next();
			
			if(choice.equals("1")) {
				System.out.println("버블티를 선택하셨습니다.");
				ischoice = true;
			}else if(choice.equals("2")){
				System.out.println("밀크티를 선택하셨습니다.");
				ischoice = true;
			}else {
				System.out.println("잘못선택하셨습니다. 다시 선택하세요.");
			}
		}while(!ischoice);
	}	
}