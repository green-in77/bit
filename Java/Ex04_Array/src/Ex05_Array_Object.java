import kr.or.bit.Emp;

public class Ex05_Array_Object {

	public static void main(String[] args) {
		// ��� 3���� ���弼��. (�� �迭�� ����ؼ�)
		
		Emp[] emplist = new Emp[3]; // �游 �����.
		
		emplist[0] = new Emp();
		emplist[0].setEmpno(1000);
		emplist[0].setEname("ȫ�浿");
		
		emplist[1] = new Emp();
		emplist[1].setEmpno(2000);
		emplist[1].setEname("������");
		
		emplist[2] = new Emp();
		emplist[2].setEmpno(3000);
		emplist[2].setEname("������");

		//2. ��� 3���� ����� �̸��� ����ϼ���.
		for (int i = 0; i < emplist.length ; i++ ) {
			emplist[i].empInfoPrint();
		}
		
		//int[] emplist2 = new int[] {10.20.30};
		//��� 2���� ���弼��.
		Emp[] emplist2 = new Emp[] {new Emp(1, "�̾�"), new Emp(2, "�ھ�")};
		for (int i = 0; i < emplist2.length ; i++ ) {
			emplist2[i].empInfoPrint();
		}
		
		//int[] emplist3 = {10,20,30}
		Emp[] emplist3 = {new Emp(1,"�达"), new Emp(2, "ȫ��") };
		for (int i = 0; i < emplist3.length ; i++ ) {
			emplist3[i].empInfoPrint();
		}
		
		// OOP_method overloading
		
		
		
	}
}
