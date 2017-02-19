package com.cdsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestFilter2 implements Filter {

	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤器前222222222222222");
		//使请求通过
		chain.doFilter(request, response);
		System.out.println("过滤器后2222222222222222");
	}

	@Override
	public void destroy() {
		System.out.println("过滤器销毁了");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		System.out.println("过滤器初始化了");
	}
	
}
