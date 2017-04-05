
package com.superstar.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.superstar.dbc.DatebaseConnection;
import com.superstar.factory.DAOFactory;
import com.superstar.service.IEmpService;
import com.superstar.vo.Emp;

/**
 * @作者:Administrator
 * @创建日期:2017-3-30
 */
public class EmpServiceImpl implements IEmpService {
	// 在这个类的内部就提供有一个数据库连接类的实力话对象
	private DatebaseConnection dbc = new DatebaseConnection();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.superstar.service.IEmpService#insert(com.superstar.vo.Emp)
	 */
	@Override
	public boolean insert(Emp vo) throws Exception {
		try {
			//要增加的雇员编号如果不存在，则findbyid()返回的结果就是null，null表示可以进行新雇员数据的保存
			if(DAOFactory.getIEmpDAOInstance
					(this.dbc.getConnection()).findById(vo.getEmpno())==null){
				return DAOFactory.getIEmpDAOInstance
						(this.dbc.getConnection()).doCreat(vo);
			}
			return false;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.superstar.service.IEmpService#update(com.superstar.vo.Emp)
	 */
	@Override
	public boolean update(Emp vo) throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).doUpdate(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.superstar.service.IEmpService#delete(java.util.Set)
	 */
	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		try {
			return 
			DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.superstar.service.IEmpService#get(int)
	 */
	@Override
	public Emp get(int id) throws Exception {
		try {
			return 
					DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.superstar.service.IEmpService#list()
	 */
	@Override
	public List<Emp> list() throws Exception {
		try {
			return
					DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).findAll();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.superstar.service.IEmpService#list(int, int, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Map<String, Object> list(int currentPage, int linesize,
			String column, String keyWord) throws Exception {
		try {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("allEmps", DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).findEsAllSpilt(currentPage, linesize, column, keyWord));
			map.put("empCount", DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).findAll().size());
			return map;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

}
