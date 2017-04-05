/**
 * 
 */
package com.superstar.factory;

import com.superstar.service.IDeptService;
import com.superstar.service.IEmpService;
import com.superstar.service.impl.DeptServiceImpl;
import com.superstar.service.impl.EmpServiceImpl;

/**
 * @作者:Administrator
 * @创建日期:2017-3-30
 */
public class ServiceFactory {
	public static IEmpService getIEmpServiceInstance(){
		return new EmpServiceImpl();
	}
	public static IDeptService getIDeptServiceInstance(){
		return new DeptServiceImpl();
	}
}
