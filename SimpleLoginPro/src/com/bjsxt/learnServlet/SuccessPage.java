package com.bjsxt.learnServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		String uname = request.getParameter("uname");
		System.out.println("用户提交表单中的uname："+uname);
		ServletContext context = this.getServletContext();
		Set<String> resourcePaths = context.getResourcePaths("/"+new String(uname.getBytes("iso8859-1"),"utf-8"));
		String iconPath = (String) context.getAttribute("iconPath");
		if(iconPath==null){
			iconPath="";
		}
			System.out.println("iconPath="+iconPath);
		pw.write("<h1>欢迎:<img src="+iconPath+" width=\"50\" height=\"50\" >"
		+uname+",使用本系统!</h1></br><a href=\"clearCookies\">切换用户<a/></br>" +
		" <form action=\"uploadServlet\" method=\"post\" enctype=\"multipart/form-data\">"+
		"<input type=\"hidden\" name='uname' value='"+uname+"'/>"+
				"上传头像：<input type='file'  name='photo' />"+
				"<input type=\"submit\" value=\"提交\" /></form><hr/>");
		for (String path : resourcePaths) {
			System.out.println("拼接页面中的超链接中的参数的filePath="+path);
			pw.write("<a href='imgServlet?filePath="+path+"' >"+path.substring(path.lastIndexOf("/")+1)+
					"</a>&nbsp;&nbsp;<a href='imgServlet?requestType=down&filePath="+path+"'>下载</a></br>");
		}
	}
}

