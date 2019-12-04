package DI_Annotation_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;

public class MonitorViewer {
	private Recoder recoder;

	public Recoder getRecoder() {
		return recoder;
	}
	
	@Autowired //by type : 현재 컨테이너 안에서 recoder 타입을 찾아서 있으면 injection
	public void setRecoder(Recoder recoder) {
		this.recoder = recoder;
	}
	
}
