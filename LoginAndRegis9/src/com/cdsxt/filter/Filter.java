package com.cdsxt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class Filter implements javax.servlet.Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp=(HttpServletResponse)response;
		resp.setHeader("content-type", "text/html;charset=utf-8");
		String remoteAddr=request.getRemoteAddr();
		if("127.0.0.1".equals(remoteAddr)){
			chain.doFilter(request, response);
		}else{
			response.getWriter().write("食屎吧你");
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
