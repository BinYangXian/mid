package com.cdsxt.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

public class Test {
	public void test(PageContext context){
		HttpServletRequest request=(HttpServletRequest) context.getRequest();
		String a=request.getParameter("a");
		System.out.println(a);
	}
}
