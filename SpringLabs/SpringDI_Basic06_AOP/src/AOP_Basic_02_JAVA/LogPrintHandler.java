package AOP_Basic_02_JAVA;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;
// InvocationHandler : 대리할 수 있는...
/*
보조관심(공통관심) 구현
invoke : 하나의 함수가 여러개의 함수를 대리해서 처리
*/
public class LogPrintHandler implements InvocationHandler{
	private Object target; //실객체의 주소값
	
	public LogPrintHandler(Object object) {
		System.out.println("LogPringHandler : 보조관심 생성자 호출");
		this.target = object;
	}
	
	//주업무(함수)
	//invoke : Add, Mul, Sub 대리해서 처리
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Invoke 함수 호출");
		System.out.println("method : 호출 함수 명 : " + method);
		System.out.println("method parameter : " + Arrays.toString(args));
		
		//보조(공통)업무(advice)
		Log log = LogFactory.getLog(this.getClass()); //log 만들 준비 : 현재 실행중인 class
		StopWatch sw = new StopWatch(); //스프링 제공
		sw.start();
		log.info("[timer 시작]");
		
		//주업무(실 객체의 함수 호출 : Add, Mul, Sub)
		int result = (int) method.invoke(this.target, args);
		
		//보조(공통)업무(advice)		
		sw.stop();
		log.info("[timer 종료]");
		log.info("[TIME LOG Mathod]");
		log.info("[TIME LOG Mathod Time : " + sw.getTotalTimeMillis() + "]"); //endtime - starttime
		
		return result;
	}

}
