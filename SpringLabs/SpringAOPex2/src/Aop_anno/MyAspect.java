package Aop_anno;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	@Pointcut("execution(public * Aop_anno..*(..))")
	public void pointcut() {}
	
	@Before("pointcut()")
	public void before() {
		System.out.println("before : 메뉴를 선택하세요.");
	}
	
	@AfterReturning("pointcut()")
	public void afterReturn() {
		System.out.println("after Returning : 감사합니다.");
	}
	
	@After("pointcut()")
	public void after() {
		System.out.println("after : 맛있게드세요.");
	}
}