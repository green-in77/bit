package kr.or.bit;

/* 
 **************class�� ���赵 �̴�.**************
 *���赵 �⺻���� �������(��������(�Ӽ�): ���� + ��������(���): �Լ�*
 *
 *�ڵ��� ���赵 >>
 *��������(�Ӽ�): ����, ��̷�, â��, ����, �ӵ� >> ���� >>  int speed=0;
 *��������(���): ����, �극��ũ, �ӵ��� ���δ�. >> �Լ� >> public void speedUp(){++speed}
 *�Ѱ��� ǥ���Ҽ����ٸ� �ѹ� �� �ɰ���.
 *���� ���赵:��Ϲ���, ����, �⸧
*/
public class Emp { // ����̶�� ���赵
	public int empNo; //����� ����� ������ �ִ� (��� ���� ������(��������)) -> member field
								// -> instance variable
	public String eName;
	public String eJob;
	public int eData;
	
	public int getData() {
		return eData;
	}
	/*
	 * ĸ��ȭ: �����Ҵ��� ���� �����Ҵ��� ����Ѵ�.
	 */
	public void setData(int data) {//ĸ��ȭ�� �ڿ��� ���� set, get >> setter�Լ�, getter�Լ�
		if(data < 100) {
			this.eData=data;
		} else
			this.eData=0;
	}
	/*
	 * ��������(���): �Լ�(method)
	 * �Լ��� �ݵ�� ȣ�� ����
	 */
	public String getEmpInfo() {
		return empNo + "/" + eName + "/" + eJob;
	}
}
