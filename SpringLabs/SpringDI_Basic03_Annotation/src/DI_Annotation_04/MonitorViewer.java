package DI_Annotation_04;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	private Recoder recoder;

	public Recoder getRecoder() {
		return recoder;
	}
	
	@Resource(name="yy") //같은 타입이 여러개 있어도 name으로 하나를 선택해서 injection
	public void setRecoder(Recoder recoder) {
		this.recoder = recoder;
		System.out.println("setter 주입 성공 : " + this.recoder);
	}
	
}
