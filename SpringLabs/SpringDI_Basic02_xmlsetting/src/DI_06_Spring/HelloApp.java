package DI_06_Spring;

import java.io.ObjectInputStream.GetField;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		//insert 작업
		//MySqlArticleDao articledao = new MySqlArticleDao();
		//OracleArticleDao articledao = new OracleArticleDao();
		
		//ArticleService articleservice = new ArticleService(articledao);
		//Article article = new Article();
		
		//articleservice.write(article);
		//함수의 실행은 Main 에서 그냥..
		
		//Spring
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_06_Spring/DI06.xml");//타입변환을 하지 않는 컨테이너 //패키지안에 xml
		
		Article article = context.getBean("article",Article.class);
		ArticleService articleservice = context.getBean("articleservice",ArticleService.class);
		
		articleservice.write(article);
	}
}
