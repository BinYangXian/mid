package com.cdsxt.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.cdsxt.vo.MyRule;

public class InitServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		ServletContext context=this.getServletContext();
		List<MyRule> ruleList=new ArrayList<MyRule>();
		//public MyRule(int id, String rule, String summary, String param, String info)
		for(int i=1;i<=10;i++){
			ruleList.add(new MyRule(i, "计算规则"+i, "摘要"+i, "参数"+i, "说明"+i));
		}
		context.setAttribute("ruleList", ruleList);
	}

}