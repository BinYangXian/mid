package com.cdsxt.test;

import com.cdsxt.vo.Person;

public class Test {
	public static void main(String[] args) {
		//可能页面传过来的就是json的字符串
		String str1="{'id':'1','name':'zhangsan','age':'20'}";
		Person person=new Person();
		String newStr=str1.replaceAll("[{}']", "");
		String[] strs=newStr.split(",");
		for(String s:strs){
			String[] tempstrs=s.split(":");
			if("id".equals(tempstrs[0])){
				person.setId(Integer.parseInt(tempstrs[1]));
			}else if("name".equals(tempstrs[0])){
				person.setName(tempstrs[1]);
			}else if("age".equals(tempstrs[0])){
				person.setAge(Integer.parseInt(tempstrs[1]));
			}
		}
		System.out.println(person.getId());
		System.out.println(person.getName());
		System.out.println(person.getAge());
	}
}
