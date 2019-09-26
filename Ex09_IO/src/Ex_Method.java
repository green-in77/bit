import kr.or.bit.Copy;
import kr.or.bit.Delete;
import kr.or.bit.Dir;
import kr.or.bit.Rename;
import kr.or.bit.Rmdir;

//RMDIR          ���͸��� �����մϴ�.
// [��θ�] RMDIR [���丮��]

public class Ex_Method {
	public static void main(String[] args) {
		
		if(!(args.length == 2) && !(args.length ==3) && !(args.length ==4)) {  
			System.out.println("���� : java [�������ϸ�] [���] DIR");
			System.out.println("���� : java Ex_Method C:\\IOTemp DIR");
			System.out.println();
			
			System.out.println("���� : java [�������ϸ�] [���] [RENAME] [���������ϸ�] [���������ϸ�]");
			System.out.println("���� : java Ex_Method C:\\IOTemp RENAME a.txt cc.txt");
			System.out.println();
			
			System.out.println("���� : java [�������ϸ�] [���] [COPY] [����������]  [�������ϸ�]");
			System.out.println("���� : java Ex_Method C:\\IOTemp COPY a.txt �������̸�");
			System.out.println();
			
			System.out.println("���� : java [���ϸ�] [���] [DEL] [���������ϸ�]");
			System.out.println("���� : java Ex_Method C:\\IOTemp DEL 2.jpg");
			System.out.println();
			
			System.out.println("���� : java [���ϸ�] [���] [RMDIR] [������������]");
			System.out.println("���� : java Ex_Method C:\\IOTemp RMDIR Data");
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
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}
		
	}
}
