/*
 시나리오(요구사항)
 저희는 가전제품 매장 솔루션을 개발하는 사업팀입니다.
 A라는 전자제품 매장이 오픈되면
 [클라이언트 요구사항]
 가전제품은 제품의 가격, 제품의 포인트 정보를 공통적으로 가지고 있습니다.
 각각의 가전제품은 제품별 고유한 이름을 가지고 있다.
 
 Ex)
 각각의 전자제품은 이름을 가지고 있다 (tc, audio, computer)
 각각의 전자제품은 다른 가격을 가지고 있다.(tv 5000 audio 6000)
 제품의 포인트는 가격의 10% 적용한다.
 
 시뮬레이션 시나리오
 구매자 : 제품을 구매하기 위한 금액정보, 포인트정보를 가지고 있다.
 예를들면 : 10만원, 포인트 0
 구매자는 제품을 구매할 수 있다, 구매행위를 하게되면 가지고 있는 돈은 감소하고 포인트는 올라간다.
 구매자는 처음 초기금액을 가질 수 있다.
 
 */
class Buyer{
	static int money;
	static int point;
	
	Buyer () {
		this.money = 10000;
	}
	
	//구매행위 == 구매함수
	//구매행위 >> 잔액 - 제품가격, point 정보 갱신
	// 구매자는 매장에 있는 모든 제품을 구매할 수 있다.
	/*
	1차 코드 배포 ... 
	void kttvBuy(KtTv n) {  //함수가 제품객체를 parameter 받아야  POINT
    	if(this.money < n.price) {
    		System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
    		return; //함수 종료 (구매행위 대한 종료)
    	}
    	//실 구매 행위
    	this.money -= n.price; //잔액
    	this.bonuspoint += n.bonuspoint; //누적  +=
    	System.out.println("구매한 물건은 : " + n.toString());
    }
    
	void audioBuy(Audio n) { //함수가 제품객체를 parameter 받아야  POINT
    	if(this.money < n.price) {
    		System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
    		return; //함수 종료 (구매행위 대한 종료)
    	}
    	//실 구매 행위
    	this.money -= n.price; //잔액
    	this.bonuspoint += n.bonuspoint; //누적  +=
    	System.out.println("구매한 물건은 : " + n.toString());
		
	}
    
	void notebookBuy(NoteBook n) { //함수가 제품객체를 parameter 받아야  POINT
    	if(this.money < n.price) {
    		System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
    		return; //함수 종료 (구매행위 대한 종료)
    	}
    	//실 구매 행위
    	this.money -= n.price; //잔액
    	this.bonuspoint += n.bonuspoint; //누적  +=
    	System.out.println("구매한 물건은 : " + n.toString());
		
	}
	*/
	
	
	//2차 개선 코드 (리펙토링)
	//[하나의 이름]으로 여러가지 기능(parameter 타입 과 개수를 달리)
	//method overloading
	/*
	void Buy(KtTv n) {  //함수가 제품객체를 parameter 받아야  POINT
    	if(this.money < n.price) {
    		System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
    		return; //함수 종료 (구매행위 대한 종료)
    	}
    	//실 구매 행위
    	this.money -= n.price; //잔액
    	this.bonuspoint += n.bonuspoint; //누적  +=
    	System.out.println("구매한 물건은 : " + n.toString());
    }
    
	void Buy(Audio n) { //함수가 제품객체를 parameter 받아야  POINT
    	if(this.money < n.price) {
    		System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
    		return; //함수 종료 (구매행위 대한 종료)
    	}
    	//실 구매 행위
    	this.money -= n.price; //잔액
    	this.bonuspoint += n.bonuspoint; //누적  +=
    	System.out.println("구매한 물건은 : " + n.toString());
		
	}
    
	void Buy(NoteBook n) { //함수가 제품객체를 parameter 받아야  POINT
    	if(this.money < n.price) {
    		System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
    		return; //함수 종료 (구매행위 대한 종료)
    	}
    	//실 구매 행위
    	this.money -= n.price; //잔액
    	this.bonuspoint += n.bonuspoint; //누적  +=
    	System.out.println("구매한 물건은 : " + n.toString());
		
	}
	*/
	
	
	//3차 개선 ( 중복 코드 제거)
	//제품이 계속적으로 추가되더라도 구매행위 기능은 추가적으로 만들지 않는다.
	//why : 즐거운 휴가를 보내야 되니까...
	//하나의 이름으로, 반복코드 제거...
	//KEY POINT : 모든 제품은 Product 상속하고 있다.
	//모든 제품의 부모는 Product
	//단 부모는 자신의 것만 접근 가능.
	void E_Buy(Product n) { // 함수가 제품객체를 parameter로 받아야 함. // 부모는 자식의 주소를 받을 수 있다.
		if(this.money < n.price ) {
			System.out.println("잔액이 부족합니다. " + this.money);
			return; // 함수종료 // 구매행위를 할 수 없게 막음.
		}
		else {
			this.money -= n.price;
			this.point += n.point;
			System.out.println("구매한 물건은 : " + n.toString()+ " 입니다.");
			System.out.println("잔액 : " + this.money);
			System.out.println("포인트 : " + this.point);
			System.out.println();
		}
	}
}

class Product {
	int price;
	int point;
	
	Product (int price) {
		this.price = price;
		this.point = (int)(this.price*0.1);
	}
}

class E_Tv extends Product {
	E_Tv() {
		super(5000);
		//this.price = 5000;
		//this.point = (int)(this.price *0.1);
	}
	/*
	E_Tv(int price){
		super(price)
	}*/

	@Override
	public String toString() {
		return "Tv";
	}	
}

class E_Audio extends Product {
	E_Audio() {
		super(3000);
	}

	@Override
	public String toString() {
		return "Audio";
	}
}
class E_NoteBook extends Product {
	E_NoteBook() {
		super(10000);
	}

	@Override
	public String toString() {
		return "NoteBook";
	}
}




public class Ex12_Inherit_KeyPoint {
	public static void main(String[] args) {
		E_Tv tv = new E_Tv();
		System.out.println(tv.toString());
		
		E_Audio au = new E_Audio();
		System.out.println(au.toString());
		
		E_NoteBook note = new E_NoteBook();
		System.out.println(note.toString());
		
		Buyer bu = new Buyer();
		
		System.out.println();
		//1차 오픈 테스트
		//구매행위
		bu.E_Buy(tv);
		bu.E_Buy(au);
		bu.E_Buy(note);
		
	}
}
