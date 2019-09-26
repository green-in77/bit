// 은행계좌를 하나 가지고 있다.
// 은행 계좌를 통해 입금, 출금 처리를 할 수 있다.

//친구 5명 똑같은 카드 복제
//동시에 계좌에서 같은 금액을 출금

//통장 1000만원
//ATM 기기에  동시에 출금처리.....

//막아야한다. 누군가가 출금을 먼저 시작하면...
//[출금 ~ 끝날때까지 ] 다른사람은 접근하지 못하게 막아야함.
class Account { //계좌
	int balance = 1000; //잔액
	synchronized void withDraw(int money) {
		System.out.println("고객 : " + Thread.currentThread().getName());
		System.out.println("현재 잔액 : " +  this.balance);
		
		if ( this.balance >= money ) {
			try {
				Thread.sleep(1000); //1초 // 홍길동 인출 시 1초 지연...(인증, 비번받는 시간들..)
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			this.balance -= money;
			System.out.println("인출금액 : " + money);
		}
		
		System.out.println("인출 후 잔액 : " + this.balance);
	}
}

class Bank implements Runnable {
	Account acc = new Account();
	
	@Override
	public void run() {
		while (acc.balance > 0 ) {
			int money =((int)(Math.random()*3)+1)*100;
			
			acc.withDraw(money);
		}
	}
}

public class Ex11_Sync_Thread {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		Thread th1 = new Thread(bank,"park");
		Thread th2 = new Thread(bank,"kim");
		Thread th3 = new Thread(bank,"lee");
		
		th1.start();
		th2.start();
		th3.start();

	}
}
