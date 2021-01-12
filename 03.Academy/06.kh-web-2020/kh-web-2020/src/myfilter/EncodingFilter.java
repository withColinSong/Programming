package myfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


@WebFilter(urlPatterns = "/filter.do", 
		   initParams = {@WebInitParam(name="encoding", value="utf-8")}) //initParams -> 필수 코드가 아니라 옵션 코드이다.

public class EncodingFilter implements Filter{
	FilterConfig config;
	
	
	@Override
	// 1회만 호출한다.  
	public void init(FilterConfig filterConfig) throws ServletException {
		
		//@WebInitParam(name="encoding", value="utf-8") } -> filterConfig
		System.out.println("init() 웹 어플리케이션이 시작되면 처음 한 번만 실행됨.");
		this.config = filterConfig;
	}
	
	@Override
	// 요청 정보가 있을 때 마다 요청 정보의 갯수만큼

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding(config.getInitParameter("encoding")); //initParams getter
		chain.doFilter(request, response); // stack 메모리 LIFO 
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./filter/filter_test.jsp");
		dispatcher.forward(request, response);
		
	
	}
	
	
	@Override
	// 웹 어플리케이션 서버 종료가 되기 전에 실행
	public void destroy() {
		System.out.println("destroy() 웹 어플리케이션 서버가 종료됨.");
	}
}
