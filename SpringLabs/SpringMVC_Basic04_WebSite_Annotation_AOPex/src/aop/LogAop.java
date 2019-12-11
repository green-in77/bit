package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAop {
	@Before("execution(public * ncontroller..*(..))")
	public void beforeLog() {
		System.out.println("Before");
	}
	
}
