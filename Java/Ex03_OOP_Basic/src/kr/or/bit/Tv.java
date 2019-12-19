package kr.or.bit;
/*
 Tv 설계도
 요구사항 정의
 Tv 는 채널정보를 가지고 있다.(예를 들면 1번~200번까지)
 Tv 는 브랜드 이름을 가지고 있다. ( 예를 들면 삼성, 엘지)
 
 Tv는 채널을 전환 기능을 가지고 있다. (채널은 한 채널씩 이동 가능하다. + - )
  - > 채널을 증가시키는 기능을 가지고 있다.
  - > 채널을 감소시키는 기능을 가지고 있다.
  
 Ex01_Ref_Type 의 main 함수 안에서 Tv 2대 생성해 보기.
 */
public class Tv {
	public int ch;
	public String brand;
	
/*	public void ch_change (String sign) {
		if(sign == "+") {
			ch++;
		} if(sign == "-") {
			ch--;
		} 
	}
*/
	
	public void ch_plus () {
		ch++;
	}
	public void ch_minus () {
		ch--;
	}
}
