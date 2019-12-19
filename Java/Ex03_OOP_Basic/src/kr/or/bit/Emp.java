/*
우리는 사원에 대한 설계도를 만들려고 한다.
사원의 요구사항은
속성을 3가지 구분 : 고유 , 상태 , 부품 

사원은 사번을 가지고 있고 사번은 숫자 데이터로 관리 하려고 한다.  고유  
사원은 이름을 가지고 있고 이름은 문자 데이터로 관리 하려고 한다.  고유
사원은 직종을 가지고 있다 직종은 (IT, SALES) 등의 데이터로 관리된다. 고유
사원은 급여를 받는다 급여는 숫자 데이터로 관리된다. 고유
사원은 신체정보를 가지고 있다 신체정보는 키와 몸무게 데이로 관리된다.
 */

package kr.or.bit;

public class Emp {
	public int empno;
	public String ename;
	public String jobs;
	public int sal;
	public BodyInformation bodyinfo;
}
