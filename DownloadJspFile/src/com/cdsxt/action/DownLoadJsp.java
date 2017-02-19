package com.cdsxt.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownLoadJsp extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestFilePath=request.getRequestURI();
//		String requestFileName=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		ServletContext context=this.getServletContext();
		System.out.println(requestFilePath.replace(request.getContextPath(), ""));
		InputStream is=context.getResourceAsStream(requestFilePath.replace(request.getContextPath(), ""));
		if(is!=null){
			//如果是下载 添加一个响应头
			response.setHeader("content-disposition", "attachment;fileName="+requestFilePath.substring(requestFilePath.lastIndexOf("/")+1));
			
			OutputStream out=response.getOutputStream();
//			Bufferedw
			byte[] b=new byte[8*1024];
			int temp=0;
			while((temp=is.read(b))!=-1){
				out.write(b, 0, temp);
			}
			out.flush();
			out.close();
			is.close();
		}
	}

}