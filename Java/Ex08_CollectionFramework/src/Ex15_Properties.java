import java.util.Properties;

/*
 Map 인터페이스를 구현한 클래스
 특수한 목적의 클래스 < String , String > key type, value type
 고정시킨 클래스. : Properties
 사용목적
 APP 공통속성정의 (환경변수) : 프로그램의 버전, 파일경로, 공통변수
 ex)
 datasample.properties 만들어서
 DB 사용자 ID, PWD 담아놓고 불러쓰기
 다국어처리
  
 */
public class Ex15_Properties {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("master", "bit@bit.or.kr");
		prop.setProperty("version", "1.1.1.1");
		prop.setProperty("defalutpath","C:\\Temp\\images" );
		//////////////////////////////////////////////////////////////
		// 각각의 개발 페이지에서...
		System.out.println(prop.getProperty("master")); // 키 값을 주면 value 값을 줌..
		System.out.println(prop.getProperty("version"));
		System.out.println(prop.getProperty("defalutpath"));

	}
}
