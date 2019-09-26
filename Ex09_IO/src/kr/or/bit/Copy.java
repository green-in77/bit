package kr.or.bit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
	private String[] args;
	private File f;
	private FileInputStream fileinput;
	private BufferedInputStream bfileinput;
	private FileOutputStream fileoutput;
	private BufferedOutputStream bfileoutput;
	private String orifile;
	private String tagetfile;
	
	public Copy (String[] args) {
		this.args = args;
		f = new File(args[0]);
	}
	
	public void Copy() {
		System.out.println(f.toString());
		routeCheck();
		
		if (args[1].equals("COPY")) {
			this.orifile = args[0]+"\\"+args[2]; // 복사할 파일
			this.tagetfile = args[0]+"\\"+args[3]; //새파일 이름
		}

		try {
			fileinput = new FileInputStream(orifile);
			bfileinput = new BufferedInputStream(fileinput);

			fileoutput = new FileOutputStream(tagetfile);
			bfileoutput = new BufferedOutputStream(fileoutput);

			int data = 0;
			while ((data = fileinput.read()) != -1) {
				bfileoutput.write(data);
			}
			bfileoutput.flush();
			System.out.println("파일이 복사되었습니다.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
			try {
				bfileoutput.close();
				fileoutput.close();
				bfileinput.close();
				fileinput.close();
				
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
	
	private void routeCheck() {
		if (!f.exists()) {
			System.out.println("유효하지 않은 디렉토리 입니다.");
			System.exit(0);
		}
	}
	
}