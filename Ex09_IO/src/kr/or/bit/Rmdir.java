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
		System.out.println("�����Ͻ� ���� : " + f.getAbsolutePath());
		
		routeCheck(); // ��� Ȯ��
		commandCheck(); // ��ɾ�Ȯ��
		emptyCheck(); // ������Ȯ��
		
		check=f.delete(); //�����ϱ�
		deleteCheck(); // �����Ϸ�Ȯ��
		
	}
	
	private void routeCheck() { // ���Ȯ��
		if ( !this.f.exists() || !this.f.isDirectory()) { // ��ΰ� �������� �ʰų�, ������ �ƴϸ�
			System.out.println("��ȿ���� ���� ���丮 �Դϴ�.");
			System.exit(0);
		}
	}
	
	private void commandCheck() { // ��ɾ�Ȯ��
		if ( !(args[1].equals("RMDIR"))) {
			System.out.println("�߸��� ��ɾ� �Դϴ�.");
			System.exit(0);
			
		}
	}
	
	private void emptyCheck() { // ������ Ȯ��
		File[] clear = f.listFiles();
		
		if ( clear.length != 0 ) {
			System.out.println("������ ����ּ���.(�� ������ ���������մϴ�.)");
			System.exit(0);
		}	
	}
	
	private void deleteCheck() {
		if (check == true) {
			System.out.println("�����Ǿ����ϴ�.");
		}else {
			System.out.println("�����߽��ϴ�. �ٽ� Ȯ�����ּ���.");
		}
	}
	
}