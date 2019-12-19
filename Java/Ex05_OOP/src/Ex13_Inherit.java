/*
�䱸����
īƮ (Cart)
īƮ���� ���忡 �ִ� ��� ������ǰ�� ���� �� �ִ� 
īƮ(= �迭���)�� ũ��� �����Ǿ� �ִ� (10��) : 1��  , 2�� ���� �� �ְ� �ִ� 10������ ���� �� �ִ�
���� ������ ���� �ϸ� ... īƮ�� ��´�

���뿡 ���� ��ü ���
������� �ʿ�
summary() ��� �߰��� �ּ��� 
����� ������ �����̸� �� �������� ����
�� �����ݾ� ��� ���
ȣ��

������ �Լ� �ȿ� �� �Լ� �� ����.
hint) īƮ ������ ��� ���� (Buy())
hint) Buyer ..>> summary()  main �Լ����� ����Ҷ�

�����ڴ� default �ݾ��� ������ �ְ� �ʱ�ݾ��� ������ �� �� �ִ�
*/

class Buyer1{
	int money;
	int point;
	Product1[] cart;
	int count;
	
	
	Buyer1 () { // �����ڴ� default �ݾ��� ������ �ְ�.
		this(100000);
	}
	Buyer1 (int money) { // �ʱ� �ݾ��� ������ �� �ִ�.
		this.money = money;
		this.cart = new Product1[10];
	}

	void Buy(Product1 n) { // ������ ������ cart�� ��´�.
		if(count < 10) { // count�� ������� ���� ������ ����. // 10�� �̸��̸�
			cart[count++] = n; // īƮ�� ������ ��� 1����			//count++; // ���� ���� ī��Ʈ
			System.out.println(count +"." + n + " īƮ�� �����ϴ�.");
		} else { // 10������ ��� ����� ���.
			System.out.printf("\n���̻� ���� �� �����ϴ�.\n");  
			return;
		}
	}
	
	void summary() { //��ü ��� ���.
		int sum=0; // �� �����ݾ��� ���� ����.
		for ( int i = 0 ; i < count ; i++ ) { // cart �迭�� ��� ���� ȣ��
			if(this.money < cart[i].price) { // ����� ���� �ִ��� Ȯ��.
				System.out.println("�ܾ��� �����մϴ�. " + this.money);
				return; // �Լ����� // ���������� �� �� ���� ����.
			} else {
				System.out.printf("[%d] ����� ������ ������ %s , %d �� �Դϴ�.\n",(i+1),cart[i].toString(), cart[i].price);
				this.money -= cart[i].price;
				System.out.println("���� �� ���� �ܾ� : " + this.money);
				sum += cart[i].price; // �ݾ� ����
			}
		}
		System.out.println("�� �����ݾ�  : " + sum);	
			
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
