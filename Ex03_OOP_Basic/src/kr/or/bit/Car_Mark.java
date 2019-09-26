package kr.or.bit;

public class Car_Mark {
	private static String smark = "△";  // smart의 마크
	private static String wmark = "▽"; // web의 마크
	private static String jmark = "□"; // java 의 마크
	
	public static String getSmark() { //smart mark 를 부르듣 getter 함수
		return smark;
	}
	public static String getWmark() { //web mark 를 부르듣 getter 함수
		return wmark;
	}
	public static String getJmark() { //java mark 를 부르듣 getter 함수
		return jmark;
	}
	
}