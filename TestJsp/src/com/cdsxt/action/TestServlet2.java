package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// print的底层就是在调用  write  方法    只是print处理了 null的情况
		PrintWriter pw=response.getWriter();
		String str=null;
		pw.write(str);
		pw.print(str);
//		pw.println(str);
		pw.flush();
		pw.close();
	}

}
