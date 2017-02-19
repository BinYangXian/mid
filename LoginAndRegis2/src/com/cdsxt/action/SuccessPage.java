package com.cdsxt.action;

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
		ServletContext context=this.getServletContext();
		String uname=request.getParameter("uname");
		PrintWriter pw=response.getWriter();
		response.setHeader("content-type", "text/html;charset=utf-8");
		pw.write("<h1>欢迎:"+uname+",使用本系统!</h1>");
		pw.write("<hr/>");
		Set<String> imgs=context.getResourcePaths("/"+uname);
		for(String img:imgs){
			//    /lisi/girl1.jpg     /lisi/a/b/c/girl1.jpg
//			String imgName=img.replaceAll("/"+uname+"/", "");
			
			/*String[] temp=img.split("/");
			int idx=temp.length-1;
			String imgName=temp[idx];
			System.out.println(imgName);*/
			
			String imgName=img.substring(img.lastIndexOf("/")+1);
			pw.write("<a href='downOrShowServlet?mark=show&path="+img+"'>"+imgName+"</a>&nbsp;&nbsp;&nbsp;&nbsp;");
			pw.write("<a href='downOrShowServlet?mark=down&path="+img+"'>下载</a><br/>");
		}
		pw.flush();
		pw.close();
	}
}
