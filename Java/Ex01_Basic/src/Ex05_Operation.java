//연산자
public class Ex05_Operation {
	public static void main(String[] args) {
		int result = 100/100;
		System.out.println(result);
		
		result = 13/2; //몫
		System.out.println(result);
		
		//나머지를 구하는 연산자 (%)
		result = 13%2; //나머지
		System.out.println(result);
		
		//증가 , 감소 (증가감 연산자 : ++ , --) 1씩 증가 , 1씩 감소
		int i =10;
		//i = i+1;
		++i;//전치증가
		System.out.println("전치 i : " + i);
		i++;//후치증가
		System.out.println("후치 i : " + i);
		//변수 혼자 : 전치 , 후치 동일
		
		//POINT : 전치 후치는  다른 연산자와 결합(성질)
		int i2 = 5;
		int j2 = 4;
		
		int result2 = i2 + ++j2;
		System.out.println("result2 :" + result2 + " j2:" + j2);
		//result2:10 , i2=5  , j2=5
		result2 = i2 + j2++;
		System.out.println("result2 :" + result2 + " j2:" + j2);
		
		//POINT
		//자바의 연산 규칙
		//[정수]의 모든 [연산]은 [ int ] [변환] 후 처리
		//byte + byte => 컴파일러가 int + int
		byte b = 100; //-128 ~ 127
		byte c = 1;
		byte d = (byte)(b + c);
		//1. int d = b + c;
		//2. byte d = (byte)(b+c) 데이터 손실이 올수도
		
		//byte + short => 컴파일러  int + int
		//char + char  => 컴파일러  int + int
		//연산처리시
		//POINT : 연산에서 int 보다 작은 타입은 int 변환 (long 제어)
		//연산(byte , char , short -> int )바꾸어서 처리
		
		//규칙 피연산자 중 표현 범위가 [큰 타입]으로 형 변환
		//byte + short -> int + int  >>int
		//char + int -> int + int    >>int
		//int + long -> long + long  >>long
		
		//정수 + 실수 
		long ll = 10000000000L;
		float ff = 1.2f;
		float fresult = ll + ff; //승자 실수
		System.out.println("fresult : " + fresult);
		
		float num2 = 10.45f;
		int num3 = 20;
		//num2 + num3
		//받는 쪽을 큰 타입 : float + int >>  float + float
		//float result5 = num2 + num3;
		//System.out.println(result5); //30.45
		
		int result5 = (int)(num2 + num3);
		System.out.println(result5); //정수부만 ....
		
		char c2 = '!'; //char 정수타입 (내부적으로 ....정수)
		char c3 = '!';
		
		//c2 + c3 결과는 ...
		//char result6 = c2 + c3; 안되용 ... int + int
		int result6 = c2 + c3;
		System.out.println("result6 : " + result6);
		//더한 값을 문자로 출력 : 십진수 66을 아스키코드표 문자 ..
		System.out.println((char)result6);
		
		//제어문 
		//중소기업 시험문제(구구단 출력) >> 별찍기
		//2~9
		//2 >> 1~9
		//3 >> 1~9
		
		//main 함수 안에 있는 local variable
		
		int sum = 0;
		for(int j =1; j<= 100 ; j++) {
			System.out.println("j++ : " + j);
			if(j%2 == 0) {  // == true , false
				//System.out.println("j :" + j);
				sum+=j;//sum=sum+j;
			}
		}
		System.out.println(sum);
		
		// ==연산자 (값을 비교하는 연산자)
		if(10 == 10.0f) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		//! 부정연산자
		if('A' != 65) { //같지 않니
			System.out.println("어 같지 않아 ...");
		}else {
			System.out.println("어 같은 값이야");
		}
		
		//암기하자 (POINT)
		//삼항연산자 
		int p =10;
		int k =-10;
		int result8 = (p == k)? p : k;   //  ?   :
		//System.out.println("result3 :" + result8);
		//삼항연산자 if 문과 호환 가능
		//if문
		//int result8 = 0;
		if(p==k) {
			result8 = p;
		}else {
			result8 = k;
		}
		System.out.println("result3 :" + result8);
		
		//진리표
		/*
		  (논리연산)
		  0 : false
		  1 : true
		        OR     AND
		  0 0   0       0
		  0 1   1       0 
		  1 0   1       0
		  1 1   1       1
		  
		 sql문 (oracle)  
		 select *
		 from emp
		 where empno=1000 and sal > 2000  //그리고  
		 
		 select *
		 from emp
		 where empno=1000 or sal > 2000  //또는  , 이거나
		 
		 연산자
		 | or 연산자
		 & and 연산자
		 0 과 1 변환해서 bit 연산
		 
		 || 논리연산
		 && 논리연산 	 
		*/
		
		int x = 3;
		int y = 5;
		System.out.println("x|y:" +(x|y));
		//십진수 3을 -> 2진수 (0과 1로만 이루어진 값으로 바꾸어서)
		//2 0승 , 2 1승
		// 128 64 32 16 8 4 2 1
		//              0 0 1 1  >> 3 2진수값
		//              0 1 0 1  >> 5 2진수값
		//OR            0 1 1 1  >> 4+2+1 > 7
		//AND           0 0 0 1  >> 1
		
		System.out.println("x&y:" +(x&y));
		
		//POINT 논리연산( &&(and) , ||(or) )
		//if(10 > 0 && -1 > 1 && 100 > 2 && 1 > -1 && .....){실행문} 
		//if(10 > 0 || -1 > 1 || 100 > 2 || 1 > -1 || .....){실행문}
	}

}



