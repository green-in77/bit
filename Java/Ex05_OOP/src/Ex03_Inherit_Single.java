// �ΰ��� ���赵
class Tv{
	boolean power; // �⺻�� false
	int ch;
	
	void power() {
		this.power = !this.power; // ����ġ���ó������.(���߿� �ϳ�)
	}
	
	void chUp() {
		this.ch++;
	}
	void chDown() {
		this.ch--;;
	}
}

class Vcr {
	boolean power;
	
	void power() {
		this.power = !this.power;
	}
	
	void play() {
		System.out.println("����ϱ�");
	}
	void stop() {
		System.out.println("�����ϱ�");
	}
	void rew() {	}
	void ff() {}
}

//Tv ���赵, Vcr ���赵 Ȱ���ؼ�
//TvVcr ��� ���赵�� ���弼��.
//������ �ִ� Tv,, Vcr�� ����(Ȱ��) �ϰڴ�.
//Ȱ�� : ���, ����

//class TvVer extends Tv, Vcr (x) {} ���߻�ӱ���
//class Tv extends Vcr
//class TvVcr extends Tv ������ ��ӵ� ����

//���� : ���߿� �ϳ� ���, ������ �Ѱ� ����

// TvVcr : �ֱ��, ���α��, ���� >> ������ ���� Ŭ���� >> ���
//�������� ��������...

//��Ģ : memory �÷���...��밡��.
class TvVcr extends Tv {
	Vcr vcr;
	
	TvVcr () {
		vcr = new Vcr();
	}
	
}


public class Ex03_Inherit_Single {

	public static void main(String[] args) {
		TvVcr t = new TvVcr();
		t.power();
		System.out.println("Tv �������� : " + t.power);
		
		t.chUp();
		System.out.println("Tv ch���� : " + t.ch);
		
		t.vcr.power();
		System.out.println("Vcr �������� : " + t.vcr.power);
		
		t.vcr.play();
		t.vcr.stop();
		t.vcr.power();
		t.power();
		
		System.out.println("Tv �������� : " + t.power);
		System.out.println("Vcr �������� : " + t.vcr.power);
	

	}

}
