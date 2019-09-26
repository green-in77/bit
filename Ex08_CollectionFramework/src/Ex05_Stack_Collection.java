import java.util.Stack;
import kr.or.bit.Coin;
import kr.or.bit.Mystack;

//�Խ��ǹ�ȣ 315,316,317 ���� �ִ� ���� ���� �غ���.
// queue �ݵ�� �غ���...

public class Ex05_Stack_Collection {
	public static void main(String[] args) {
		// Stack Ŭ���� ���� (LIFO)
		
		Stack stack = new Stack();
		stack.push("A");
		stack.push("B");
		
		System.out.println(stack.pop()); //B ( ���Լ���  - ���������� ���ź��� ����) 
		System.out.println(stack.pop()); //A
		//System.out.println(stack.pop()); java.util.EmptyStackException -> ����ִµ� ���������ؼ�
		
		System.out.println(stack.isEmpty()); // ����ִ�? true
		
		// stack ���� �ڵ�� ���� �� �־�� �Ѵ�..............
		
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
		//�����ڽ��� ������ �ִ´�.
		//100,50,500,10
		coinbox.add(new Coin(100));
		coinbox.add(new Coin(50));
		coinbox.add(new Coin(500));
		coinbox.add(new Coin(10));
		
		while (!coinbox.isEmpty()) {
			Coin coin = coinbox.pop();
			System.out.println("�������� : " + coin.getValue()+"��");
		}
		
	}
}
