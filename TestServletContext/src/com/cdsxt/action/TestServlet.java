package com.cdsxt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context=this.getServletContext();
		/*//获取context-param参数
		String a=context.getInitParameter("a");
		String b=context.getInitParameter("b");
		System.out.println(a);
		System.out.println(b);
		//获取所有context-param键的集合
		context.getInitParameterNames();*/
		
		//servletContext对象获取的资源信息  全部是WebRoot下的   统一加上  /    /代表WebRoot
		//getRealPath  获取资源的运行绝对路径  不是工作空间的绝对路径
//		String realPath=context.getRealPath("/bmw.jpg");
//		InputStream in=new FileInputStream(new File(realPath));
		
		
		/*response.setHeader("content-disposition", "attachment;fileName=zxx.jpg");
		//getResourceAsStream 将资源以流的方式 读入
		InputStream in=context.getResourceAsStream("/zxx.jpg");
		OutputStream out=response.getOutputStream();
		int temp=0;
		byte[] b=new byte[8192];
		while((temp=in.read(b))!=-1){
			out.write(b, 0, temp);
		}
		out.flush();
		out.close();
		in.close();*/
		
		//获取目录下的资源路径
		Set<String> set=context.getResourcePaths("/image");
		for(String s:set){
			System.out.println(s);
		}
	}
}
