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
		System.out.println("�����Ͻ� ���� : " + f.getAbsolutePath());
		
		routeCheck(); // ��� Ȯ��
		commandCheck(); // ��ɾ�Ȯ��
		
		check=f.delete(); //�����ϱ�
		deleteCheck(); // �����Ϸ�Ȯ��
		
	}
	
	private void routeCheck() { // ���Ȯ��
		if ( !this.f.exists() || !this.f.isFile()) { // ��ΰ� �������� �ʰų�, ���� �ƴϸ�
			System.out.println("��ȿ���� ���� ���� �Դϴ�.");
			System.exit(0);
		}
	}
	
	private void commandCheck() { // ��ɾ�Ȯ��
		if ( !(args[1].equals("DEL"))) {
			System.out.println("�߸��� ��ɾ� �Դϴ�.");
			System.exit(0);
		}
	}

	
	private void deleteCheck() { // ����Ȯ��
		if (check == true) {
			System.out.println("�����Ǿ����ϴ�.");
		}else {
			System.out.println("�����߽��ϴ�. �ٽ� Ȯ�����ּ���.");
		}
	}
}
