// ����
// 1. ����(error) : �����ڰ� �ڵ������� �ذ��� �� ���� ����. (ex. ��Ʈ��ũ ���, �޸�, �ϵ���� �̻� ��)
// 2. ����(Exception) : �������� �ڵ�ó������ ( �������� ��...) > ���������ϴ�.
//			���� �߻� �� ���α׷��� ���������.
// ����ó�� ���� : ���α׷��� ���������� �����ϴ� ���� �ƴϰ� ���� �߻� �� ������ ���Ḧ ���� ��.
// ���� ���ܰ� �߻��ߴ� : �ڵ���� �ؾ���..
/*
 try{
 	������ �� �� �ִ� �ڵ�
 }catch(Exception e) { // e ��� parameter �� ���� ������ ��ü�� ����...
 	ó���ϴ� �ڵ�.(������ �߻� & ������ ���� ����.)
 	.. �����ڿ��� ����.... or ..log ���� .... // ó���ڵ� ��� ������ ������ �ؾ��Ѵ�!!!!!!!!!
 }finally{
 	������ �߻��ϴ�, �����ʴ� ���������� �����ؾ��ϴ� ����.
 	DB ���� �ݱ�...
 	�ڡڡڡڡڡڰ������� �Լ����� (return) �� �ϴ��� finally �� �����.�ڡڡڡڡڡ�
 }
 
 */


public class Ex01_Exception {

	public static void main(String[] args) {
		 System.out.println("Main Start");
		 	System.out.println("Main Logic ó��");
		 	try { // �������Ḹ ���� ��, ������ �ذ���� ����.
		 		
		 		System.out.println(0/0); // java �� 0���� ������ �ڵ� ����. >> �� �ڵ�� �����ڰ� ���������� �����ؾ� �Ѵ�.
		 		//Exception in thread "main" java.lang.ArithmeticException: / by zero
		 		//�ڹٴ� ��Ÿ��(����) �� ����(Exception)�� �߻��ϸ� ������ �ش��ϴ� ���� Ŭ������ �ڵ������Ѵ�. >> java.lang.ArithmeticException
		 		
		 	} catch(Exception e) {
		 		System.out.println(e.getMessage());
		 	}
		 
		 System.out.println("Main End");
	}

}
