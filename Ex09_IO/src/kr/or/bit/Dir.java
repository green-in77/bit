package kr.or.bit;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Dir {
	private String path;
	private int numDir;
	private int numFiles;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
	public void infoDir(String path) {
		File f= new File(path);
		System.out.println(f.getAbsolutePath());
		if(!f.exists()||!f.isDirectory()) {
			System.out.println("폴더가 아닙니다");
			System.exit(0);
		}
		File[] files = f.listFiles();
		ArrayList<Integer> dirs = new ArrayList<Integer>();
		for(int i=0; i<files.length;i++) {
			System.out.print(sdf.format(files[i].lastModified())+"\t");
			
			if(files[i].isDirectory()) { 
				System.out.print("<DIR>");
				dirs.add(i);
				numDir+=1;
			}
			else {
				System.out.print(files[i].length()+"byte\t");
				System.out.print(files[i].getName());
				numFiles+=1;
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("총 파일 수 : " + numFiles);
		System.out.println("총 디렉토리 수 : " + numDir);
		for(int i=0; i<dirs.size();i++) {
			infoDir(files[dirs.get(i)].getAbsolutePath());
		}
		
		
		
		
		
		
	}
	
	
	
	
}
