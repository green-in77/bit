package kr.or.bit.utils;

import java.util.Calendar;

//�Լ�(��¥ ó��)
//Edu_Date e = new....
//e.�Լ���

//static void date //���̾��ϱ�.
//Edu_Date.date()

//�����ε�.....������ �ִ� ��¥, ���� ��¥ ���... : �Լ��� �̸��� ���� ����� �پ��ϰ�...

public class Edu_Date {
	public static String DateString(Calendar date) {
		return date.get(Calendar.YEAR) + "�� " + monthFormat_DateString(date) + "�� " + date.get(Calendar.DATE) + "��";
	}
	public static String DateString(Calendar date, String opr) {
		return date.get(Calendar.YEAR) + opr +  monthFormat_DateString(date) + opr + date.get(Calendar.DATE);
	}
	
	// �䱸���� : 2019-1-1 >> 2019-01-1 1~9������ 0# // 
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