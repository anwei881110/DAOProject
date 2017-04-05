/**
 * 
 */
package com.superstar.factory;

import java.sql.Connection;

import com.superstar.dao.IDeptDAO;
import com.superstar.dao.IEmpDAO;
import com.superstar.dao.impl.DeptDAOImpl;
import com.superstar.dao.impl.EmpDAOImpl;

/**
 * @作者:Administrator
 * @创建日期:2017-3-29
 */
public class DAOFactory {
	public static IEmpDAO getIEmpDAOInstance(Connection conn){
		return new EmpDAOImpl(conn);
	}
	public static IDeptDAO getIDeptDAOInstance(Connection conn){
		return new DeptDAOImpl(conn);
	}
}
