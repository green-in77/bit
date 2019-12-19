// 두개의 설계도
class Tv{
	boolean power; // 기본값 false
	int ch;
	
	void power() {
		this.power = !this.power; // 스위치기능처럼구현.(둘중에 하나)
	}
	
	void chUp() {
		this.ch++;
	}
	void chDown() {
		this.ch--;;
	}
}

class Vcr {
	boolean power;
	
	void power() {
		this.power = !this.power;
	}
	
	void play() {
		System.out.println("재생하기");
	}
	void stop() {
		System.out.println("정지하기");
	}
	void rew() {	}
	void ff() {}
}

//Tv 설계도, Vcr 설계도 활용해서
//TvVcr 라는 설계도를 만드세요.
//기존에 있는 Tv,, Vcr을 재사용(활용) 하겠다.
//활용 : 상속, 포함

//class TvVer extends Tv, Vcr (x) {} 다중상속금지
//class Tv extends Vcr
//class TvVcr extends Tv 계층적 상속도 가능

//선택 : 둘중에 하나 상속, 나머지 한개 포함

// TvVcr : 주기능, 메인기능, 보조 >> 비중이 높은 클래스 >> 상속
//나머지는 포함으로...

//원칙 : memory 올려야...사용가능.
class TvVcr extends Tv {
	Vcr vcr;
	
	TvVcr () {
		vcr = new Vcr();
	}
	
}


public class Ex03_Inherit_Single {

	public static void main(String[] args) {
		TvVcr t = new TvVcr();
		t.power();
		System.out.println("Tv 전원상태 : " + t.power);
		
		t.chUp();
		System.out.println("Tv ch정보 : " + t.ch);
		
		t.vcr.power();
		System.out.println("Vcr 전원상태 : " + t.vcr.power);
		
		t.vcr.play();
		t.vcr.stop();
		t.vcr.power();
		t.power();
		
		System.out.println("Tv 전원상태 : " + t.power);
		System.out.println("Vcr 전원상태 : " + t.vcr.power);
	

	}

}
