package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取servletContext  任何方式获取的servletContext对象都是相同的 因为一个web项目只有一个servletContext
//		ServletContext context1=this.getServletConfig().getServletContext();
//		ServletContext context2=this.getServletContext();
//		System.out.println(context1==context2);
		
		//作为作用域使用和其他作用域一致
		ServletContext context=this.getServletContext();
		context.setAttribute("a", "aaaa");
		context.setAttribute("b", "cccc");
		/*String a=(String) context.getAttribute("a");
		System.out.println(a);
		context.removeAttribute("a");
		System.out.println("a:"+context.getAttribute("a"));
		System.out.println("---------------------------------------");
		Enumeration<String> enums=context.getAttributeNames();
		while(enums.hasMoreElements()){
			String name=enums.nextElement();
			System.out.println(name+"----"+context.getAttribute(name));
		}*/
//		request.getRequestDispatcher("testServlet2").forward(request, response);
//		response.sendRedirect("testServlet2");
	}

}
