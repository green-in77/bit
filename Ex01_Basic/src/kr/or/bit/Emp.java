package kr.or.bit;

/* 
 **************class는 설계도 이다.**************
 *설계도 기본적인 구성요소(상태정보(속성): 변수 + 행위정보(기능): 함수*
 *
 *자동차 설계도 >>
 *상태정보(속성): 바퀴, 백미러, 창문, 엔진, 속도 >> 변수 >>  int speed=0;
 *행위정보(기능): 전진, 브레이크, 속도를 높인다. >> 함수 >> public void speedUp(){++speed}
 *한개로 표현할수없다면 한번 더 쪼갠다.
 *엔진 설계도:톱니바퀴, 고무줄, 기름
*/
public class Emp { // 사원이라는 설계도
	public int empNo; //사원은 사번을 가지고 있다 (사번 숫자 데이터(고유정보)) -> member field
								// -> instance variable
	public String eName;
	public String eJob;
	public int eData;
	
	public int getData() {
		return eData;
	}
	/*
	 * 캡슐화: 직접할당을 막고 간접할당을 허용한다.
	 */
	public void setData(int data) {//캡슐화된 자원에 대해 set, get >> setter함수, getter함수
		if(data < 100) {
			this.eData=data;
		} else
			this.eData=0;
	}
	/*
	 * 행위정보(기능): 함수(method)
	 * 함수는 반드시 호출 동작
	 */
	public String getEmpInfo() {
		return empNo + "/" + eName + "/" + eJob;
	}
}
