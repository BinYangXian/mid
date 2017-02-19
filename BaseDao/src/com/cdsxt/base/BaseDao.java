package com.cdsxt.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.cdsxt.po.Employee;
import com.cdsxt.util.DBUtil;

public class BaseDao {
	/**
	 * 
	 * @param sql 增删改的sql
	 * @param params 填坑的参数，如果没有坑则传null
	 */
	public static void change(String sql,Object[] params){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			//填坑、
			if(params!=null&&params.length>0){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(ps,conn);
		}
	}
	
	/**
	 * 
	 * @param sql  查询语句
	 * @param params  填坑的参数，如果没有坑则传null
	 * @param t  List<T> 泛型的对象
	 * @return List结果集
	 */
	public static <T> List<T> queryList(String sql,Object[] params,T t){
		//获取泛型对象的反射模板  
		Class clazz=t.getClass();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<T> list=new ArrayList<T>();
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			//填坑、
			if(params!=null&&params.length>0){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			//获取结果集的列数
			int count=rsmd.getColumnCount();
			while(rs.next()){
				T obj=(T) clazz.newInstance();
				for(int i=1;i<=count;i++){
					String fieldName=rsmd.getColumnName(i);
					Field field=clazz.getDeclaredField(fieldName);
					String setter=getSetter(fieldName);
					//获取设定器的方法
					Method method=clazz.getMethod(setter, field.getType());
					method.invoke(obj, rs.getObject(fieldName));
				}
				list.add(obj);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs,ps,conn);
		}
		return list;
	} 
	
	/**
	 *  
	 * @param sql  通过id查询单挑数据    只能有一个id=?
	 * @param id   id值
	 * @param t    泛型的对象
	 * @return   通过id查询的单个对象，如果没有则返回null
	 */
	public static <T> T queryById(String sql,int id,T t){
		//获取泛型对象的反射模板  
		Class clazz=t.getClass();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		T obj=null;
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int count=rsmd.getColumnCount();
			while(rs.next()){
				obj=(T)clazz.newInstance();
				for(int i=1;i<=count;i++){
					String fieldName=rsmd.getColumnName(i);
					Field field=clazz.getDeclaredField(fieldName);
					String setter=getSetter(fieldName);
					//获取设定器的方法
					Method method=clazz.getMethod(setter, field.getType());
					method.invoke(obj, rs.getObject(fieldName));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs,ps,conn);
		}
		return obj;
	} 
	
	/**
	 * 
	 * @param sql  查询的字段只能有 count 
	 * @param params 填坑的参数，如果没有坑则传null
	 * @return   查询的结果的条数
	 */
	public static int queryCount(String sql,Object[] params){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			//填坑、
			if(params!=null&&params.length>0){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs,ps,conn);
		}
		return count;
	} 
	/**
	 * 
	 * @param fieldName  属性名
	 * @return  设定器的名字
	 */
	public static String getSetter(String fieldName){
		return "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
	}
}
