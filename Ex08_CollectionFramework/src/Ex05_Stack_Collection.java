import java.util.Stack;
import kr.or.bit.Coin;
import kr.or.bit.Mystack;

//게시판번호 315,316,317 번에 있는 샘플 예제 해보기.
// queue 반드시 해보기...

public class Ex05_Stack_Collection {
	public static void main(String[] args) {
		// Stack 클래스 제공 (LIFO)
		
		Stack stack = new Stack();
		stack.push("A");
		stack.push("B");
		
		System.out.println(stack.pop()); //B ( 후입선출  - 마지막으로 들어간거부터 나옴) 
		System.out.println(stack.pop()); //A
		//System.out.println(stack.pop()); java.util.EmptyStackException -> 비어있는데 꺼내려고해서
		
		System.out.println(stack.isEmpty()); // 비어있니? true
		
		// stack 직접 코드로 만들 수 있어야 한다..............
		
		Mystack my = new Mystack(3);
		System.out.println(my.full());
		
		my.push(10);
		my.push(20);
		my.push(30);
		my.push(40);
		
		System.out.println(my.pop());
		System.out.println(my.pop());
		System.out.println(my.pop());
		System.out.println(my.pop());
		
		Stack<Coin> coinbox = new Stack<Coin>();
		//동전박스에 동전을 넣는다.
		//100,50,500,10
		coinbox.add(new Coin(100));
		coinbox.add(new Coin(50));
		coinbox.add(new Coin(500));
		coinbox.add(new Coin(10));
		
		while (!coinbox.isEmpty()) {
			Coin coin = coinbox.pop();
			System.out.println("꺼낸동전 : " + coin.getValue()+"원");
		}
		
	}
}
