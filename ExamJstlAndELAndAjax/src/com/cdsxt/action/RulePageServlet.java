package com.cdsxt.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsxt.vo.MyRule;
import com.google.gson.Gson;
public class RulePageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("content-type", "text/html;charset=utf-8");
		String saveTag=request.getParameter("saveTag");
		System.out.println("saveTag="+saveTag);
		ServletContext context=this.getServletContext();
		List<MyRule> list=(List<MyRule>) context.getAttribute("ruleList");
		System.out.println("list="+list);
		if("change".equals(saveTag)){
			String jsonData=request.getParameter("chaData");
			System.out.println(jsonData);
			if(!jsonData.isEmpty()){
				MyRule oneRuler=new Gson().fromJson(jsonData, MyRule.class);
				int i;
				for ( i = 0; i < list.size(); i++) {
					if(oneRuler.getId()==list.get(i).getId()){
						list.set(i, oneRuler);
					}
				}
				if(i==list.size()){
					list.add(oneRuler);
				}
			}
		}else if("del".equals(saveTag)){
			delData(request, saveTag, list);
		}
	}

	private void delData(HttpServletRequest request, String saveTag,
			List<MyRule> list) {
		String delData=request.getParameter("delData");
		System.out.println("delData="+delData);
		List<Integer> tempDelList=new ArrayList<Integer>();
		Pattern pt=Pattern.compile("\\d+");
		Matcher mt=pt.matcher(delData);
		    //c)通过匹配器检查数据
		    while(mt.find()){
		    	tempDelList.add(Integer.parseInt(mt.group()));
		    }
		List<MyRule> delList=new ArrayList<MyRule>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < tempDelList.size(); j++) {
				if(tempDelList.get(j)==list.get(i).getId()){
						delList.add(list.get(i));
					break;
				}
			}
		}
		//最终删除所有选中的数据
		for (int i = 0; i < delList.size(); i++) {
			list.remove(delList.get(i));
		}
	}

}
