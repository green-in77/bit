import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 Map �������̽�
 Map > (Ű, ��)���� ������ ���� �迭
 ex) ������ȣ : (02, ����)
 key : �ߺ��Ұ� /  value : �ߺ�����
 
 Generic ���� ����
 
 HashTable (������) - ����ȭ ����O
 HashMap (�Ź���) - ����ȭ ����X : ���ɰ��
 ����� ����ȭ ��� X : Thread  ���� ������.... >> ���� >> ����ȭ �ǹ� X (��������)
 
 */

public class Ex11_Map_Interface {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		
		// ID, PW ������ Ȱ�� ( ID �� �ߺ��� ����, PW�� �ߺ��� ����)
		map.put("Tiger", "1004");
		map.put("scott","1004");
		map.put("superman", "1007");
		
		// Collection ������ ���� �� �ִ�. > ���α׷��� ���۵Ǵ� ���ȸ�....
		// �ֹ߼� �޸� >> ���α׷����� >> ������ ����(���ϱ��) >> ���.txt, ȸ��.txt
		// ���� ������ �ٷ�� ����� >> RDBMS( ������ �����ͺ��̽�)
		
		// containsKey -> key �� ���Կ��� / �ִ�??? 
		// containsValue -> Value �� ���Կ���
		System.out.println(map.containsKey("tiger")); //  false >> �ڹٴ� ��ҹ��ڸ� ������.
		System.out.println(map.containsKey("scott")); // true
		System.out.println(map.containsValue("1004")); //ture
		
		//(key, value)
		//key ���� ������ value ���� ����
		// map.get -> Ű���� value �� ��ȯ
		System.out.println(map.get("Tiger")); //1004
		System.out.println(map.get("hong")); // null // �ش�Ǵ� Key �� ������ value >> null
		
		//put
		map.put("Tiger", 1008); // Key �� ���� ��쿡�� value ���� ��������.(overwrite) >> "1004" -> 1008
		System.out.println(map.get("Tiger")); //1008
		
		//remove - 
		Object returnvalue = map.remove("superman"); // Ű+�� ����.
		System.out.println(returnvalue); // ������ Ű�� value return
		System.out.println("size : " + map.size());
		System.out.println(map);
		
		// keySet -> key ���� �̾Ƽ� set Ÿ������ ����.
		Set set = map.keySet(); // Set ������ HashSet ... ���� data �� �ְ� �� �ּҸ� return
		//key �� �ߺ�X, ����X �������� ����
		
		Iterator it = set.iterator();
		while ( it.hasNext()) {
			System.out.println("key : " + it.next());
		}
		
		// values -> Ű ���� �̾Ƽ� List Ÿ������ ����
		// values �� �ߺ�O
		Collection list = map.values();
		System.out.println(list);
		
		Iterator it2 = list.iterator();
		while ( it2.hasNext()) {
			System.out.println("Value : "+it2.next());
		}
		
		
	}
}
