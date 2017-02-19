package com.bjsxt.learnServlet;

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

public class ImgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filePath = new String(request.getParameter("filePath").getBytes("iso8859-1"),"utf-8");
		String requestType = request.getParameter("requestType");
		if(requestType!=null){
			String imgName = filePath.substring(filePath.lastIndexOf("/")+1);//也可以
			System.out.println("下载中的imgName:"+imgName);
			response.setHeader("Content-Disposition", "attachment;filename="+new String(imgName.getBytes("utf-8"),"iso8859-1"));
		}
		ServletContext context = this.getServletContext();
		OutputStream out=response.getOutputStream();
		System.out.println("imgServlet的："+filePath);
		InputStream fis=context.getResourceAsStream(filePath);
		int temp=0;
		byte[] b=new byte[8192];
		while((temp=fis.read(b))!=-1){
			out.write(b, 0, temp);
		}
		out.flush();
		out.close();
		fis.close();
	}

}