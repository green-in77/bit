package kr.or.bit;
/*
 우리 회사는 비행기를 주문 제작 판매하는 회사입니다.
 우리 회사는 비행기를 생산하는 설계도를 작성하려고 합니다.
 요구사항
 1. 비행기를 생산하고 비행기의 이름과 번호를 부여해야 합니다.
 2. 비행기가 생산되면 비행기의 이름과 번호 맞게 부여되었는지 확인하는 작업이 필요합니다. (출력정보 확인)
 3. 공장장은 현재까지 만들어진 비행기의 총대수(누적)을 확인할 수 있습니다. -> 객체간 공유자원
 
 단 오늘 배운 코드로 설계도 만드시고.. 비행기 3대 생산정보확인하고 누적대수 확인...
 
 조건) 생성자 사용금지....
 
 이 코드는 사실은 50점.... why? 생성자, this 를 안배워서.... 이것을 사용해야 100점짜리 코드를 만들 수 있음.
 현재까지 배운 지식으로 만들 수 있는 코드.
 */
/*
public class Airplane { // 캡슐화 : 멤버는 private로 생성하고 함수를 생성해서 읽고 쓸 수 있게하기!!
	private String airName; // 비행기의 이름
	private  int airNum; // 비행기의 번호
	
	private static int sum; // 비행기의 누적대수 - 객체마다 누력되는 자원(객체간 공유자원) // 메인에서 클래스 이름으로 접근 불가.
		
	public void makeAir(int num, String name) { // private 을 활용하기 위한 함수 생성.
		airName = name;
		airNum = num;
		sum++;
		System.out.printf("이름 : %s, 번호 %d\n",airName, airNum);
	}
	
	public void airsumprint() { // static 을 해도 되지만 요구사항에 구지 없기때문에.
		System.out.printf("누적대수 : %d\n\n " , sum);
	}
}
*/

public class Airplane {
	private String airName; // 비행기의 이름
	private int airNum; // 비행기의 번호
	
	private static int airsum; //비행기의 누적대수
	
	public Airplane (String airName, int airNum){
		this.airName = airName;
		this.airNum = airNum;
		airsum++;
	}
	
	public void air_print() {
		System.out.println("비행기의 이름과 번호 : " + airName + " / " + airNum);
	}
	
	public void airsum_print() {
		System.out.println("누적대수 : " + airsum);
	}
	
}