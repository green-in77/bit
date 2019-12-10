package Aop_anno2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

	@Bean
	public MyAspect myAspect() {
		return new MyAspect();
	}
	
	@Bean
	public Coffe coffe() {
		return new Coffe();
	}
	
	@Bean
	public Tea tea() {
		return new Tea();
	}

}