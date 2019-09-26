package kr.or.bit;
import kr.or.bit.Car_Mark;
/*
비트자동차를 보관하는 창고이다.		
		
비트자동차는 차종(smart, web, java)과 가격과 마크를 가지고 있다.		
	마크는 차종별로 구분되어있다.	
	1. smart	△
	2. web	▽
	3. java	□
		
자동차가 입고될 때 반드시 차종과 가격을 입력해야 한다.		
	입력한 차종이 맞지 않을 시 입력한 차종명을 보여주고 잘못 입력했음을 알려주고 프로그램이 종료된다.	
		
자동차의 차종과 가격은 특정 기능을 통해서만 볼 수 있고, 입고된 이후 수정할 수 없다.		
	조회 실행 시 차종마크가 별5줄로 출력되고 그 아래에 차종과 마크와 가격이 출력되어야한다.	
	1. smart	△
	2. web	▽
	3. java	□
		
차종의 이름과 가격은 각각 확인할 수 있다.		
누적대수(총,차종별) 를 확인하는 기능이 있다.		
 */

public class Ex_Bitcar {
	
	private String cname; // 차종정보
	private int cprice; // 가격
	private Car_Mark Mark; //마크
	private static int carsum; // 총 누적대수
	private static int ssum; // smart 누적대수
	private static int wsum; // wsum 누적대수
	private static int jsum; //jsum 누적대수
	
	public Ex_Bitcar(String cname, int cprice) { // 생성자 오버로딩 : 입고 시 반드시 차종과 가격을 입력.
		carsum++; //총 누적대수 증가
		
		if ( !cname.equals("smart") && !cname.equals("web") && !cname.equals("java") ) { // 차종이 3종류 외에 다른것이 입력될 경우
			System.out.println("입력하신 차종 : " +cname); // 오입력한 차종 출력
			System.out.println("입력을 잘못하셨습니다."); // 오류메시지
			System.exit(0); // 프로그램 종료
		} else { // 차종이 맞게 들어온 경우
			this.cname = cname; // 입력받은 차종으로 값 할당
			this.cprice = cprice; // 입력받은 가격으로 값 할당
		}
		if (this.cname.equals("smart")) { // 차종 별 누적대수를 증가.
			ssum++;
		} else if (this.cname.equals("web")) {
			wsum++;
		}else {
			jsum++;
		}
	}
	
	public String getCname() { // 차종을 부를 수 있는 함수.
		return cname;
	}

	public int getCprice() { // 가격을 부를 수 있는 함수.
		return cprice;
	}
		
	public void car_print() { //차종과 가격 출력 기능
		
		if(this.cname.equals("smart")) { // 스마트 일때 △ 별 출력 후 
		
			for (int Line = 1; Line <= 5 ; Line++ ) { //1부터 8까지 1씩 증가하며 반복. Line 값이 5가 되면 끝.(별을 5줄을 찍겠다.)
				
				for (int Null = 5 ; Null >= Line ; Null--) { // 5가 Line 보다 작을떄까지 1씩 감소하며 반복. Null 값이 Line 값보다 작으면 끝.(Null 값이 Line 이 될때까지 공백출력/Line 1 이면 5번, 2이면 4,...)
					System.out.print(" "); //공백출력
				}
				
				for (int Star = 1; Star <= (2*Line)-1 ; Star++){ //1부터 홀수번으로 1씩 증가하며 반복(2*1)-1 = 1, (2*2)-1 = 3... (홀수만큼 별찍기)
					System.out.print("*"); //별출력
				}
				
				System.out.println(); //별 한줄 출력 후 줄바꾸기
			}
			
			System.out.println(this.cname +" " + Car_Mark.getSmark() + " " + this.cprice); // smart 정보
			
		}else if(this.cname.equals("web")) {
			
			for (int Line = 1; Line <= 5 ; Line++ ) { //1부터 5까지 1씩 증가하며 반복. Line 값이 5가 되면 끝.(별을 5줄을 찍겠다.)
				
				for (int Null = 1 ; Null <= Line ; Null++) { // 5가 Line 보다 커질때까지 1씩 증가하며 반복. Null 값이 Line 값보다 크면 끝.(Null 값이 Line 이 될때까지 공백출력/Line 1 이면 1번, 2이면 2,...)
					System.out.print(" "); //공백출력
				}
				
				for (int Star = 9; Star >= (2*Line)-1 ; Star--){ //9부터 홀수번으로 1씩 감소하며 반복(2*1)-1 = 1, (2*2)-1 = 3... (홀수만큼 별찍기)
					System.out.print("*"); //별출력
				}
				System.out.println(); // 별 한줄 출력 후 줄바꿈
			}
			
			System.out.println(this.cname + " " + Car_Mark.getWmark() + " " + this.cprice); // web 정보
			
		}else {
			
			for ( int Line = 1; Line <= 5 ; Line++ ) { // 1부터 5까지 1씩 증가하며 반복 
				for(int Star = 1; Star <=15 ; Star++) { // 1부터 15까지 1씩 증가하며 반복 
					System.out.print("*"); // 별찍기
				}
				System.out.println(); // 별 한줄 출력 후 줄바꿈
			}
			System.out.println(this.cname + " " + Car_Mark.getJmark() + " " + this.cprice); // java 정보
		}
		
	}
	
	public void carsum_print() { // 누적대수 출력 함수
		System.out.printf("총 누적대수는 %d 대 입니다.\n\n",carsum);
	}
	
	public void ssum_print() { // smart 누적 출력 함수
		System.out.printf("smart의  누적대수는 %d 대 입니다.\n\n",ssum);
	}
	
	public void wsum_print() { // wsum 누적 출력 함수
		System.out.printf("web의  누적대수는 %d 대 입니다.\n\n",wsum);
	}
	
	public void jsum_print() { // jsum 누적 출력 함수
		System.out.printf("java의  누적대수는 %d 대 입니다.\n\n",jsum);
	}
}

