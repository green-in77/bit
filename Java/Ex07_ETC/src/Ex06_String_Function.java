import java.util.StringTokenizer;

// String 클래스 ( 문자열 )
// 개발단에서 문자열을 다루는 코드...(String 함수)
// String 클래스는 static  함수 + 일반함수(public)

// 중요 ( 암기 )... 10개...
public class Ex06_String_Function {
	public static void main(String[] args) {
		String str = ""; //빈문자열로 초기화. //초기화 없으면 null
		
		String[] strarr = {"aaa","bbb","ccc"};
		for (String s : strarr) {
			System.out.println(s);
		}
		
		//함수
		String ss = "hello";
		//concat 문자열 합치기.
		String concatstr = ss.concat(" world"); // concat => ss의 문자열에 뒤의 문자열을 합치는 것.
		System.out.println(concatstr);
		
		//contains 연속된 문자열을 포함하고 있는지 묻는 함수.
		System.out.println(ss.contains("h")); // ss가 h를 포함하고 있는가 : true
		System.out.println(ss.contains("heo")); //ss 가 연속된 heo을 포함하고 있는가 : false
		
		String ss2 = "a b c d"; // heap char[] [a][ ][b][ ][c][ ][d]
		System.out.println(ss2.length());//★★ length 외우기 문자열의 길이. // 7 ( 공백도 문자)
		
		String filename = "hello java, world";
		System.out.println(filename.indexOf(","));//★★ indexOF 외우기 해당 문자의 index 값. // 10 ( index 0번부터~)
		System.out.println(filename.indexOf("java")); // java 의 첫 시작점인 j의 index 값 // 6
		System.out.println(filename.indexOf("jeva")); // 단어 기준으로 찾기 때문에 없는 단어라 찾지 못함. //결과값 -1 / 배열에서 없는 값을 의미. 
		
		// 0보다 큰 값을 리턴하면 문자에 원하는 단어가 있음.
		if ( filename.indexOf("hello") >= 0 ) {
			System.out.println("hello 문자가 포함되어 있습니다.");
		}
		System.out.println(filename.lastIndexOf("a")); // 문자열 중 마지막 a의 index 값.// 9
		
		// ★★ 외우기 length, indexof, substring, replace, split..
		
		String result = "superman";
		System.out.println(result.substring(0)); //superman
		System.out.println(result.substring(2)); //perman
		System.out.println(result.substring(0,0)); // endIndex -1 -> (0,-1) 값이 나오지 않음.
		System.out.println(result.substring(0,1)); // endIndex -1 -> (0,0) s
		System.out.println(result.substring(1,1)); // endIndex -1 -> (1,0) 값이 나오지 않음 거꾸로 감..
		System.out.println(result.substring(2, 3)); // endIndex -1 -> (2,2) p
		
		System.out.println();
		
		//Quiz
		String filename2 = "bread.jpg"; // hong.png, 1.txt
		//여기서 파일명과 확장명을 분리해서 출력.
		int i2 = filename2.lastIndexOf(".");
		System.out.println(filename2);
		System.out.println(filename2.substring(0, i2));
		System.out.println(filename2.substring(i2+1, filename2.length())); // 어차피 끝까지 나오는 거라... length 안써도 상관없음...
		System.out.println(filename2.substring(++i2)); //확장자...
		
		//replace (치환함수)
		String s4 = "ABCDADDDA";
		String result4 = s4.replace("A", "안녕");
		System.out.println(result4); //A의 위치에 안녕으로 치환.
		
		// chartAt()
		System.out.println(s4.charAt(0)); // 해당 index 에 들어있는 char 추출
		System.out.println(s4.charAt(3));
		
		System.out.println(s4.endsWith("DDA")); // 끝에서 해당 문자를 가지고 있는지 true
		System.out.println(s4.endsWith("DDD")); // 끝에서 해당 문자를 가지고 있는지 false
		
		System.out.println(s4.equalsIgnoreCase("ABcdAdddA")); // 대소문자 구분 없이 같은 값인지 확인.
		
		// POINT : split
		String s6 = "슈퍼맨,팬티,노랑색,우하하,우하하";
		String[] namearray = s6.split(","); // 해당 문자를 기준으로 분리해서 배열로 return
		for (String name : namearray) {
			System.out.println(name);
		}
		
		String filename3 = "bit.hwp";
		String[] filearray = filename3.split("\\."); // \ 자바의 정규표현 인식 기호 + \. 점의 정규표현
		for (String name : filearray) {
			System.out.println(name);
		}
		// 정규표현식... (Java, javascript, db 다 사용)
		//특수한 문자로 패턴설계 >> 설계한 형식으로 >> 유효성 검증
		// 주민번호, 전화번호, 핸드폰번호, 차량번호, 우편번호 ...
		
		// 010-{\d4}-0000 정규표현식 >> {\d4}  d 는 십진수 4자리.
		// 010-456-0000 -> 456은 정규표현식에 맞지않 false
		
		// 추후 카페에... ( 정규표현식 5개 만들기 )
		// 다음주.....쯤...?
		
		String s7 = "a/b,c.d-f";
		StringTokenizer sto = new StringTokenizer(s7,"/,.-"); // 해당 문자를 전부 분리기준으로...
		while(sto.hasMoreTokens()) {
			System.out.println(sto.nextToken());
		}
		
		//넌센스 quiz
		String s8 = "홍           길      동";
		//  저장 > "홍길동" 공백제거
		System.out.println(s8.replace(" ","")); // 공백을 공백이 없는 것으로 치환...
		
		String s9 = "                홍길동           ";
		System.out.println(">"+s9+"<");
		System.out.println(">"+s9.trim()+"<"); // 좌우 공백 지워줌.
		
		
		String s10 = "          홍        길   동          ";
		System.out.println(">"+s10.replace(" ","")+"<"); // 공백을 공백이 없는 것으로 치환...
		
		//여러개의 함수를 연결해서 (chain)
		//method chain 기법***************************************
		
		System.out.println(s10.trim().replace(" ",""));
		
		//Quiz-1
		int sum=0;
		String[] numarr = {"1","2","3","4","5"};
		// 문제 : 배열에 있는 문자값들의 합을 sum 에 담아서 출력
		/*
		for (int j = 0 ; j < numarr.length ; j++) {
			sum += Integer.parseInt(numarr[j]);
		}
		System.out.println(sum);
		*/
		for (String s : numarr) {
			sum += Integer.parseInt(s);
		}
		System.out.println(sum);
		
		//Quiz-2
		String jumin = "123456-1234567";
		jumin=jumin.replace("-","");
		System.out.println(jumin);
		
		sum = 0;
		
		//substring
		for ( int j = 0; j < jumin.length();j++) {
			sum += Integer.parseInt(jumin.substring(j,j+1));
		}
		System.out.println(sum);
		
		/////////////////////////////////////////////////////////////////////강사님	
		int sum2=0;
		
		   for(int i = 0 ; i < jumin.length() ; i++) {
			   String numstr =jumin.substring(i, i+1);
			   if(numstr.equals("-")) continue; // -랑 같으면 스킵.
			   sum2+= Integer.parseInt(numstr);
		   } 
		   System.out.println("주민번호 합:" + sum2);
		   
		 //위 주민번호의 합을 구하세요_2
		   String[] numarr2 = jumin.replace("-","").split("");
		   int sum3=0;
		   for(String i : numarr2) {
			   sum3+= Integer.parseInt(i);
		   }
		   System.out.println("주민번호 합2:" + sum3);
		   
		 //위 주민번호의 합을 구하세요_3
		   String jumin4 = jumin.replace("-", "");
		   int sum4=0;
		   for(int i = 0 ; i < jumin4.length() ;i++) {
			   sum4+=Integer.parseInt(String.valueOf(jumin4.charAt(i)));
		   }
		   System.out.println("주민번호 합4:" + sum4);
		   ///////////////////////////////////////////////////////////////////////////////
		   
		   //String 클래스 (static)
		   // printf (cmd 모드에서만)
		   // String >> format 함수.. (printf 처럼)
		   
		   String str5 = String.format("%d-%s",100,"문자열");
		   System.out.println(str5);
		   
		   
		   
		}
		
	}

