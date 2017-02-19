package com.cdsxt.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestSession extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		 * 重要：
		 * 	session的中文名叫会话
		 * 	session生成机制：
		 * 		服务器中必须要用request.getSession(),如果请求头里没有带jsessionId,服务器会创建一个新的session对象,
		 * 		如果带上jsessionId,会拿着该jsessionId到服务器找对应的session，如果没有失效，则使用该session，如果已失效，
		 * 		则会创建一个新的session.
		 * 
		 * 
		 *  什么叫一次会话：
		 *  	粗略的说：浏览器打开访问服务器(request.getSession())直到浏览器关闭。
		 *  	详细的说：一次会话，依赖sesssion生成机制。
		 *  
		 *  
		 *  三大作用域：
		 *  	从小到大:
		 *  		request
		 *  			 同一次请求
		 *  		session
		 *  			同一次会话
		 *  		application
		 *  			同一个web项目的servlet共享
		 * */
		//获取session对象
		HttpSession session=request.getSession();
		//作为作用域使用
		session.setAttribute("a", "aaa");
//		session.setMaxInactiveInterval(10) ;
//		String a=(String) session.getAttribute("a");
//		System.out.println(a);
//		session.removeAttribute("a");
//		System.out.println(session.getAttribute("a"));
		
		//测试session作用域范围
//		request.getRequestDispatcher("testSession2").forward(request, response);
//		response.sendRedirect("testSession2");
	}

}
