package kr.or.bit;
/*
 ��ȭ���� �귣��� ���� ������ �ִ�.

��ȭ���� ������ �귣���� ���� �����ؾ��Ѵ�.(�� �������� �Ѱ��� �귣�常 �����Ѵ�.)

���� �Է��ϸ� �� ���� ��ġ�� �귣�带 �� �� �ִ�.

 (1�� - ���� / 2�� - �����̽� / 3�� - �Ƶ�ٽ�)

��ȭ���� �̸��� ���� �ѹ��� Ȯ���� �� �ִ�.

������ �Է��ϱ� ���� ����ڿ��� �� ���� �Է¹����� ������ ���ش�.

���� ���� ���̳� �߸��� ���� �Է����� �� �� ���� �ٽ� �����.
*/
public class Department_4 {
	private String brandname; // �귣���
	private int floor; // ��
	
	public Department_4 (String brandname, int floor) { // �����ε� ������ : �귣���� ���� �ִ�.
		this.brandname = brandname; 
		this.floor = floor;
	}	
	public void Dep_print() { // �̸��� ���� �ѹ��� Ȯ���� �� �ִ�.
		System.out.println(this.floor + "�� - " + this.brandname);
	}
}
