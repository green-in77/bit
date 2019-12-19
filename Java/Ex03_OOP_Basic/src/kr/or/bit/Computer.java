/*
 컴퓨터

고유 : 제작회사, 모델, 메모리

상태 :  전원이 있다, 사용중인 CPU와 메모리 총 이용률

부품 : 그래픽카드, 모니터, 키보드, 마우스, 프린터, 본체

기능
1. 프로그램을 실행한다 / 프로그램을 종료한다
프로그램을 제거한다
2. 프로그램을 저장한다 / 프로그램을 편집한다
3. 모니터에 화면을 출력한다
키보드로 입력을 받는다
프린터로 출력하게 만든다
4. 사용량 조회를 할 수 있다
*/

package kr.or.bit;

public class Computer {
	public String company; // 제작회사
	public String model; //모델
	public String memory; //메모리
	public boolean power; // 전원
	
	public int cpu_ues; //cpu 이용률
	public int memort_ues; //메모리 이용률
	
	public Program pro; //프로그램
	//public keyboard keyboard; //키보드
	
	public boolean run_exit(int i) { //true 실행,flase 종료
		return (i == 1) ? true : false ;
	}
	
	public void word_wirte(String str) { // 워드 쓰기(저장)
		Program pro = new Program();
		pro.word = str;
	}
	
	public int use(String str) {
		//조회할 것을 str에 문자열로 받아서 (cpu인지 memory 인지) 사용량 조회해서 int 값으로 리턴.
		return 1;
	}
	
	public void output (String str) {
		//출력할 값을 str에 문자열로 받아서 화면에 출력(리턴값없음)
	}
	
	public void del (String str) {
		//삭제할 프로그램 명을 str에 문자열로 받아서 삭제.
	}
	
}

//public class keyboard {
	//public int key; //키보드 키의 갯수.
//}
