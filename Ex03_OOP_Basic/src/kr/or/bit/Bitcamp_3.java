package kr.or.bit;

import java.util.Scanner;

/*
 비트캠프 수강신청
1. 수강신청자는 반드시 이름, 휴대폰번호를 가지고 있다. 

2. 수강신청에 성공하기 위해서는 반드시 내일배움 카드번호를 가지고 있어야 한다. 

3. 만약 내일 배움카드가 없으면 수강 신청이 불가능하다는 내용이 출력된다.

4. 수강신청자의 정보(이름, 휴대폰번호,(내일 배움카드 번호))만을 출력할 수 있는 특정 기능이 있다.

5. 수강 신청이 가능한 사람은 강의번호(1. java 2. python 3. c)를 특정 기능을 통해서 선택할 수 있다. 
또한 반드시 주어진 목록에서 선택해야 한다.
강의에 따라 학원 센터(1. java - 강남(임경균 강사님♥.♥) 2. python-서초본원 3. c-종로)가 부여된다.

6. 만약 주어진 목록에서 벗어나 강의를 선택한 경우, 다시 강의를 재선택할 수 있다.

7. 이름, 휴대폰번호, 카드번호 정보는 각각 확인할 수 있다.

8. 휴대폰번호는 이후에 수정할 수 있다. 
 */
public class Bitcamp_3 {
	private String name; // 이름
	private String phone; //휴대폰
	private String cardnum; //카드번호
	
	public Bitcamp_3 (String name, String phone) { //수강신청자는 반드시 이름과 휴대폰번호를 가지고 있다.
		this.name = name;
		this.phone = phone;
	}
	
	public void setCardnum(String cardnum) { //내일배움 카드번호 입력.
		this.cardnum = cardnum;
	}

	public void Bit_Print() { //이름, 휴대폰번호, 카드번호 출력 기능
		if (this.cardnum == null) {
			System.out.printf("이름 : %s, 휴대폰번호 : %s\n", this.name, this.phone);
		}else {
			System.out.printf("이름 : %s, 휴대폰번호 : %s, 카드번호 : %s\n", this.name, this.phone, this.cardnum);
		}
	}
	
	public void Choice() { //수강신청
		Scanner sc = new Scanner(System.in);
		int input_num = 0; //입력한 번호를 저장할 변수 
		
		if ( this.cardnum == null ) { // 카드번호가 없으면 
			System.out.printf("내일배움카드가 없어 수강신청 하실 수 없습니다.\n\n"); //수강신청 불가 
		}else { //카드번호가 있으면
			
			do { // 선택 메뉴 출력
				System.out.println("1. java 2. python 3. c");
				System.out.printf("원하시는 강의 번호를 입력하세요. : ");
				input_num = Integer.parseInt(sc.nextLine());
				
				if( input_num == 1) { // 1을 선택하면
					System.out.println("1.java - 강남(임경균 강사님♥.♥");
					return;
				} else if( input_num == 2 ) { // 2를 선택하면
					System.out.println("python-서초본원");
					return;
				}else if ( input_num == 3 ) { // 3을 선택하면
					System.out.println("c-종로");
					return;
				} else { // 그 외 입력시.
					System.out.printf("입력이 잘못되었습니다. 다시 입력해주세요.\n\n");
				}
			}while(true);
		}
		
	}

	public String getPhone() { //휴대폰번호 확인
		return phone;
	}

	public void setPhone(String phone) { // 휴대폰번호 수정가
		this.phone = phone;
	}

	public String getName() { //이름 확인
		return name;
	}

	public String getCardnum() { // 카드번호 확인
		return cardnum;
	}	
}
