package com.cdsxt.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建了cookie对象
		Cookie cookie1=new Cookie("book1","python");
		Cookie cookie2=new Cookie("book2","c#");
		Cookie cookie3=new Cookie("book3","java");
		
		
		//给Cookie设置有效期   设置了有效期的cookie才会被保存在硬盘上
		cookie2.setMaxAge(60*60);
		//只能保存在一个地方   保存在硬盘或是内存中  如果硬盘上的cookie失效了，即使浏览器不关闭，cookie依然不会跟上
//		cookie3.setMaxAge(10);
		
		
		//作用路径           /代表端口号   默认必须要上
		cookie2.setPath(request.getContextPath()+"/loginPage");
		//响应给浏览器
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
	}

}
