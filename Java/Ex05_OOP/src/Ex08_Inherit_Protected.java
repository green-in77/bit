import kr.or.bit.Pclass;

/*
public , default , private , protected ����
��Ӱ��迡�� protected
��鼺 : ���� ( default , public )
���� : ����� ���� Ŭ���� �ȿ��� protected �����ڴ� default �� ����.
why) ����� ���� ��Ȳ������ protected �����ڴ� �ǹ̰� ����.
  
  
 */

class Dclass {
	private int i;
	public int j;
	protected int k; // ��Ӿ��� Ŭ���� �ȿ����� default �� ���⶧���� �̷��� ������� ����.
	// ��Ӱ��谡 �ƴϸ� protected �� ���� �ʴ´�...
	int p;
}


class Child2 extends Pclass { 
	void method() {
		this.k = 1000; //protected ��� ���迡���� public �� ���� ����(���� ����)
	}
}


public class Ex08_Inherit_Protected {

	public static void main(String[] args) {
		Pclass p = new Pclass();
		Child2 c = new Child2();
		//c.k �� �Ⱥ���(���ٺҰ�) // protected ( default �� ���� ����)
		c.method();
		
		Dclass d = new Dclass();
		d.j=1;  // public 
		d.p=2; //default
		d.k = 3; // protected ( ���� ��Ű�� �ȿ����� default )
		
		
	

	}

}
