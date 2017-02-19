package com.cdsxt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//下载分为两步    1.设置下载响应头   2.将资源以流的方式输出
		//响应头Content-Disposition attachment; filename="文件名"
		String fileName=new String("四级英语.doc".getBytes("utf-8"),"iso8859-1");
		response.setHeader("Content-Disposition", "attachment; filename="+fileName);
		//将资源以流的方式输出 
		OutputStream out=response.getOutputStream();
		InputStream in=new FileInputStream(new File("d:/sjyy.doc"));
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
