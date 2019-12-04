package DI_Annotation_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	private Recoder recoder;

	public Recoder getRecoder() {
		return recoder;
	}
	
	@Autowired //by type : 현재 컨테이너 안에서 recoder 타입을 찾아서 있으면 injection
	@Qualifier("recorder_1") //<qualifier value="recorder_1"></qualifier>
	public void setRecoder(Recoder recoder) {
		this.recoder = recoder;
		System.out.println("setter 주입 성공 : " + this.recoder);
	}
	
	//일반함수
	@Autowired
	@Qualifier("recorder_2") //<qualifier value="recorder_2"></qualifier>
	public void Gmethod(Recoder rec) {
		System.out.println("Gmethod(rec) : " + rec);
	} 
	
}
