<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page contentType="image/jpeg; charset=utf-8"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%
	String url=request.getParameter("url");
	ServletContext context=this.getServletContext();
	OutputStream os=response.getOutputStream();
	//InputStream in=context.getResourceAsStream("/img/dog.jpg");
	String path=application.getRealPath(url);
	File file=new File(path);
	InputStream in=null;
	try{
		in=new FileInputStream(file);
	}catch(Exception e){
		//找到默认图片
		in=application.getResourceAsStream("/img/yo.jpg");
	}
	int temp=0;
	byte[] b=new byte[8192];
	while((temp=in.read(b))!=-1){
		os.write(b, 0, temp);
	}
	os.flush();
	os.close();
	in.close();
	//下面两句代码   解决 getWriter和getOutputStream的冲突问题。 记下来即可
	out.clear();
	out = pageContext.pushBody();
%>