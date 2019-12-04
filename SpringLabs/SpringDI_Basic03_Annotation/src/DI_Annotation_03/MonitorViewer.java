package DI_Annotation_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	private Recoder recoder;

	public Recoder getRecoder() {
		return recoder;
	}
	
	//@Autowired(required = true) //기본설정 (무조건 injection)
	@Autowired(required = false) //있으면 injection 없으면 예외처리 없이 실행되게함
	public void setRecoder(Recoder recoder) {
		this.recoder = recoder;
		System.out.println("setter 주입 성공 : " + this.recoder);
	}
	
}
