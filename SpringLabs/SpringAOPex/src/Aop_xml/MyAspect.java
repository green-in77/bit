package Aop_xml;

public class MyAspect {
	public void before() {
		System.out.println("문을 연다");
	}
	
	public void afterReturn() {
		System.out.println("잔다");
	}
	
	public void after() {
		System.out.println("집을 나간다");
	}
}
