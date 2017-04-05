package com.superstar.service.junit;

import static org.junit.Assert.*;

import java.awt.List;
import java.sql.SQLClientInfoException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;

import com.superstar.factory.DAOFactory;
import com.superstar.factory.ServiceFactory;
import com.superstar.vo.Emp;

public class IEmpServiceTest {
	private static int empno;
	static{
		empno= new Random().nextInt(1000);//动态生成empno数据
	}

	@Test
	public void testInsert() {
		Emp vo=new Emp();
		vo.setEmpno(empno);
		vo.setEname("程"+empno)	;
		vo.setJob("摄"+empno);
		vo.setHiredate(new Date());
		vo.setSal(110.0);
		vo.setComm(5.0);
		
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().insert(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Emp vo=new Emp();
		vo.setEmpno(1111);
		vo.setEname("程"+empno)	;
		vo.setJob("摄"+empno);
		vo.setHiredate(new Date());
		vo.setSal(110.0);
		vo.setComm(5.0);
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().update(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testGet() {
		try {
			TestCase.assertNotNull(ServiceFactory.getIEmpServiceInstance().get(7369));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		Set<Integer> idSet=new HashSet<Integer>();
		idSet.add(1111);
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().delete(idSet));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void testList() {
		try {
			TestCase.assertNotNull(ServiceFactory.getIEmpServiceInstance().list());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void testListIntIntStringString() {
		try {
			Map<String, Object> map=ServiceFactory.getIEmpServiceInstance().list(2,5, "job", "");
			int count =(Integer) map.get("empCount");
			java.util.List<Emp> all=(java.util.List<Emp>)map.get("allEmps");
			TestCase.assertTrue(count>0||all.size()>0);
//			System.out.println(count);
//			System.out.println(all.get(1).getEname());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
