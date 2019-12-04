package DI_08_Spring;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		
		//JobExecute jobexecute = new JobExecute("hong", 100); //String, int
		//JobExecute jobexecute = new JobExecute("hong", 100L); //String, long
		//JobExecute jobexecute = new JobExecute("hong", "100"); //String, String
		
		//ArticleDao articleDao = new ArticleDao();
		//jobexecute.setArticleDao(articleDao); //setter 로 주입(참조값)
		//jobexecute.setData(500); //setter 로 주입 (값)
		
		
		//Spring
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_08_Spring/DI08.xml");//타입변환을 하지 않는 컨테이너 //패키지안에 xml
		
		
	}
}
