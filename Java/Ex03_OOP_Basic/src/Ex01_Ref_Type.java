import kr.or.bit.BodyInformation;
import kr.or.bit.Emp;
import kr.or.bit.Person;
import kr.or.bit.Tv;

public class Ex01_Ref_Type {

	public static void main(String[] args) {
		
		Person person; //선언만 // 클래스 타입은 기본 4byte 할당. = 값은 없음 = Null >> stack 이라는 메모리영역에 변수가 만들어지고 Null 값 할당. //지역변수
		person = null; // 초기화
		System.out.println("person : "+person); // 지역변수는 초기화 없이는 사용할 수 없음.
		
		person = new Person(); // Person 객체의 주소값 할당 / 참조타입
											// person 타입은 메모리를 갖는다.
		
		System.out.println("Ref person : " + person); //kr.or.bit.Person@15db9742
		
		person.name = "홍길동";
		person.age = 10;
		
		person.print();
		
		// 선언과 할당을 동시에
		
		Person myperson = new Person(); // new = 객체를 만드는 연산자. ( +, - 같은 연산자의 종류)
		myperson.name = "아무개";
		myperson.age = 100;
		
		myperson.print(); // myperson 에 함수 print 를 호출.
		
		int num = 100; // local variable (반드시 초기화(= 처음 값을 넣는 행위))
		
		Person you; // 지역변수 / Person = Type  초기화가 되어있지 않음. 사용불가.
		//System.out.println(you); 
		//The local variable you may not have been initialized
		
		//1. you 라는 변수의 초기화 ( 값을... 인위적으로 null 할당가능 , 일반적으로 주소값을 갖는 행위를 초기화라고 한다.)
		
		you = new Person(); // 주소값으로 초기화 하는 것이 일반적인 방법.
		
		Person my;
		my=you; // 초기화 하였습니다. you 가 갖고있는 주소값으로. //my 와 you 는 동거를 시작....같은 집의 주소를 가지고 있으니까...
		
		System.out.println( my == you ); //true
		System.out.println(my + " : " + you );
		
		// 프로그램이 종료되면 할당된 메모리가 전부 삭제됨. (메모리가 삭제되지 않게 하려면 do~while 로 메인함수가 계속 실행되고 있어야함.
		
		System.out.println();
		// Tv 2대 만들기
		
		Tv tv1 = new Tv();
		tv1.brand = "삼성";
		tv1.ch = 40;
		System.out.println("tv1의 브랜드 : " + tv1.brand);
		System.out.println("tv1의 현재채널 : " + tv1.ch);
	
		/*
		String sign = "+";
		tv1.ch_change(sign);
		System.out.println("tv1의 변경 후 채널 :"+ tv1.ch);
		*/
		
		tv1.ch_plus();
		System.out.println("tv1의 변경(ch_plus) 후 채널 :"+ tv1.ch);
		
		tv1.ch_minus();
		System.out.println("tv1의 변경(ch_minus) 후 채널 :"+ tv1.ch);
		
		
		System.out.println();
		
		Tv tv2 = new Tv();
		tv2.brand = "엘지";
		tv2.ch = 20;
		System.out.println("tv2의 브랜드 : "+tv2.brand);
		System.out.println("tv2의 현재 채널 : " + tv2.ch);
		
		/*
		sign = "-";
		tv2.ch_change(sign);
		System.out.println("tv2의 변경 후 채널 : " + tv2.ch);
		 */
		
		tv2.ch_minus();
		System.out.println("tv2의 변경(ch_minus) 후 채널 : " + tv2.ch);
		
		tv2.ch_plus();
		System.out.println("tv2의 변경(ch_plus) 후 채널 : " + tv2.ch);
		
		Emp emp = new Emp();
		BodyInformation bodyinfo = new BodyInformation();
		
		emp.empno = 7788;
		emp.ename = "김유신";
		emp.jobs = "IT";
		emp.sal = 5000;
		emp.bodyinfo = bodyinfo;
		emp.bodyinfo.height = 180;
		emp.bodyinfo.weight = 60;
		
		System.out.println("emp.bodyinfo = "+ emp.bodyinfo.height + " /  "+emp.bodyinfo.weight);
				
		bodyinfo.height = 170;
		bodyinfo.weight = 60;
		
		System.out.println("bodyinfo = "+ bodyinfo.height + " /  "+bodyinfo.weight);
		
	}
}
