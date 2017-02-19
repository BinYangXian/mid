package com.cdsxt.action;

import java.io.BufferedOutputStream;
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

public class ImgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//向页面输出一张图片
		OutputStream out=response.getOutputStream();
//		File file=new File("d:/cola.jpg");
//		FileInputStream fis=new FileInputStream(file);
//		InputStream fis=this.getServletContext().getResourceAsStream("/bmw.jpg");
		InputStream fis=ImgServlet.class.getResourceAsStream("/yo.jpg");
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
