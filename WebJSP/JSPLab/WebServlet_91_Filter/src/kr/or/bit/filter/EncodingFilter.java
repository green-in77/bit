package kr.or.bit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
//@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {

	//변수만들기
	private String encoding;
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
//		최초 요청 시 컴파일 시 한번만 실행되는 함수
//		web.xml
//	  	<init-param>
//	  		<param-name>encoding</param-name>
//	  		<param-value>UTF-8</param-value>
//	  	</init-param>
		this.encoding = fConfig.getInitParameter("encoding"); //key => value : UTF-8
		System.out.println("Filter init : " + this.encoding);

	}

	
    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//doFilter 이전은 request
		//요청이 왔을때 구현되는 보조(공통)관심
		if(request.getCharacterEncoding() == null) {
			System.out.println("before : " + request.getCharacterEncoding());
			
			request.setCharacterEncoding(this.encoding); //한줄만...
			
			System.out.println("after : " + request.getCharacterEncoding());
		}
		chain.doFilter(request, response);
		//doFilter 이후는 response
		//응답할때 처리되는 코드
		System.out.println("response 응답처리");
	}

	
}
