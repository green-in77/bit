import java.util.Arrays;

class Person {
	String name;
	int age;
	
}

public class Ex04_Array_Object {

	public static void main(String[] args) {
		int[] intarr = new int[10];
		boolean[] boarr = new boolean[5]; //default false
		System.out.println(Arrays.toString(boarr));
		// 값 타입 배열
		// 값 타입 배열은 각 방이 [기본값]으로 [초기화]된다.
		
		// 참조 타입 배열
		// 참조 타입 기본값 = null
		Person[] pobj = new Person[3]; // 방만 만들겠다.
		// 3명의 사람을 만드는 코드일까.
		System.out.println("pobj : " + pobj);
		System.out.println("new Person[3] : " + pobj[0]); // null 참조타입은 기본값이 null

		//******************클래스(객체) 배열은 방을 만드는 작업과 방을 채우는 작업은 별도.
		// 2번 작업
		
		pobj[0] = new Person();
		pobj[0].name = "홍길동";
		pobj[0].age = 100;
		System.out.println("0번째 주소값 있어요 : " + pobj[0]);
		System.out.println("after : " + pobj[0].name + ", " + pobj[0].age);
		
		pobj[1] = new Person();		
		pobj[2] = new Person();
		
		System.out.println(Arrays.toString(pobj));
		
		//for 문 사용
		for (int i = 0 ; i < pobj.length ; i++) {
			System.out.println(pobj[i].name +" / " +  pobj[i].age);
		}
		
		//객체 배열  Today Point
		// 1. int[] arr = new int[5];
		Person[] parray = new Person[5];
		for (int i = 0 ; i < parray.length ; i++) {
			parray[i] = new Person(); //각방이 memory 를 가졌다.
			System.out.println("주소값 : " + parray[i]);
		}
		
		//2, int[] arr2 = new int[] {10,20,30}
		Person[] parray2 = new Person[] { new Person(), new Person(), new Person()};
		
		//3. int[] arr3 = {10,20,30} // 컴파일러가 알아서 new 생성
		Person[] parray3 = { new Person(), new Person(), new Person() };
		
	
				
	}

}
