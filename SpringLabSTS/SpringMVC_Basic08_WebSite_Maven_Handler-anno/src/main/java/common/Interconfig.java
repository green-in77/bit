package common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class Interconfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addInterceptors(InterceptorRegistry regisrty) {
		regisrty.addInterceptor(interceptor()).addPathPatterns("/**");
		regisrty.addInterceptor(loginInter()).addPathPatterns("/customer/*.htm");
	}
	
	@Bean
	public Interceptor interceptor() {
		return new Interceptor();
	}
	
	@Bean
	public LoginInter loginInter() {
		return new LoginInter();
	}
}
