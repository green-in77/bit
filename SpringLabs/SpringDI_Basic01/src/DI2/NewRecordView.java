package DI2;

public class NewRecordView {
	//점수 출력하는 클래스
	private NewRecord record;
	
	//1. [생성자]를 통해서 필요한 객체를 생성하거나 주입 >> DI_1
//	public NewRecordView(int kor, int eng, int math) {
//		record = new NewRecord(kor, eng, math);
//	}
	
	//2. 함수([setter])를 통해서 필요한 객체를 주입 >> DI_2
	public void setRecord(NewRecord record) {
		//함수의 parameter로 객체의 주소를 받는다.
		this.record = record;
	}
	
	public void print() {
		System.out.println(record.total() + " / " + record.avg());
	}

}
