package AOP_Basic_02_JAVA;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

/*
간단한 계산기 프로그램
- 주관심(업무) : 사칙연산 -> 기능(함수)
- 보조관심(공통) : 연산에 걸린 시간
-- log 출력(console 출력 : 시스템이 출력하는 것처럼 Red 색으로 ...시간을)
 */

public class NewCalc implements Calc {
	@Override
	public int Add(int x, int y) {
		//보조업무(공통업무) Cross-cutting-concern
		
		int sum = x + y; //주관심 (Core-concern)
		
		//보조업무(공통업무) Cross-cutting-concern
		return sum;
	}
	
	@Override
	public int Mul(int x, int y) {
		//보조업무(공통업무) Cross-cutting-concern
		
		int mul = x * y; //주관심 (Core-concern)
				
		//보조업무(공통업무) Cross-cutting-concern
		return mul;
	}

	@Override
	public int Sub(int x, int y) {
		//보조업무(공통업무) Cross-cutting-concern
		
		int sub = x - y; //주관심 (Core-concern)
				
		//보조업무(공통업무) Cross-cutting-concern
		return sub;
	}
}
