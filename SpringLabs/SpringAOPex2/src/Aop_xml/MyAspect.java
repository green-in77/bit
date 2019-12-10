package Aop_xml;

public class MyAspect {
	public void before() {
		System.out.println("before : 메뉴를 선택하세요.");
	}
	
	public void afterReturn() {
		System.out.println("after Returning : 감사합니다.");
	}
	
	public void after() {
		System.out.println("after : 맛있게드세요.");
	}
}