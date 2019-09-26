package kr.or.bit;
// ���� ���� ����� �ڷᱸ�� stack
// ������ ����� (�������� ����) >> Array
// ������� ��ġ ( index )
// LIFO (���Լ���) : ���
// push, pop, empty,full �Լ�����
public class Mystack {
	private Object[] stackarr;
	private int maxsize; // �ִ�ũ��
	private int top; // �̵����� (index ��) position
	
	public Mystack (int maxsize) { // �����ڷ� �ʱ�ȭ -> ��ü ���� �� �ִ����� �޾Ƽ� �迭����, �ִ������ ���������ֱ�. 
		this.stackarr = new Object[maxsize];
		this.maxsize = maxsize;
		this.top = -1; // �迭�� ���� ������ ǥ��.
	}
	
	public boolean empty() { // �����?? �� true // �ƴ� false
			return (top == -1);
	}
	
	public boolean full() {
		return (top == maxsize-1); // �迭�� ������ �� ��ȣ�� ������( ����� 5�̸� ���ȣ�� 4)
	}
	
	
	public void push(Object data) {
		if(full()) {
			System.out.println("stack full");
		}
		else {
			stackarr[++top] = data; // top �� ó���� -1 �̴ϱ� 0���� ++ ���ְ� ���� ��.
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