package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie=new Cookie("book2","c#");
		//使book2  立即失效
		//如何确定唯一一个 Cookie  同键     并且同作用路径 
		cookie.setMaxAge(0);
		cookie.setPath(request.getContextPath()+"/loginPage");
		response.addCookie(cookie);
	}

}
