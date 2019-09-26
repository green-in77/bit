import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Today Point
//HashMap Generic  ���
// HashMap <K,V>
// HashMap < String, String >
// HashMap < String, Integer >
// HashMap < String, Emp> // value ������ Emp Ÿ���� �ּҰ�....
// map.put("hong",new Emp());�ڡڡڡڡڡڡڡڡڡڡڡ�

// HashMap < String, ArrayList<Emp>> //��� ��ŵ... 

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
		sts.put("hong", new Student("ȫ�浿"));
		sts.put("kim", new Student("������"));
		
		Student std = sts.get("hong");
		System.out.println(std.eng+"/" +std.math+"/"+std.kor);
		
		//TIP ����������....
		//Map �ȿ� �ִ� Key, Value ��� ���.
		Set set = sts.entrySet(); // key+"="+value // hong=Student@15db9742 , kim=Student@6d06d69c
		Iterator it = set.iterator();
		while ( it.hasNext()) {
			System.out.println(it.next());
		}
		
		// value�� object �϶���....(�ּҰ� ���� ���� ����ϰ����....) //����...
		//Map.Entry : getKey(), getValue() ....
		for (Map.Entry m : sts.entrySet()) {
			System.out.println(m.getKey());
			System.out.println(((Student)m.getValue()).name); // ����Ÿ���̱� ������ Student �� �ٿ�ĳ���� ...
		}

				

	}
}
