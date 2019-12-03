package Spring_DI4;

import java.util.Scanner;

public class NewRecordView implements RecordView {
	//점수 출력하는 클래스
	private NewRecord record;
	
	//1. [생성자]를 통해서 필요한 객체를 생성하거나 주입 >> DI_1
//	public NewRecordView(int kor, int eng, int math) {
//		record = new NewRecord(kor, eng, math);
//	}
	
	//2. 함수([setter])를 통해서 필요한 객체를 주입 >> DI_2
//	public void setRecord(NewRecord record) {
//		//함수의 parameter로 객체의 주소를 받는다.
//		this.record = record;
//	}
	
	//3. 인터페이스 활용
	public void setRecord(Record record) {//다형성 record 를 구현한 모든 객체의 주소값이 올 수 있음
		//함수의 parameter를 인터페이스로 
		this.record = (NewRecord) record;
	}
	
	@Override
	public void print() {
		System.out.println(record.total() + " / " + record.avg());
	}

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("kor : ");
		record.setKor(sc.nextInt());
		
		System.out.println("eng : ");
		record.setEng(sc.nextInt());
		
		System.out.println("math : ");
		record.setMath(sc.nextInt());
	}

}
