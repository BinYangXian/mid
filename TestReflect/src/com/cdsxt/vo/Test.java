package com.cdsxt.vo;

import java.lang.reflect.Field;

public class Test {
	public static void main(String[] args) throws Exception{
//		getClazz();
//		getObject();
//		getFields();
		getField();
	}
	//获取反射模板
	public static void getClazz() throws Exception{
		
		//类.class
//			Class clazz=TestBean.class;
		//Class.forName("包名+类名");  只有这种方式存在异常
//			Class clazz=Class.forName("com.cdsxt.vo.TestBean");
		//对象.getClass()
		
		TestBean testBean=new TestBean();
		Class clazz=testBean.getClass();
		//getSimpleName()   类名
		String simpleName=clazz.getSimpleName();
		System.out.println(simpleName);
		//getName()  包名+类名
		String name=clazz.getName();
		System.out.println(name);
		//getPackage()  获取所在包对象
		Package pack=clazz.getPackage();
		System.out.println(pack.getName());
		
	}
	
	//测试通过反射模板获取对象
	public static void getObject()throws Exception{
		Class clazz=TestBean.class;
		//创建对象    本质就是调用 new 类()
		Object obj=clazz.newInstance();
		System.out.println(obj instanceof TestBean);
		
	}
	
	//测试反射模板获取多个属性
	public static void getFields() throws Exception{
		Class clazz=Class.forName("com.cdsxt.vo.TestBean");
		//getFields() 获取的是公共的属性
//		Field[] fields=clazz.getFields();
		Field[] fields=clazz.getDeclaredFields();
		for(Field field:fields){
			//获取属性名
			String name=field.getName();
			System.out.println(name);
			//获取属性的类型
//			Class fieldClazz=field.getType();
//			System.out.println(fieldClazz.getSimpleName());
		}
	}
	//测试反射模板获取单个属性
	public static void getField() throws Exception{
		Class<TestBean> clazz=TestBean.class;
//		Field gender=clazz.getField("gender");
//		System.out.println(gender.getType());
//		Field id=clazz.getField("id");    //getField 只能获取公共修饰的
//		Field id=clazz.getDeclaredField("id");
//		System.out.println(id.getType());
		//给公共的非静态的属性设值
//		Field a=clazz.getField("a");
//		TestBean testBean=clazz.newInstance();
//		a.set(testBean, "abc");  //   testBean.a="abc"
//		String value=(String)a.get(testBean);//testBean.a
//		System.out.println(value);
		
		//给静态的属性设值的时候    object  尽量传null   传对象会被忽略
		Field a=clazz.getField("gender");
		a.set(null, 1);  
//		System.out.println(a.get(null));
		
//		//测试给私有属性设置值
//		TestBean testBean=new TestBean();
		TestBean testBean=clazz.newInstance();
		Field id=clazz.getDeclaredField("id");
		//取消底层安全性监测   如果使用这种方式  用完之后注意关闭
		id.setAccessible(true);
		id.set(testBean, 9527);
		System.out.println(id.get(testBean));
		id.setAccessible(false);		
	}
}
