package kr.or.bit;
// 내가 직접 만드는 자료구조 stack
// 데이터 저장소 (여러개의 값을) >> Array
// 저장소의 위치 ( index )
// LIFO (후입선출) : 기능
// push, pop, empty,full 함수구현
public class Mystack {
	private Object[] stackarr;
	private int maxsize; // 최대크기
	private int top; // 이동정보 (index 값) position
	
	public Mystack (int maxsize) { // 생성자로 초기화 -> 객체 생성 시 최대사이즈를 받아서 배열생성, 최대사이즈 정보갖고있기. 
		this.stackarr = new Object[maxsize];
		this.maxsize = maxsize;
		this.top = -1; // 배열의 값이 없음을 표현.
	}
	
	public boolean empty() { // 비었니?? 웅 true // 아니 false
			return (top == -1);
	}
	
	public boolean full() {
		return (top == maxsize-1); // 배열의 마지막 방 번호와 사이즈( 사이즈가 5이면 방번호는 4)
	}
	
	
	public void push(Object data) {
		if(full()) {
			System.out.println("stack full");
		}
		else {
			stackarr[++top] = data; // top 이 처음이 -1 이니까 0으로 ++ 해주고 값이 들어감.
		}
	}
	
	public Object pop() {
		Object value = null;
		if (empty()) {
			System.out.println("stack empty");
		}
		else {
			value = stackarr[top];
			top--;
		}
		return value;
	}
}