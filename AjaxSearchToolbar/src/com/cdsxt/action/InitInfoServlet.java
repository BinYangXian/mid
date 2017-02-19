package com.cdsxt.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public class InitInfoServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		ServletContext context=this.getServletContext();
		String[] initInfo={"a","aab","aac","aaa","abc","bbd","bbq","bbb","ccc","你好","你好行","你不好"};
		context.setAttribute("initInfo", initInfo);
	}
}
