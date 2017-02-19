package com.cdsxt.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SrcServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context=this.getServletContext();
		//getResourceAsStream 将资源以流的方式 读入    context的所有方法  写或不写/都是代表WebRoot 不写有可能会报错
//		InputStream in=context.getResourceAsStream("aaa/girl1.jpg");
//		InputStream in=context.getResourceAsStream("/META-INF/stupidCat.jpg");
		//类名.class  获取该类的反射模板
		
		//  /  代表src  绝对路径
//		InputStream in=SrcServlet.class.getResourceAsStream("/cat.jpg");
//		InputStream in=SrcServlet.class.getResourceAsStream("/com/cdsxt/action/yo.jpg");
		
		//相对路径  相对路径位置 根据反射模板为自身位置
//		InputStream in=SrcServlet.class.getResourceAsStream("yo.jpg");
//		InputStream in=SrcServlet.class.getResourceAsStream("../girl.jpg");
//		InputStream in=SrcServlet.class.getResourceAsStream("../../../ccc/zxx.jpg");
		
		
		//通过类加载器去获取资源       通过类加载器获取资源的方式  相对路径和绝对路径都是代表src
//		InputStream in=SrcServlet.class.getClassLoader().getResourceAsStream("/cat.jpg");
		InputStream in=SrcServlet.class.getClassLoader().getResourceAsStream("cat.jpg");
		
		OutputStream out=response.getOutputStream();
		int temp=0;
		byte[] b=new byte[8192];
		while((temp=in.read(b))!=-1){
			out.write(b, 0, temp);
		}
		out.flush();
		out.close();
		in.close();

	}
}
