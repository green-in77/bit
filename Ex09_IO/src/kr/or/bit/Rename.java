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
				System.out.println("�����̸� ����Ϸ�");
			}
			
		}else {
			System.out.println("�������� �ʴ� �����Դϴ�");
		}
		
	}
}
