package com.cdsxt.test;

import java.util.ArrayList;
import java.util.List;

import com.cdsxt.vo.Person;
import com.google.gson.Gson;

public class TestGson {
	public static void main(String[] args) {
		//页面传入的json字符串转化成对象    用的比较少
//		String str1="{'id':'1','name':'zhangsan','age':'20'}";
//		//使用Gson
//		Gson gson=new Gson();
//		Person person=gson.fromJson(str1, Person.class);
//		System.out.println(person.getName());
		
		
		//服务器往页面输出json字符串或数组字符串
//		User user=new User(3, "王五", new String[]{"ball","playball"},new Address("四川","成都"));
//		
//		Gson gson=new Gson();
//		String userJson=gson.toJson(user);
//		System.out.println(userJson);
		
		
		List<Person> perList=new ArrayList<Person>();
		perList.add(new Person(1,"张三",20));
		perList.add(new Person(3,"张",10));
		perList.add(new Person(4,"三",30));
		
		Gson gson=new Gson();
		String listJson=gson.toJson(perList);
		System.out.println(listJson);
	}
}
