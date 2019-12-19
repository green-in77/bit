// String 클래스
// String str = new String("홍길동");
// 8가지 값타입과 동일하게 사용해도 문제없게 설계되어있음.
//String str = "홍길동"

//1. String 클래스 : 데이터 저장 구조 >> char[] 배열로 저장
// ex) String ename = "abc"; >> char[] 생성 >> [[a][b][c] 로 저장
// 2. String str = new String("ABC");
// 3. String str2 = "ABC" 차이점...
//class String extends Object{
// 		클래스 중에서 제일 많은 함수 보유.... Point!!>>★★함수공부 : 암기할 것이 많음...
//			void length() {
//			}
//			@Override
// 		String toString() { 재정의 }
//}

public class Ex05_String_Class {

	public static void main(String[] args) {
		String str = "홍길동"; // char배열로 저장 : [홍][길][동]
		System.out.println(str.length()); // 3
		System.out.println(str.toString()); // String 클래스 안에 ★★toString Override 되어있음.
		
		String str1 = "AAA"; // str1 = char배열의 주소값. heap 에 생성됨.
		String str2 = "AAA";
		// 오버라이드된 toString 이 기본으로 붙어서 주소가 아니라 값이 나옴.
		
		//String 비교 (equals)
		System.out.println(str1 == str2); // true -> String 은 문자열이 heap 메모리에 같은 값이 있으면 새로 생성하지 않고 주소공유함.
		// == 주소비교 ( 값이 같은 것이 아니고, 참조하고 있는 주소가 같은 것..)
		System.out.println(str1.equals(str2)); // equals 실제 heap 에 있는 값을 비교. AAA == AAA
		
		/*String str = "A";
		str += "B";
		str += "C";
		str += "D";
		str += "F";
		str = "B";
		str = "A"; */
		// heap 에 char[1] [A] 생성 이후 -> char[2] [A][B] -> char[3] [A][B][C] -> char[4] [A][B][C][D] -> char[5] [A][B][C][D][F]
		// -> B로 덮으면 heap 메모리에 다시 char[1][B] 를 새로 만듬. -> A로 덮으면 heap 메모리에 있는 A를 재활용.
		//String 은 동적배열이 아니라. 문자가 누적되면 새로 배열을 만듬. str의 참조 주소값이 계속 바뀜.
		
		String str3 = new String("BBB"); // new -> str3 (xx번지)
		String str4 = new String("BBB"); // new ->  str4(yy번지)
		System.out.println(str3); // BBB
		System.out.println(str4.toString()); //BBB
		System.out.println(str3 == str4); // 주소 비교, new 로 객체를 새로 생성했기 때문에 주소값이 다름. false 
		System.out.println(str3.equals(str4)); // BBB == BBB -> True
		
	}

}
