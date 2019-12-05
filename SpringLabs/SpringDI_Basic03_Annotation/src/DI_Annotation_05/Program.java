package DI_Annotation_05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigContext.class);
																			//meta 정보이기 떄문에 컴파일 된 class
		
		User user = context.getBean("user",User.class);
								//기존 ID 작성 부분에 함수명
		user.userMethod();

		User2 user2 = context.getBean("user2",User2.class);
		user2.userMethod2();
	}

}
