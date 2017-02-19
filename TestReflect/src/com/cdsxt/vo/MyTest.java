package com.cdsxt.vo;

import java.lang.reflect.Field;

public class MyTest {

	public static void main(String[] args) throws Exception {
//		test();
//		getFields() ;
		getField() ;
	}
	static void test() throws Exception {
		//获取反射模板对象的三种方法
		Class clazz1=Class.forName("com.cdsxt.vo.TestBean");
		Class clazz2=TestBean.class;
		TestBean bean=new TestBean();
		Class clazz3=bean.getClass();
		//获取反射模板对象的常规信息
		System.out.println(clazz1.getName());
		System.out.println(clazz1.getSimpleName());
		System.out.println(clazz1.getPackage());
	}
	//通过指定类X(TestBean) 的反射模板实例创建 X(TestBean)  的实例。
	public static void getObject()throws Exception{
		Class<TestBean> clazz=TestBean.class;
		TestBean testBean=clazz.newInstance(); //在上述泛型中指定<TestBean>后，可以直接得到TestBean对象
		System.out.println(testBean instanceof TestBean);
	}
	//测试反射模板获取多个属性
		public static void getFields() throws Exception{
			Class clazz=Class.forName("com.cdsxt.vo.TestBean");
			Field[] fields = clazz.getFields();
			for (Field field : fields) {
				System.out.print(field.getName()+",");
				System.out.print(field.getType()+",");
				/*
				 * 返回一个 Class 对象，它标识了此 Field 对象所表示字段的声明类型。 
						返回：标识此对象所表示字段的声明类型的 Class 对象
				 */
				Class fieldClazz=field.getType();
				System.out.println(fieldClazz.getSimpleName());
			}
	}
		//测试反射模板获取单个属性
		public static void getField() throws Exception{
			Class<TestBean> clazz=TestBean.class;
			System.out.println(clazz.getField("handsome"));
			Field id=clazz.getDeclaredField("id");  //这里获取的是id所在TestBean类中作为成员变量
			//（万物皆对象，成员变量属于Field类）对象的实例，需要getDeclaredField方法打破坏封装规范
			//去查看TtBean类中私有成员变量,而要改变id的值，则需要id.setAccessible(true);
			System.out.println(id);
			//给公共的非静态的属性设值
			Field a=clazz.getField("a");
			TestBean testBean=clazz.newInstance();
			a.set(testBean, "abc");  //   testBean.a="abc"
			String value=(String)a.get(testBean);//testBean.a
			System.out.println(value);
			
			//给静态的属性设值的时候    object  尽量传null   传对象会被忽略
			Field a2=clazz.getField("gender");
			a2.set(null, 1);  
			System.out.println(a2.get(null));
			
//			//测试给私有属性设置值
			Field id2=clazz.getDeclaredField("id"); 
			id2.setAccessible(true);
			id2.set(testBean, 222); 
			System.out.println(id2.get(testBean));
			id2.setAccessible(false);
		}
}
