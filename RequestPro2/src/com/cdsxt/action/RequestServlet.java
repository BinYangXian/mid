package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//往request作用域中存值
		request.setAttribute("a", "aaa");
		request.setAttribute("b", "bbb");
		//从request作用域中取值
		String a=(String) request.getAttribute("a");
		String b=(String) request.getAttribute("b");
		System.out.println("a的值:"+a);
		System.out.println("b的值:"+b);
		System.out.println("---------------------------------------");
		//移除request作用域中的值
//		request.removeAttribute("a");
//		String newA=(String) request.getAttribute("a");
//		System.out.println("a:"+newA);
		//获取request作用域中所有键的集合
		Enumeration<String> enums=request.getAttributeNames();
		while(enums.hasMoreElements()){
			String name=enums.nextElement();
			System.out.println(name+"---"+request.getAttribute(name));
		}
	}

}
