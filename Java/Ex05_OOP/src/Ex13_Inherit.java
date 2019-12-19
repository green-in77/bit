/*
요구사항
카트 (Cart)
카트에는 매장에 있는 모든 전자제품을 담을 수 있다 
카트(= 배열사용)의 크기는 고정되어 있다 (10개) : 1개  , 2개 담을 수 있고 최대 10개까지 담을 수 있다
고객이 물건을 구매 하면 ... 카트에 담는다

계산대에 가면 전체 계산
계산기능이 필요
summary() 기능 추가해 주세요 
당신이 구매한 물건이름 과 가격정보 나열
총 누적금액 계산 출력
호서

구매자 함수 안에 두 함수 다 포함.
hint) 카트 물건을 담는 행위 (Buy())
hint) Buyer ..>> summary()  main 함수에서 계산할때

구매자는 default 금액을 가지고 있고 초기금액을 설정할 수 도 있다
*/

class Buyer1{
	int money;
	int point;
	Product1[] cart;
	int count;
	
	
	Buyer1 () { // 구매자는 default 금액을 가지고 있고.
		this(100000);
	}
	Buyer1 (int money) { // 초기 금액을 설정할 수 있다.
		this.money = money;
		this.cart = new Product1[10];
	}

	void Buy(Product1 n) { // 구매할 물건을 cart에 담는다.
		if(count < 10) { // count는 현재까지 담은 물건의 갯수. // 10개 미만이면
			cart[count++] = n; // 카트에 물건을 담고 1증가			//count++; // 담은 물건 카운트
			System.out.println(count +"." + n + " 카트에 담겼습니다.");
		} else { // 10개까지 모두 담았을 경우.
			System.out.printf("\n더이상 담을 수 없습니다.\n");  
			return;
		}
	}
	
	void summary() { //전체 계산 기능.
		int sum=0; // 총 누적금액을 담을 변수.
		for ( int i = 0 ; i < count ; i++ ) { // cart 배열에 담긴 물건 호출
			if(this.money < cart[i].price) { // 계산할 돈이 있는지 확인.
				System.out.println("잔액이 부족합니다. " + this.money);
				return; // 함수종료 // 구매행위를 할 수 없게 막음.
			} else {
				System.out.printf("[%d] 당신이 구매한 물건은 %s , %d 원 입니다.\n",(i+1),cart[i].toString(), cart[i].price);
				this.money -= cart[i].price;
				System.out.println("구매 후 남은 잔액 : " + this.money);
				sum += cart[i].price; // 금액 누적
			}
		}
		System.out.println("총 누적금액  : " + sum);	
			
		}
	}


class Product1 {
	int price;
	int point;
	
	Product1 (int price) {
		this.price = price;
		this.point = (int)(this.price*0.1);
	}
}

class E_Tv1 extends Product1 {
	E_Tv1() {
		super(5000);
		//this.price = 5000;
		//this.point = (int)(this.price *0.1);
	}
	
	@Override
	public String toString() {
		return "Tv";
	}	
}

class E_Audio1 extends Product1 {
	E_Audio1() {
		super(3000);
	}

	@Override
	public String toString() {
		return "Audio";
	}
}
class E_NoteBook1 extends Product1 {
	E_NoteBook1() {
		super(10000);
	}

	@Override
	public String toString() {
		return "NoteBook";
	}
}

public class Ex13_Inherit {

	public static void main(String[] args) {
		E_Tv1 tv = new E_Tv1();		
		E_Audio1 au = new E_Audio1();
		E_NoteBook1 note = new E_NoteBook1();
		
		Buyer1 bu = new Buyer1();
		
		bu.Buy(tv);
		bu.Buy(au);
		bu.Buy(note);
		bu.Buy(tv);
		bu.Buy(au);
		bu.Buy(note);
		bu.Buy(tv);
		bu.Buy(au);
		bu.Buy(note);
		bu.Buy(tv);
		bu.Buy(au);
		bu.Buy(note);
		
		bu.summary();
		

	}

}
