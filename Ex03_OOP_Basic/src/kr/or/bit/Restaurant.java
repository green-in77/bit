/*
  1조 멤버필드 만들기.
  음식점 >> 음식점 보다는 스테이크의 정보... // 표현 범위가 광범위했음.
  고유 - 메뉴 코드 - 숫자
  고유 - 음식 이름 - 문자열
  고유 - 메뉴 분류 (밥, 면) - 문자열
  고유 - 메뉴 가격 - 숫자
  부품 - 음식 정보 - 고유 - 칼로리, 고유 - 무게
  
  속성을 3가지로 구분 : 고유, 상태, 부품
 */

package kr.or.bit;

public class Restaurant {
	public int code; //메뉴코드
	public String name; //음식이름
	public String type; // 메뉴분류
	public int price; //메뉴가격
	public infomation info;// 음식정보
	
}

class infomation { // 음식정보
	public int cal; //칼로리
	public int weight; //무게
}



// 조회 기타 한도계좌해제 한도제한해제