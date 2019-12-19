package kr.or.bit;

import java.io.File;

public class Delete {
	private String[] args;
	private File f;
	private boolean check;
	
	public Delete (String[] args) {
		this.args = args;
		f = new File(args[0]+"\\"+args[2]);
	}
	
	public void delete() {
		System.out.println("삭제하실 파일 : " + f.getAbsolutePath());
		
		routeCheck(); // 경로 확인
		commandCheck(); // 명령어확인
		
		check=f.delete(); //삭제하기
		deleteCheck(); // 삭제완료확인
		
	}
	
	private void routeCheck() { // 경로확인
		if ( !this.f.exists() || !this.f.isFile()) { // 경로가 존재하지 않거나, 파일 아니면
			System.out.println("유효하지 않은 파일 입니다.");
			System.exit(0);
		}
	}
	
	private void commandCheck() { // 명령어확인
		if ( !(args[1].equals("DEL"))) {
			System.out.println("잘못된 명령어 입니다.");
			System.exit(0);
		}
	}

	
	private void deleteCheck() { // 삭제확인
		if (check == true) {
			System.out.println("삭제되었습니다.");
		}else {
			System.out.println("실패했습니다. 다시 확인해주세요.");
		}
	}
}
