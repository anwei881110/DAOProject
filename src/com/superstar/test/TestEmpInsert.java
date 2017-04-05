/**
 * 
 */
package com.superstar.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import com.superstar.factory.ServiceFactory;
import com.superstar.vo.Emp;

/**
 * @作者:Administrator
 * @创建日期:2017-3-30
 */
public class TestEmpInsert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		
//			 String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
//			// private static final String
//			 DBURL="jdbc:oralce:thin:@localhost:1521:orcl";
//			 String DBURL = "jdbc:Oracle:thin:@127.0.0.1:1521:orcl "; // 配置oracle数据库的远程连接
//			 String DBUSER = "scott";
//			 String PASSWORD = "tiger";
//			 Connection conn = null;

			/**
			 * 在构造方法里面为conn对象进行实例化，可以直接取得数据库的链接对象<br>
			 * 由于所有的操作都是基于数据库完成的，如果数据库取不到链接，那么也就意味着 所有的操作都可以停止了
			 */
//			 try {
//					try {
//						Class.forName(DBDRIVER);
//					} catch (ClassNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//						conn = DriverManager
//								.getConnection(DBURL, DBUSER, PASSWORD);
//					}
//						 catch (SQLException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
		System.out.println(123);
		Emp vo=new Emp();
		vo.setEmpno(1111);
		vo.setEname("程冠希")	;
		vo.setJob("摄影师");
		vo.setHiredate(new Date());
		vo.setSal(110.0);
		vo.setComm(5.0);
		
		try {
			System.out.println(ServiceFactory.getIEmpServiceInstance().insert(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}