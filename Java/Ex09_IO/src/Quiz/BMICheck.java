package Quiz;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class BMICheck {
	static HashMap<Integer, BMI> map = new HashMap<Integer, BMI>(); // hashmap 객체생성
	// map 은 순서가 없고 키(중복불가)와 값(중복가능)이 짝으로 되어있음.
	
	static int count = 1;
	static Scanner scan = new Scanner(System.in);
	

	public static void main(String[] args) {
		BMICheck bc = new BMICheck(); // BMICheck 객체 생성
		while(true){
		System.out.println("비만도 측정합니다!!!!");
		System.out.print("<1>추가 <2>삭제 <3>출력 <4>저장 <5>로드 <6>종료 : ");

		switch (scan.nextInt()) {
		case 1:
			bc.add(); // map 객체에 BMI 추가하는 함수
			break;
		case 2:
			bc.delete(); // map 객체에 저장된 값 삭제
			break;
		case 3:
			bc.print(); // 콘솔출력
			break;
		case 4 :
			bc.save(); // map 객체를 직렬화해서 파일로 저장
			break;
		case 5:
			bc.load(); // 직렬화해서 저장했던 map 객체를 역직렬화해서 읽어오기!
			break;
		case 6:
			bc.exit(); // 시스템종료
			break;

		}// switch
		}//while
	}// main

	private void save() { // 메모리에 저장된 데이터를 파일로 저장하는 함수
		File file = new File("bmi.txt"); // 파일을 만들꺼다!!!
		try{
			FileOutputStream fos = new FileOutputStream(file); // 파일로 내보내는 1byte 짜리 객체.
			ObjectOutputStream oos = new ObjectOutputStream(fos); // 객체를 직렬화해서 파일에 내보낼 보조.
			
			oos.writeObject(map); // map 객체를 직렬화해서 쓰기..
			
			oos.close(); // 다 썼으니까 닫아주고...
			fos.close();
		}catch(Exception e){ // 예외발생시..
			System.out.println("에러발생!!!");
			e.printStackTrace();
		}
		System.out.println("저장되었습니다.");
	}

	private void exit() { // 시스템 종료 함수
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
		scan.close(); // 스캐너도 다썼으면 닫아주기!
	}

	private void print() { // 콘솔에 출력해주는 함수
		Set<Integer> set = map.keySet(); // map 에 저장된 ket 값을 set 으로 만들어서 return
		System.out.println("번호\t키\t몸무게\t결과\t판정");
		for (Integer number : set) { //map 에 저장됐던 key값의 숫자만큼..
			double length = map.get(number).getLength(); // number 에 키값이 저장되어있으니까... 그걸 기준으로map 에 찾아가서 키,몸무게,BMI 값, BMI 결과 가져오기
			double weight = map.get(number).getWeight();
			double result = map.get(number).getResult();
			String you = map.get(number).getYou();

			System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%s\n", number, length, weight, result, you); // 출력
		}
	}

	private void delete() { // 데이터를 삭제하는 함수
		System.out.print("삭제하실 넘버를 입력해 주세요 : ");
		int num = scan.nextInt();
		if (map.containsKey(num)) { //map 에 저장된 count (키) 값을 기준으로 입력받은 번호가 포함된 데이터가 있으면
			map.remove(num); // 키값에서 해당 번호를 찾아서 데이터 삭제.
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("고객넘버를 잘못입력하셨습니다. 해당 정보가 없습니다.");
		}
	}

	private void add() {
		BMI bmi = new BMI(); //BMI 객체 생성
		map.put(count, bmi.input(bmi));
		// bmi 클래스의 input 함수 호출 : 키,몸무게,BMI 수치, BMI 결과값 이 저장된 bmi 객체의 주소값 return
		//map 에 1을 키값으로 함수에서 리턴된 bmi 객체의 주소값을 저장.
		count++;
	}
	
	private void load() {
		File file = new File("bmi.txt"); //읽을 파일
		try{
			FileInputStream fis = new FileInputStream(file); //파일을 읽을 수 있는 1byte 짜리
			ObjectInputStream oos = new ObjectInputStream(fis); // 역직렬화 해서 읽어야지!
			
			map = (HashMap)oos.readObject(); // 역직렬화해서 오브젝트타입으로 오기때문에 hashmap 으로 다운캐스팅해서 저장
			
			Set<Integer> set = map.keySet(); // map 에 저장된 key 값을 set 으로 저장해서 return
			System.out.println("번호\t키\t몸무게\t결과\t판정");
			for (Integer number : set) { // 저장된 set 값으로 map 출력
				double length = map.get(number).getLength();
				double weight = map.get(number).getWeight();
				double result = map.get(number).getResult();
				String you = map.get(number).getYou();

				System.out.printf("[%s]\t%.2f\t%.2f\t%.2f\t%s\n", number, length, weight, result, you);
			}
			oos.close(); // 썼으면 닫아야지.
			fis.close();
			
		}catch(Exception e){ // 에러가 난다면....
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		}
	}
}// class
