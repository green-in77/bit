import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Today Point
//HashMap Generic  사용
// HashMap <K,V>
// HashMap < String, String >
// HashMap < String, Integer >
// HashMap < String, Emp> // value 값으로 Emp 타입의 주소값....
// map.put("hong",new Emp());★★★★★★★★★★★★

// HashMap < String, ArrayList<Emp>> //잠시 스킵... 

class Student {
	int kor = 100;
	int math = 80;
	int eng = 20;
	String name;
	Student (String name) {
		this.name = name;
	}	
}
public class Ex13_HashMap_Generic {
	public static void main(String[] args) {
		HashMap<String, Student> sts = new HashMap<String, Student>();
		sts.put("hong", new Student("홍길동"));
		sts.put("kim", new Student("김유신"));
		
		Student std = sts.get("hong");
		System.out.println(std.eng+"/" +std.math+"/"+std.kor);
		
		//TIP 예외적으로....
		//Map 안에 있는 Key, Value 모두 출력.
		Set set = sts.entrySet(); // key+"="+value // hong=Student@15db9742 , kim=Student@6d06d69c
		Iterator it = set.iterator();
		while ( it.hasNext()) {
			System.out.println(it.next());
		}
		
		// value가 object 일때는....(주소값 말고 값을 출력하고싶음....) //참고...
		//Map.Entry : getKey(), getValue() ....
		for (Map.Entry m : sts.entrySet()) {
			System.out.println(m.getKey());
			System.out.println(((Student)m.getValue()).name); // 상위타입이기 때문에 Student 로 다운캐스팅 ...
		}

				

	}
}
