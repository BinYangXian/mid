package com.bjsxt.learnServlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
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
			String uname=null;
			FileItem fileItem=null;
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
						uname=value;
					}else if("pwd".equals(fieldName)){
						System.out.println("密码:"+value);
					}
				}else{
					//文件     
					//item.getName();获取的是文件名
					/*String name=item.getName();
					System.out.println(name);*/
					//获取文件的输入流(原始方法)
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
					/*fileItem.write(new File("e:/"+new Date().getTime()+name));*/
					fileItem=item;
				}
			}
			if(fileItem!=null&&uname!=null){
				String name=fileItem.getName();
				System.out.println(name);
				ServletContext context = this.getServletContext();
				String resourcePath = context.getRealPath("/"+new String(uname.getBytes("iso8859-1"),"utf-8"));
				System.out.println("user的resourcePath="+resourcePath);
				String iconPath=resourcePath+File.separator+new Date().getTime()+name;
				fileItem.write(new File(iconPath));
				//存入servletContext,键是用户名，值是   用户对象(uname,pwd,path(图片路径)),前两者在UserServlet中已存
				servletContext.setAttribute("iconPath", iconPath);
				request.getRequestDispatcher("successPage?uname="+uname).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
