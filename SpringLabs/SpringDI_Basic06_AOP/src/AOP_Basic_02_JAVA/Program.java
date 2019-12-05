package AOP_Basic_02_JAVA;

import java.lang.reflect.Proxy;

public class Program {

	public static void main(String[] args) {
		Calc calc = new NewCalc();
		
		//Proxy 객체 통해서 처리
		Calc cal = (Calc) Proxy.newProxyInstance(calc.getClass().getClassLoader(), //실제 객체의 메타 정보
							   calc.getClass().getInterfaces(), //행위정보(인터페이스)
							   new LogPrintHandler(calc) //보조관심객체(parameter 실객체의 주소)
							  );

		//Proxy 를 통해서 처리하지만 사용하는 사용자는 Calc 객체를 사용하는 것처럼
		int result = cal.Add(5000, 5000);
		System.out.println(result);
		
		result = cal.Mul(10, 10);
		System.out.println(result);
		
		result = cal.Sub(10, 5);
		System.out.println(result);
				
	}

}
