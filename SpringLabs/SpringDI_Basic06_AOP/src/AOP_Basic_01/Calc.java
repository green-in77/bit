package AOP_Basic_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

/*
간단한 계산기 프로그램
- 주관심(업무) : 사칙연산 -> 기능(함수)
- 보조관심(공통) : 연산에 걸린 시간
-- log 출력(console 출력 : 시스템이 출력하는 것처럼 Red 색으로 ...시간을)
 */

public class Calc {
	
	public int Add(int x, int y) {
		Log log = LogFactory.getLog(this.getClass()); //log 만들 준비 : 현재 실행중인 class
		//System.currentTimeMillis(); //java 제공 시간측정
		StopWatch sw = new StopWatch(); //스프링 제공
		sw.start();
		log.info("[timer 시작]");
		
		int result = x + y; //주관심
		
		sw.stop();
		log.info("[timer 종료]");
		log.info("[TIME LOG Mathod : ADD]");
		log.info("[TIME LOG Mathod Time : " + sw.getTotalTimeMillis() + "]"); //endtime - starttime
		
		return result;
	}
	
	public int Mul(int x, int y) {
		Log log = LogFactory.getLog(this.getClass()); //log 만들 준비 : 현재 실행중인 class
		//System.currentTimeMillis(); //java 제공 시간측정
		StopWatch sw = new StopWatch(); //스프링 제공
		sw.start();
		log.info("[timer 시작]");
		
		int result = x * y;
		
		sw.stop();
		log.info("[timer 종료]");
		log.info("[TIME LOG Mathod : Mul]");
		log.info("[TIME LOG Mathod Time : " + sw.getTotalTimeMillis() + "]"); //endtime - starttime
		
		return result;
	}
}
