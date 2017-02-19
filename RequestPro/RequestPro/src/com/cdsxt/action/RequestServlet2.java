package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取表单出入的用户名和密码
		//当参数时  参数名=  没有写值的时候是空字符串
		//当参数没有参数名的时候 直接接受结果是null
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		System.out.println("用户名:"+uname);
		System.out.println("密码:"+pwd);
		//只能获取到 多个值的第一个的值
//		String fav=request.getParameter("fav");
//		System.out.println("爱好:"+fav);
		
		//获取多个值的专用方法 一般用于  多选框
		String favs[]=request.getParameterValues("fav");
		System.out.println(Arrays.toString(favs));
		System.out.println("---------------------------------");
		
		Enumeration<String> enums=request.getParameterNames();
		while(enums.hasMoreElements()){
			String name=enums.nextElement();
			if("fav".equals(name)){
				String favss[]=request.getParameterValues(name);
				System.out.println(name+"----"+Arrays.toString(favss));
			}else{
				String value=request.getParameter(name);
				System.out.println(name+"----"+value);
			}
		}
		//模拟登陆效果
		/*if(("zhangsan".equals(uname)&&"123456".equals(pwd))||("lisi".equals(uname)&&"123456".equals(pwd))){
			System.out.println("欢迎"+uname+"  登陆本系统!!");
		}else{
			System.out.println("用户名或密码错误");
		}*/
	}
}
