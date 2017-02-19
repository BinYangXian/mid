package com.cdsxt.vo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test2 {
	public static void main(String[] args) {
//		testMethods();
//		testMethod();
//		getConstructors();
		getConstructor();
	}
	//通过反射模板获取多个方法
	public static void testMethods(){
		Class clazz=TestBean.class;
		//getMethods  获取该模板和其超类上的所有公共的方法
//		Method[] methods= clazz.getMethods();
		Method[] methods=clazz.getDeclaredMethods();
		for(Method method:methods){
			//获取方法名
			String name=method.getName();
			System.out.println(name);
		}
	}
	//通过反射模板获取单个方法
	public static void testMethod(){
		try {
			Class clazz=TestBean.class;
			TestBean testBean=(TestBean)clazz.newInstance();
			
			//调用无参方法
//			Method test=clazz.getMethod("test");
//			//方法对象调用
//			test.invoke(testBean);
			
			//调用有参方法
			Method add=clazz.getMethod("add",int.class,int.class);
			//方法对象  获取形参列表的反射模板数组
			/*Class[] types=add.getParameterTypes();
			for(Class type:types){
				System.out.println(type.getSimpleName());
			}*/
			
			//invoke返回的结果是方法返回的结果
//			int result=(Integer)add.invoke(testBean, 250,250);
//			System.out.println(result);
			
			//测试静态方法  静态方法尽量传null
//			Method test2=clazz.getMethod("test2");
//			test2.invoke(null);
			
			//测试私有方法
			Method test3=clazz.getDeclaredMethod("test3", String.class);
			//取消安全性监测
			test3.setAccessible(true);
			String result2=(String) test3.invoke(testBean, "张学友");
			test3.setAccessible(false);
			System.out.println(result2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取多个构造器
	public static void getConstructors(){
		Class clazz=TestBean.class;
//		Constructor[] constructors=clazz.getConstructors();
		Constructor[] constructors=clazz.getDeclaredConstructors();
		System.out.println(constructors.length);
	}
	//获取单个构造器
	public static void getConstructor(){
		try {
			Class clazz=TestBean.class;
			//获取无参公共的构造器
//			Constructor constructor=clazz.getConstructor();
//			相当于     clazz.newInstance();  也相当于   new TestBean();
//			Object obj=constructor.newInstance();
//			System.out.println(obj instanceof TestBean);
			
			//获取公共的有参构造器
//			Constructor constructor=clazz.getConstructor(int.class,String.class);
//			TestBean testBean=(TestBean) constructor.newInstance(888,"发发发");
//			System.out.println(testBean.getId());
//			System.out.println(testBean.getName());
			
			//获取私有的有参构造器
			//private TestBean(String email, boolean handsome, String a)
			Constructor constructor=clazz.getDeclaredConstructor(String.class,boolean.class,String.class);
			constructor.setAccessible(true);
			TestBean testBean=(TestBean) constructor.newInstance("88@qq.com",false,"aaa");
			constructor.setAccessible(false);
			System.out.println(testBean.getEmail());
			System.out.println(testBean.isHandsome());
			System.out.println(testBean.getA());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
