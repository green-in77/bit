/*
 ��ǻ��

���� : ����ȸ��, ��, �޸�

���� :  ������ �ִ�, ������� CPU�� �޸� �� �̿��

��ǰ : �׷���ī��, �����, Ű����, ���콺, ������, ��ü

���
1. ���α׷��� �����Ѵ� / ���α׷��� �����Ѵ�
���α׷��� �����Ѵ�
2. ���α׷��� �����Ѵ� / ���α׷��� �����Ѵ�
3. ����Ϳ� ȭ���� ����Ѵ�
Ű����� �Է��� �޴´�
�����ͷ� ����ϰ� �����
4. ��뷮 ��ȸ�� �� �� �ִ�
*/

package kr.or.bit;

public class Computer {
	public String company; // ����ȸ��
	public String model; //��
	public String memory; //�޸�
	public boolean power; // ����
	
	public int cpu_ues; //cpu �̿��
	public int memort_ues; //�޸� �̿��
	
	public Program pro; //���α׷�
	//public keyboard keyboard; //Ű����
	
	public boolean run_exit(int i) { //true ����,flase ����
		return (i == 1) ? true : false ;
	}
	
	public void word_wirte(String str) { // ���� ����(����)
		Program pro = new Program();
		pro.word = str;
	}
	
	public int use(String str) {
		//��ȸ�� ���� str�� ���ڿ��� �޾Ƽ� (cpu���� memory ����) ��뷮 ��ȸ�ؼ� int ������ ����.
		return 1;
	}
	
	public void output (String str) {
		//����� ���� str�� ���ڿ��� �޾Ƽ� ȭ�鿡 ���(���ϰ�����)
	}
	
	public void del (String str) {
		//������ ���α׷� ���� str�� ���ڿ��� �޾Ƽ� ����.
	}
	
}

//public class keyboard {
	//public int key; //Ű���� Ű�� ����.
//}
