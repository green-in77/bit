import kr.or.bit.Copy;
import kr.or.bit.Delete;
import kr.or.bit.Dir;
import kr.or.bit.Rename;
import kr.or.bit.Rmdir;

//RMDIR          디렉터리를 제거합니다.
// [경로명] RMDIR [디렉토리명]

public class Ex_Method {
	public static void main(String[] args) {
		
		if(!(args.length == 2) && !(args.length ==3) && !(args.length ==4)) {  
			System.out.println("사용법 : java [실행파일명] [경로] DIR");
			System.out.println("예시 : java Ex_Method C:\\IOTemp DIR");
			System.out.println();
			
			System.out.println("사용법 : java [실행파일명] [경로] [RENAME] [변경할파일명] [변경후파일명]");
			System.out.println("예시 : java Ex_Method C:\\IOTemp RENAME a.txt cc.txt");
			System.out.println();
			
			System.out.println("사용법 : java [실행파일명] [경로] [COPY] [복사할파일]  [생성파일명]");
			System.out.println("예시 : java Ex_Method C:\\IOTemp COPY a.txt 새파일이름");
			System.out.println();
			
			System.out.println("사용법 : java [파일명] [경로] [DEL] [삭제할파일명]");
			System.out.println("예시 : java Ex_Method C:\\IOTemp DEL 2.jpg");
			System.out.println();
			
			System.out.println("사용법 : java [파일명] [경로] [RMDIR] [삭제할폴더명]");
			System.out.println("예시 : java Ex_Method C:\\IOTemp RMDIR Data");
			System.out.println();
		
			
			System.exit(0);
		}

		
		switch (args[1]) {
			case "DIR":
				Dir dir = new Dir();
				dir.infoDir(args[0]);
				break;
				
			case "RENAME":
				Rename rename = new Rename(args);
				rename.reName();
				break;
					
			case "COPY":
					Copy copy = new Copy(args);
					copy.Copy();
					break;
					
			case "RMDIR":
				Rmdir rmdir = new Rmdir(args);
				rmdir.rmdir();
				break;
				
			case "DEL":
				Delete del = new Delete(args);
				del.delete();
				break;
				
			default :
				System.out.println("잘못입력하셨습니다.");
		}
		
	}
}
