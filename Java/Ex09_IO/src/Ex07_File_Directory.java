import java.io.File;

/*
 I/O 클래스
 파일과 폴더를 다루는 클래스
 
 JAVA : File 클래스(파일, 폴더)
 >> a.txt 생성, 수정, 삭제, ★정보read★
 >> Temp 폴더 생성, 삭제, 정보 read
 C# : File , Directory 별도 
 
 경로
 절대경로 : C:\\ , D:\\ 
 상대경로 : 현재 파일을 중심으로 ( DOS 기준 cd ..)
 */
public class Ex07_File_Directory {
	public static void main(String[] args) {
		String path = "C:\\IOTemp\\file.txt"; // 없는 파일 > 파일 생성하지 못함.
		File f = new File(path);
		//f.createNewFile(); 파일 생성기능
		System.out.println("파일명 : " + f.getName()); // 파일 이름 가져오기
		System.out.println("전체경로 : "+f.getPath()); // 파일 전체경로★
		System.out.println("절대경로 : " + f.getAbsolutePath()); // 파일 절대경로
		System.out.println("너 폴더니?"+f.isDirectory()); // 폴더인지? T/F★
		System.out.println("너 파일이니?" + f.isFile()); // 파일인지? T/F★
		System.out.println("파일크기 : "+f.length() + "byte"); // 파일 용량
		System.out.println("부모경로 : " + f.getParent()); // 나의 제외한 위의 경로 전체
		System.out.println("존재여부(파일,폴더) : "+f.exists()); // 파일(폴더)이 존재하니?★ 
		
		//f.delete(); // return T/F
		//f.canRead(); //읽을 수 있니???
		
	}
}
