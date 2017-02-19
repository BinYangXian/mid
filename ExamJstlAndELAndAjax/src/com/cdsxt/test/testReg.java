package com.cdsxt.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testReg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String delData="[2,3,45456,345]";
		Pattern pt=Pattern.compile("\\d+");
		Matcher mt=pt.matcher(delData);
		    //c)通过匹配器检查数据
		    while(mt.find()){
		    	System.out.println("有删除的id："+mt.group());
		    }

	}

}
