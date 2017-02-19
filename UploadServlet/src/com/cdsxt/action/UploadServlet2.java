package com.cdsxt.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");    
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// upload就是解析请求的对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		List<FileItem> items = null;
		try {
			// 解析请求    items   表单域对象的集合
			items=upload.parseRequest(request);
			for(FileItem item:items){
				//判断遍历到的item是否是普通表单域元素  是则为true  不是则为false
				boolean result=item.isFormField();
				if(result){
					//获取表单域的名字(name属性)
					String fieldName=item.getFieldName();
					//这里面处理的是普通表单域
					String value=item.getString("utf-8");//功能就是getParameter()   参数是编码格式
					if("uname".equals(fieldName)){
						System.out.println("用户名:"+value);
					}else if("pwd".equals(fieldName)){
						System.out.println("密码:"+value);
					}
				}else{
					//文件     
					//item.getName();获取的是文件名
					String name=item.getName();
					System.out.println(name);
					//获取文件的输入流
					/*InputStream in=item.getInputStream();
					OutputStream out=new FileOutputStream(new File("d:/"+name));
					byte[] b=new byte[8*1024];
					int temp=0;
					while((temp=in.read(b))!=-1){
						out.write(b, 0, temp);
					}
					out.flush();
					out.close();
					in.close();*/
					item.write(new File("e:/"+new Date().getTime()+name));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
