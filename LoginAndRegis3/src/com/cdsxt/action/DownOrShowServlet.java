package com.cdsxt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownOrShowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context=this.getServletContext();
		//获取是要下载还是要显示
		String mark=request.getParameter("mark");
		String path=request.getParameter("path");
		String imgName=new String(path.substring(path.lastIndexOf("/")+1).getBytes("utf-8"),"iso8859-1");
		//如果是下载 添加一个响应头
		if("down".equals(mark)){
			response.setHeader("content-disposition", "attachment;fileName="+imgName);
		}
		
		//获取资源的绝对路径
//		String realPath=context.getRealPath(path);
		//以流的方式输出
//		InputStream in=new FileInputStream(new File(realPath));
		
		
		InputStream in=context.getResourceAsStream(path);
		OutputStream out=response.getOutputStream();
		byte[] b=new byte[8*1024];
		int temp=0;
		while((temp=in.read(b))!=-1){
			out.write(b, 0, temp);
		}
		out.flush();
		out.close();
		in.close();
	}

}
