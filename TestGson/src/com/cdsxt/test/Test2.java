package com.cdsxt.test;

import com.cdsxt.vo.Person;

public class Test2 {
	public static void main(String[] args) {
		//往页面输出json字符串
		Person person=new Person(3,"李四",28);
		String jsonStr="{'id':"+person.getId()+",'name':'"+person.getName()+"','age':"+person.getAge()+"}";
		System.out.println(jsonStr);
	}
}
