/*
 �ó�����(�䱸����)
 ����� ������ǰ ���� �ַ���� �����ϴ� ������Դϴ�.
 A��� ������ǰ ������ ���µǸ�
 [Ŭ���̾�Ʈ �䱸����]
 ������ǰ�� ��ǰ�� ����, ��ǰ�� ����Ʈ ������ ���������� ������ �ֽ��ϴ�.
 ������ ������ǰ�� ��ǰ�� ������ �̸��� ������ �ִ�.
 
 Ex)
 ������ ������ǰ�� �̸��� ������ �ִ� (tc, audio, computer)
 ������ ������ǰ�� �ٸ� ������ ������ �ִ�.(tv 5000 audio 6000)
 ��ǰ�� ����Ʈ�� ������ 10% �����Ѵ�.
 
 �ùķ��̼� �ó�����
 ������ : ��ǰ�� �����ϱ� ���� �ݾ�����, ����Ʈ������ ������ �ִ�.
 ������� : 10����, ����Ʈ 0
 �����ڴ� ��ǰ�� ������ �� �ִ�, ���������� �ϰԵǸ� ������ �ִ� ���� �����ϰ� ����Ʈ�� �ö󰣴�.
 �����ڴ� ó�� �ʱ�ݾ��� ���� �� �ִ�.
 
 */
class Buyer{
	static int money;
	static int point;
	
	Buyer () {
		this.money = 10000;
	}
	
	//�������� == �����Լ�
	//�������� >> �ܾ� - ��ǰ����, point ���� ����
	// �����ڴ� ���忡 �ִ� ��� ��ǰ�� ������ �� �ִ�.
	/*
	1�� �ڵ� ���� ... 
	void kttvBuy(KtTv n) {  //�Լ��� ��ǰ��ü�� parameter �޾ƾ�  POINT
    	if(this.money < n.price) {
    		System.out.println("���� �ܾ��� �����մϴ�^^! " + this.money);
    		return; //�Լ� ���� (�������� ���� ����)
    	}
    	//�� ���� ����
    	this.money -= n.price; //�ܾ�
    	this.bonuspoint += n.bonuspoint; //����  +=
    	System.out.println("������ ������ : " + n.toString());
    }
    
	void audioBuy(Audio n) { //�Լ��� ��ǰ��ü�� parameter �޾ƾ�  POINT
    	if(this.money < n.price) {
    		System.out.println("���� �ܾ��� �����մϴ�^^! " + this.money);
    		return; //�Լ� ���� (�������� ���� ����)
    	}
    	//�� ���� ����
    	this.money -= n.price; //�ܾ�
    	this.bonuspoint += n.bonuspoint; //����  +=
    	System.out.println("������ ������ : " + n.toString());
		
	}
    
	void notebookBuy(NoteBook n) { //�Լ��� ��ǰ��ü�� parameter �޾ƾ�  POINT
    	if(this.money < n.price) {
    		System.out.println("���� �ܾ��� �����մϴ�^^! " + this.money);
    		return; //�Լ� ���� (�������� ���� ����)
    	}
    	//�� ���� ����
    	this.money -= n.price; //�ܾ�
    	this.bonuspoint += n.bonuspoint; //����  +=
    	System.out.println("������ ������ : " + n.toString());
		
	}
	*/
	
	
	//2�� ���� �ڵ� (�����丵)
	//[�ϳ��� �̸�]���� �������� ���(parameter Ÿ�� �� ������ �޸�)
	//method overloading
	/*
	void Buy(KtTv n) {  //�Լ��� ��ǰ��ü�� parameter �޾ƾ�  POINT
    	if(this.money < n.price) {
    		System.out.println("���� �ܾ��� �����մϴ�^^! " + this.money);
    		return; //�Լ� ���� (�������� ���� ����)
    	}
    	//�� ���� ����
    	this.money -= n.price; //�ܾ�
    	this.bonuspoint += n.bonuspoint; //����  +=
    	System.out.println("������ ������ : " + n.toString());
    }
    
	void Buy(Audio n) { //�Լ��� ��ǰ��ü�� parameter �޾ƾ�  POINT
    	if(this.money < n.price) {
    		System.out.println("���� �ܾ��� �����մϴ�^^! " + this.money);
    		return; //�Լ� ���� (�������� ���� ����)
    	}
    	//�� ���� ����
    	this.money -= n.price; //�ܾ�
    	this.bonuspoint += n.bonuspoint; //����  +=
    	System.out.println("������ ������ : " + n.toString());
		
	}
    
	void Buy(NoteBook n) { //�Լ��� ��ǰ��ü�� parameter �޾ƾ�  POINT
    	if(this.money < n.price) {
    		System.out.println("���� �ܾ��� �����մϴ�^^! " + this.money);
    		return; //�Լ� ���� (�������� ���� ����)
    	}
    	//�� ���� ����
    	this.money -= n.price; //�ܾ�
    	this.bonuspoint += n.bonuspoint; //����  +=
    	System.out.println("������ ������ : " + n.toString());
		
	}
	*/
	
	
	//3�� ���� ( �ߺ� �ڵ� ����)
	//��ǰ�� ��������� �߰��Ǵ��� �������� ����� �߰������� ������ �ʴ´�.
	//why : ��ſ� �ް��� ������ �Ǵϱ�...
	//�ϳ��� �̸�����, �ݺ��ڵ� ����...
	//KEY POINT : ��� ��ǰ�� Product ����ϰ� �ִ�.
	//��� ��ǰ�� �θ�� Product
	//�� �θ�� �ڽ��� �͸� ���� ����.
	void E_Buy(Product n) { // �Լ��� ��ǰ��ü�� parameter�� �޾ƾ� ��. // �θ�� �ڽ��� �ּҸ� ���� �� �ִ�.
		if(this.money < n.price ) {
			System.out.println("�ܾ��� �����մϴ�. " + this.money);
			return; // �Լ����� // ���������� �� �� ���� ����.
		}
		else {
			this.money -= n.price;
			this.point += n.point;
			System.out.println("������ ������ : " + n.toString()+ " �Դϴ�.");
			System.out.println("�ܾ� : " + this.money);
			System.out.println("����Ʈ : " + this.point);
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
		//1�� ���� �׽�Ʈ
		//��������
		bu.E_Buy(tv);
		bu.E_Buy(au);
		bu.E_Buy(note);
		
	}
}
