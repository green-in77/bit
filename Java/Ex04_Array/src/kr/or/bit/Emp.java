package kr.or.bit;

// ���赵 >> new �Ѵٸ� �����͸� ��� ���� ( dto , vo , domain )

public class Emp {
	private int empno;
	private String ename;
	
	public Emp() { // ������(default constructor) // member field �ʱ�ȭ
		
	}
	
	public Emp(int empno, String ename) { // overloading constructor //����
		this.empno = empno;
		this.ename = ename;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	
	// �ʿ��ϴٸ� setter , getter �ڵ�����

	//���(�������)
	public void empInfoPrint() {
		System.out.println(this.empno + " / " + this.ename);
	}

}
