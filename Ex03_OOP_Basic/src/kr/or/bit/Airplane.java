package kr.or.bit;
/*
 �츮 ȸ��� ����⸦ �ֹ� ���� �Ǹ��ϴ� ȸ���Դϴ�.
 �츮 ȸ��� ����⸦ �����ϴ� ���赵�� �ۼ��Ϸ��� �մϴ�.
 �䱸����
 1. ����⸦ �����ϰ� ������� �̸��� ��ȣ�� �ο��ؾ� �մϴ�.
 2. ����Ⱑ ����Ǹ� ������� �̸��� ��ȣ �°� �ο��Ǿ����� Ȯ���ϴ� �۾��� �ʿ��մϴ�. (������� Ȯ��)
 3. �������� ������� ������� ������� �Ѵ��(����)�� Ȯ���� �� �ֽ��ϴ�. -> ��ü�� �����ڿ�
 
 �� ���� ��� �ڵ�� ���赵 ����ð�.. ����� 3�� ��������Ȯ���ϰ� ������� Ȯ��...
 
 ����) ������ ������....
 
 �� �ڵ�� ����� 50��.... why? ������, this �� �ȹ����.... �̰��� ����ؾ� 100��¥�� �ڵ带 ���� �� ����.
 ������� ��� �������� ���� �� �ִ� �ڵ�.
 */
/*
public class Airplane { // ĸ��ȭ : ����� private�� �����ϰ� �Լ��� �����ؼ� �а� �� �� �ְ��ϱ�!!
	private String airName; // ������� �̸�
	private  int airNum; // ������� ��ȣ
	
	private static int sum; // ������� ������� - ��ü���� ���µǴ� �ڿ�(��ü�� �����ڿ�) // ���ο��� Ŭ���� �̸����� ���� �Ұ�.
		
	public void makeAir(int num, String name) { // private �� Ȱ���ϱ� ���� �Լ� ����.
		airName = name;
		airNum = num;
		sum++;
		System.out.printf("�̸� : %s, ��ȣ %d\n",airName, airNum);
	}
	
	public void airsumprint() { // static �� �ص� ������ �䱸���׿� ���� ���⶧����.
		System.out.printf("������� : %d\n\n " , sum);
	}
}
*/

public class Airplane {
	private String airName; // ������� �̸�
	private int airNum; // ������� ��ȣ
	
	private static int airsum; //������� �������
	
	public Airplane (String airName, int airNum){
		this.airName = airName;
		this.airNum = airNum;
		airsum++;
	}
	
	public void air_print() {
		System.out.println("������� �̸��� ��ȣ : " + airName + " / " + airNum);
	}
	
	public void airsum_print() {
		System.out.println("������� : " + airsum);
	}
	
}