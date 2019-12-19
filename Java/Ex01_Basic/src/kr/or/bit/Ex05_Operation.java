package kr.or.bit;

public class Ex05_Operation {

	public static void main(String[] args) {
//		int result= 100/100;
//		System.out.println(result);
//		result=13%2;
//		System.out.println(result);
//		
//		//증가, 증감 연산자
//		int i= 10;
//		++i; //전치 증가
//		i++; //후치 증가
//		System.out.println(i);
		
		/*
		 * 전치, 후치연산자는 각각 있을땐 차이가 없다.
		 * 다른 연산자와 결합했을때 전치는 연산전에 증감(가)하고 후치는 연산이 끝난 후에 증감(가)한다.
		 */
		int i2=5;
		int j2=4;
		
		//int result2= i2 + ++j2;//전치
		int result3= i2 + j2++;//후치
		//System.out.println(result2);
		System.out.println(result3);
		
		/*
		 * Point
		 * 자바의 연산규칙
		 * [정수]의 모든 [연산]은 [int]로 [변환] 후 처리
		 * byte + byte = 컴파일러가 int + int로 처리
		 */
		byte b= 100;
		byte c= 1;
		//byte d= b+c; 에러, b+c를 기본적으로 int로 계산하기때문.
		
		long lResult= 1000000000L;
		float fResult= 1.2f;
		float lfResult= lResult + fResult; //실수가 표현범위가 더 넓음
		System.out.println(lfResult);
		
		float num2= 10.45f;
		int num3= 20;
		int result5=(int)num2+num3;
		System.out.println(result5);
		
		char c2= '!';
		char c3= '!';
		System.out.println(c2+c3);
		
//		char ch='A';
//		for (int i = 0; i < 10; i++) {
//			System.out.println((char)(ch+i));
//		}
		int sum=0;
		int sum2=0;
		for(int i=1; i<=100; i++) {
			if(i%2==0) {
				sum+=i;
			} else
				sum2+=i;
		}
		System.out.println(sum);
		System.out.println(sum2);
		
		if(10==10.0f) {
			System.out.println("True");
		}
		else
			System.out.println("False");
		
		//Point(암기)
		//삼항 연산자
		int p= 10;
		int k= -10;
		
		int result8= p==k ? p : k;
		System.out.println(result8);
		
		int result9=0;
		if(p==k) 
			result9=p;
		result9=k;
		System.out.println(result9);
		
		/*
		 *  				OR		AND
		 *  |	0 0	|	 0		|	  0		|
		 *  |	0 1	|	 1		|	  0		|
		 *  |	1 0	|	 1		|	  0		|
		 *  |	1 1	|	 0		|	  1		|
		 *  
		 *  비트연산자
		 *  | or 연산자
		 *  & and 연산자
		 *  0과 1로 변환해서 bit 연산을 해라
		 *  || 논리연산
		 *  && 논리연산
		 */
		
		int x= 3;
		int y= 5;
		System.out.println("x|y: " + (x|y));
		//x와 y를 이진수로 변환한 후 이진수를 or로 연산함.
		System.out.println("x&y: " + (x&y));
		
		/*
		 * Point 논리연산( &&(and), ||(or) )
		 * if(10 > 0 && -1 > 1 && 100 > 2 && 1 > -1 && ....) { 실행문};
		 * if(10 > 0 || -1 > 1 || 100 > 2 || 1 > -1 || ....) { 실행문};
		 */
	}
	

}
