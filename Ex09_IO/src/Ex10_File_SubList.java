import java.io.File;
import java.util.ArrayList;

public class Ex10_File_SubList {
	static int totalfiles=0;
	static int totaldirs=0;
	
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("사용법 : java [실행파일명] [경로명]");
			System.out.println("예시 : java Ex10_File_SubList C:\\Temp");
			System.exit(0); //프로세스 종료
		}
		
		File f = new File(args[0]); // new File("C:\\Temp");
		if (!f.exists() || !f.isDirectory()) { // 존재하지 않거나 디렉토리가 아니라면
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		//정상적인 경로...
		printFileList(f);
		System.out.println("누적총 파일수 : " + totalfiles);
		System.out.println("누적총 폴더수 : " + totaldirs);
	}
	
	static void printFileList(File dir) {
		System.out.println("[Full Path : " + dir.getAbsolutePath()+"]"); //절대경로
		
		ArrayList<Integer> subdir = new ArrayList<Integer>();
		File[] files = dir.listFiles(); //parameter로 받은 경로의 리스트를 파일배열로 저장
		
		for (int i = 0; i < files.length ; i++) {
			String filename = files[i].getName(); // 파일명 또는 폴더명
			
			if (files[i].isDirectory()) { // 디렉토리니????
				filename = "<DIR> [" + filename + "]";
				subdir.add(i); // arraylist 에 디렉토리 방의 인덱스가 담김
			} else {
				filename = filename + " / " + files[i].length() + "Byte"; 
			}
			System.out.println("    " + filename);
		}
		int dirnum = subdir.size(); // 현재 경로의 디렉토리의 갯수
		int filenum = files.length - dirnum; // 총배열의 갯수 - 디렉토리의 갯수 = 현재 경로의 파일의 갯수
		
		//누적값 :  
		totaldirs += dirnum; // 총 디렉토리의 갯수 ( 누적 폴더 갯수 )
		totalfiles += filenum; // 총 파일의 갯수 ( 누적 파일 갯수 )
		
		System.out.println("[Current dirNum] : " + dirnum);
		System.out.println("[Current filenum] : " + filenum);
		System.out.println("*****************************************************");
		
		//Point★★★★★★
		// 경로안의 폴더 -> 안의 폴더 -> 안의 폴더 로 들어가는 것.
		// 재귀함수
		for (int j = 0 ; j < subdir.size() ; j++ ) { //디렉토리의 갯수만큼
			int index = subdir.get(j); // index에 디렉토리의 방 번호를 가져와서
			printFileList(files[index]); //경로의 폴더를 새 경로로 지정해서 실행.
		}
		
	}

}
