import java.util.Scanner;

public class Flow {
	static Scanner sc = new Scanner(System.in);
	
	static int unit = 10000; //ȭ�����
	static int num; // ȭ��ż�
	static int sw; // ����Ī����, ȭ���� ���� ������ ����
	
	static void cal() {
		System.out.printf("����� �ݾ��� �Է��ϼ��� : ");
		int money = Integer.parseInt(sc.nextLine()); // �Է¹޴� �ݾ�
		
		do { // ���ѷ���
			num = (int)(money/unit);  
			
			System.out.println(unit +" " + num + "��");
			if (unit >1 ) {
				money = money - (unit * num);
				if ( sw==0 ) {
					unit = unit /2;
					sw=1;
				} else {
					unit = unit/5;
					sw=0;
				}
			
			}else {
				break;
			}
		}while(true);
		
	}

	public static void main(String[] args) {
		cal();
	}

}
