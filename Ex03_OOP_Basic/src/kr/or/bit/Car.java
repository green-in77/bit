package kr.or.bit;

public class Car {
	private int window;
	private int speed;
	
	public int getWindow() {
		return window;
	}
	public void setWindow(int window) {
		this.window = window;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		//간접할당의 장점 조건설정가능
		if ( speed <0 ) {
			this.speed = 0;
		}else {
			this.speed = speed;
		}
	}
	//필요하다면 별도의 함수는 언제든지 생성가능.
	public void speedUp() {
		speed += 10;
	}
	
	public void speedDown() {
		if( speed >0 ) {
			speed -= 10;
		} else {
			speed = 0;
		}
	}
	
	
}
