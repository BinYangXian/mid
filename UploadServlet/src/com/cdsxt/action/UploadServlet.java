package com.cdsxt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 当form表单的enctype改为multipart/form-data      getParameter不再好使(只能获取键值对)
		/*String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String photo=request.getParameter("photo");
		System.out.println("uname:"+uname);
		System.out.println("pwd:"+pwd);
		System.out.println("photo:"+photo);*/
		
		//查看request里的所有内容
		InputStream in=request.getInputStream();
		OutputStream out=new FileOutputStream(new File("e:/111.txt"));
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
