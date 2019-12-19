package kr.or.bit;

import java.io.File;

public class Rename {
	private String[] args;
	public Rename(String[] args) {
		this.args = args;
	}
	
	public void reName() {
		File oldOne = new File(args[0] + "\\" + args[2]);
		File newONe = new File(args[0] + "\\" + args[3]);
		
		System.out.println(oldOne.getName());
		System.out.println(newONe.getName());
		
		if(oldOne.exists()) {
			if(!oldOne.renameTo(newONe)) {
			
			}else {
				System.out.println("파일이름 변경완료");
			}
			
		}else {
			System.out.println("존재하지 않는 파일입니다");
		}
		
	}
}
