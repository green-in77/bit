import kr.or.bit.Bird;

// protected ������ ��Ӱ��� ���
// ������ : ��� ���迡�� ������.... 
// �ǵ� : �����Ǹ� �� �־����� ���ڴ�!!!!!!!!!!!!

// �� �������

class Ostrich extends Bird {
	//��üȭ Ư��ȭ ǥ��
	void run() {
		System.out.println("�޸���");
	}

	@Override
	protected void moveFast() {
		run();
	}	
}

class bi extends Bird {
	@Override
	protected void moveFast() {
		super.moveFast();
	}
}
public class Ex09_Inherit_Protected {

	public static void main(String[] args) {  
		Ostrich o = new Ostrich();
		o.moveFast();
		
		bi b = new bi();
		b.moveFast();

	}

}
