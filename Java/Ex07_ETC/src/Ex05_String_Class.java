// String Ŭ����
// String str = new String("ȫ�浿");
// 8���� ��Ÿ�԰� �����ϰ� ����ص� �������� ����Ǿ�����.
//String str = "ȫ�浿"

//1. String Ŭ���� : ������ ���� ���� >> char[] �迭�� ����
// ex) String ename = "abc"; >> char[] ���� >> [[a][b][c] �� ����
// 2. String str = new String("ABC");
// 3. String str2 = "ABC" ������...
//class String extends Object{
// 		Ŭ���� �߿��� ���� ���� �Լ� ����.... Point!!>>�ڡ��Լ����� : �ϱ��� ���� ����...
//			void length() {
//			}
//			@Override
// 		String toString() { ������ }
//}

public class Ex05_String_Class {

	public static void main(String[] args) {
		String str = "ȫ�浿"; // char�迭�� ���� : [ȫ][��][��]
		System.out.println(str.length()); // 3
		System.out.println(str.toString()); // String Ŭ���� �ȿ� �ڡ�toString Override �Ǿ�����.
		
		String str1 = "AAA"; // str1 = char�迭�� �ּҰ�. heap �� ������.
		String str2 = "AAA";
		// �������̵�� toString �� �⺻���� �پ �ּҰ� �ƴ϶� ���� ����.
		
		//String �� (equals)
		System.out.println(str1 == str2); // true -> String �� ���ڿ��� heap �޸𸮿� ���� ���� ������ ���� �������� �ʰ� �ּҰ�����.
		// == �ּҺ� ( ���� ���� ���� �ƴϰ�, �����ϰ� �ִ� �ּҰ� ���� ��..)
		System.out.println(str1.equals(str2)); // equals ���� heap �� �ִ� ���� ��. AAA == AAA
		
		/*String str = "A";
		str += "B";
		str += "C";
		str += "D";
		str += "F";
		str = "B";
		str = "A"; */
		// heap �� char[1] [A] ���� ���� -> char[2] [A][B] -> char[3] [A][B][C] -> char[4] [A][B][C][D] -> char[5] [A][B][C][D][F]
		// -> B�� ������ heap �޸𸮿� �ٽ� char[1][B] �� ���� ����. -> A�� ������ heap �޸𸮿� �ִ� A�� ��Ȱ��.
		//String �� �����迭�� �ƴ϶�. ���ڰ� �����Ǹ� ���� �迭�� ����. str�� ���� �ּҰ��� ��� �ٲ�.
		
		String str3 = new String("BBB"); // new -> str3 (xx����)
		String str4 = new String("BBB"); // new ->  str4(yy����)
		System.out.println(str3); // BBB
		System.out.println(str4.toString()); //BBB
		System.out.println(str3 == str4); // �ּ� ��, new �� ��ü�� ���� �����߱� ������ �ּҰ��� �ٸ�. false 
		System.out.println(str3.equals(str4)); // BBB == BBB -> True
		
	}

}
