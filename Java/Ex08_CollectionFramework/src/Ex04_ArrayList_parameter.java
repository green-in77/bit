import java.util.ArrayList;

class Empdata{
	private ArrayList elist;
	private int[] numbers;
	private String name;
	
	Empdata() {
		this.elist = new ArrayList();
		this.numbers = new int[10];
		this.name = "¾Æ¹«°³";
	}
	// elist getter :getElist()
	// elist setter : setElist()
	
	void setName(String name) {
		this.name = name;
	}
		String getName() {
		return this.name;
	}
	void setElist(ArrayList elist) {
		this.elist = elist;
	}
	ArrayList getElist() {
		return this.elist;
	}
	
	int[] getNumbers() {
		return this.numbers;
	}
	
	void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
}

public class Ex04_ArrayList_parameter {
	public static void main(String[] args) {
		Empdata edata = new Empdata();
		System.out.println(edata);
		System.out.println("size(x) : " + edata.getElist());
		
		ArrayList li = new ArrayList();
		li.add(100);
		li.add(200);
		
		edata.setElist(li);
		System.out.println(edata.getElist());

	}

}
