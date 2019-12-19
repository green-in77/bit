import java.io.File;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_File_Format {
	public static void main(String[] args) {
		// format 클래스 https://cafe.naver.com/bitsmartweb/352
		
		//화폐단위처리
		DecimalFormat df = new DecimalFormat("#,###.0"); 
		String result = df.format(1234567.89); // 문자열 이기 때문에 연산불가
		String result2 = df.format(1000000000); // 문자열 이기 때문에 연산불가
		System.out.println(result);
		System.out.println(result2);
		
		//날짜형식처리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String strDate = sdf.format(new Date());
		System.out.println(strDate);
		
		/*
		//문자형식처리 // printf 같은... //Web 형식을 정의할때...(printf 웹에서 못씀...)
		String userId = "green";
		String message = "회원 Id :{0} \n회원 이름 : {1} \n회원 전화번호 : {2}";
		String result3 = MessageFormat.format(message, userId, "초록", "010-1111-1111");
		System.out.println(result3);
		*/
		
		File dir = new File("C:\\IOTemp");
		File[] files = dir.listFiles(); //IOTemp 폴더 아래있는 파일과 폴더목록을 관리... // 해당 폴더의 리스트를 파일배열로 return
		
		for (int i = 0 ; i < files.length; i++) {
			File file = files[i];
			String name = file.getName();
			//System.out.println(name);
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH-mma");
			String attribute = "";
			String size="";
			if (files[i].isDirectory()) { // 더 폴더니??
				attribute = "<DIR>";
			}else {
				size = file.length() + "byte"; // 파일의 용량
				attribute = file.canRead() ? "R" : ""; //읽을수있니?
				attribute += file.canWrite() ? "W" : ""; // 쓸수 있니?
				attribute += file.isHidden() ? "H" : ""; //숨김파일이니?
			}
																												//파일의 마지막수정날짜(long 타입)
			System.out.printf("%s	%3s		%10s		%s	\n",dt.format(new Date(file.lastModified())), attribute, size, name );
		}
		
	}
}
