package kr.or.bit;
/*
 Tv ���赵
 �䱸���� ����
 Tv �� ä�������� ������ �ִ�.(���� ��� 1��~200������)
 Tv �� �귣�� �̸��� ������ �ִ�. ( ���� ��� �Ｚ, ����)
 
 Tv�� ä���� ��ȯ ����� ������ �ִ�. (ä���� �� ä�ξ� �̵� �����ϴ�. + - )
  - > ä���� ������Ű�� ����� ������ �ִ�.
  - > ä���� ���ҽ�Ű�� ����� ������ �ִ�.
  
 Ex01_Ref_Type �� main �Լ� �ȿ��� Tv 2�� ������ ����.
 */
public class Tv {
	public int ch;
	public String brand;
	
/*	public void ch_change (String sign) {
		if(sign == "+") {
			ch++;
		} if(sign == "-") {
			ch--;
		} 
	}
*/
	
	public void ch_plus () {
		ch++;
	}
	public void ch_minus () {
		ch--;
	}
}
