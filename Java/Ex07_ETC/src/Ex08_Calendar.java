import java.util.Calendar;
import java.util.Date;

import kr.or.bit.utils.Edu_Date;

/*
* Calendar 를 상속받아 완전히 구현한 클래스는 
 * GregorianCalendar
   buddhisCalendar 있는데 getInstance()는 [시스템의 국가와 지역설정]을 [확인]해서
      태국인 경우 buddhisCalendar 의 인스턴스를 반환하고 그 외에는 GregorianCalendar
     의 인스턴스를 반환한다
   GregorianCalendar 는 Calendar를 상속받아 오늘날 전세계 공통으로 사용하고 있는 
   그레고리력에 맞게 구현한 것으로 태국을 제외한 나머지 국가에서는 GregorianCalendar 사용
   그래서 인스턴스를 직접 생성해서 사용하지 않고 메서드를 통해서 인스턴스를 반환받게하는
   이유는 최소의 변경으로 프로그램 동작을 하도록 하기 위함
   class MyApp{
     static void main(){
      Calendar cal = new GregorianCalendar();
      다른 종류의 역법의 사용하는 국가에서 실행하면 변경......    }  }
   class MyApp{
     static void main(){
      Calendar cal = new getInstance();
        다른 종류의 역법의 사용하는 국가에서 실행하면 변경......   }  }
  API : 생성자 Protected Calendar() 
 */
//Java API
//날짜 : Date (구) -> Calendar(신)

public class Ex08_Calendar {
	public static void main(String[] args) {
		
		Date dt = new Date(); // 구버전
		System.out.println(dt);
		
		Calendar cal = Calendar.getInstance(); //PC의 지역정보를 보고 태국이면 태국을 리턴/ 그 외는 그레고리안 형식 리턴 
		System.out.println(cal);
		// 당신이 필요한 시간에 대한 정보를 나열시켜 줄게..( 정보를 뽑아서 써..)
		
		System.out.println("년도 : " + cal.get(Calendar.YEAR));
		System.out.println("월(0~11) : " + (cal.get(Calendar.MONTH)+1));
		System.out.println("일 : " + cal.get(Calendar.DATE));
		System.out.println("이 달의 몇번째 주 : " + cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println("오늘이 이번달의 몇번째 날 : " + cal.get(Calendar.DAY_OF_WEEK)); // 일요일부터~
		
		//PC의 시간
		System.out.println("시 : " + cal.get(Calendar.HOUR));
		System.out.println("분 : " + cal.get(Calendar.MINUTE));
		System.out.println("초 : " + cal.get(Calendar.SECOND));
		
		System.out.println("AM/PM : " + cal.get(Calendar.AM_PM)); // 0 은 AM / 1 은 PM
		
		//웹사이트(학원교육 사이트)
		// 200번... 150p 이상에서는 날짜를 씀.. ( 수정 시 150번 수정...)
		// 날짜 관련된 클래스 : 특정 함수 호출 : 화면 날짜 출력
		// class MyDate { static void todate(){} }
		// Mydate.todate();
		
		String date = Edu_Date.DateString(Calendar.getInstance());
		System.out.println(date);
		
		date = Edu_Date.DateString(Calendar.getInstance(), "-");
		System.out.println(date);
		
		date = Edu_Date.monthFormat_DateString(Calendar.getInstance());
		System.out.println(date);
		
		
	}

}
