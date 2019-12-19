package kr.or.bit.utils;

import java.util.Calendar;

//함수(날짜 처리)
//Edu_Date e = new....
//e.함수명

//static void date //많이쓰니까.
//Edu_Date.date()

//오버로딩.....연도가 있는 날짜, 없는 날짜 등등... : 함수의 이름은 같고 기능은 다양하게...

public class Edu_Date {
	public static String DateString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 " + monthFormat_DateString(date) + "월 " + date.get(Calendar.DATE) + "일";
	}
	public static String DateString(Calendar date, String opr) {
		return date.get(Calendar.YEAR) + opr +  monthFormat_DateString(date) + opr + date.get(Calendar.DATE);
	}
	
	// 요구사항 : 2019-1-1 >> 2019-01-1 1~9월까지 0# // 
	public static String monthFormat_DateString(Calendar date) {
		String month;
		if ( date.get(Calendar.MONTH) <= 9) {
			month = "0"+(date.get(Calendar.MONTH)+1);
		}else {
			month = "(date.get(Calendar.MONTH)+1)";
		}
		return month;
	}
	
}