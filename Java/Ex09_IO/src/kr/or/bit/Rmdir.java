package kr.or.bit;

import java.io.File;

public class Rmdir {
	private String[] args;
	private File f;
	private boolean check;
	
	public Rmdir (String[] args) {
		this.args = args;
		f = new File(args[0]+"\\"+args[2]);
	}
	
	public void rmdir() {
		System.out.println("삭제하실 폴더 : " + f.getAbsolutePath());
		
		routeCheck(); // 경로 확인
		commandCheck(); // 명령어확인
		emptyCheck(); // 빈폴더확인
		
		check=f.delete(); //삭제하기
		deleteCheck(); // 삭제완료확인
		
	}
	
	private void routeCheck() { // 경로확인
		if ( !this.f.exists() || !this.f.isDirectory()) { // 경로가 존재하지 않거나, 폴더가 아니면
			System.out.println("유효하지 않은 디렉토리 입니다.");
			System.exit(0);
		}
	}
	
	private void commandCheck() { // 명령어확인
		if ( !(args[1].equals("RMDIR"))) {
			System.out.println("잘못된 명령어 입니다.");
			System.exit(0);
			
		}
	}
	
	private void emptyCheck() { // 빈폴더 확인
		File[] clear = f.listFiles();
		
		if ( clear.length != 0 ) {
			System.out.println("폴더를 비워주세요.(빈 폴더만 삭제가능합니다.)");
			System.exit(0);
		}	
	}
	
	private void deleteCheck() {
		if (check == true) {
			System.out.println("삭제되었습니다.");
		}else {
			System.out.println("실패했습니다. 다시 확인해주세요.");
		}
	}
	
}