package Aop_anno2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect

public class MyAspect {
	
	@Pointcut("execution(* sumething())")
	public void pointcut() {}
	
	@Before("pointcut()")
	public void before() {
		System.out.println("문을 연다");
	}
	
	@AfterReturning("pointcut()")
	public void afterReturn() {
		System.out.println("잔다");
	}
	
	@After("pointcut()")
	public void after() {
		System.out.println("집을 나간다");
	}
	
}