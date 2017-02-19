package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
//		int i=1/0;
		System.out.println("哎哟，不错哦!ajax好玩儿！");
		//响应数据给ajax程序
		PrintWriter pw=response.getWriter();
		pw.write("this is server msg!!!");
		pw.flush();
		pw.close();
	}

}
