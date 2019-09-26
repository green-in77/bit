import java.io.File;

public class Ex08_File_Directory {
	public static void main(String[] args) {
		//System.out.println(args.length);
		//System.out.println(args[0]);
		
		if(args.length != 1) {
			System.out.println("사용법 : java 파일명 [디렉토리명]" );
			System.exit(0); // 프로세스 강제종료
		}

		File f = new File(args[0]);
		//java Ex08... C:\\Temp
		
		if(!f.exists() || !f.isDirectory()) { //존재하지 않거나 or 디렉토리가 아니라면
			System.out.println("유효하지 않은 경로입니다.");
			System.exit(0);
		}
		//실제 존재하는 경로라면
		//dir 처럼 목록을 보여주고 싶음.
		
		File[] files = f.listFiles(); // listFiles File 배열 형식으로 리스트 return
		//C:\\Temp\\a.txt
		//C:\\Temp\\b.txt
		//C:\\Temp\\참새
		//File[] arryfiles = {new file(C:\\Temp\\a.txt), new file(C:\\Temp\\b.txt), new file(C:\\Temp\\참새)} 를 만들어서 주소를 files 로 return.
		
		for (int i = 0; i < files.length ; i++ ) {
			String name = files[i].getName(); // 파일명, 폴더명
			System.out.println(files[i].isDirectory()?"[DIR]"+name : name);
		}
		
		
	}
}
