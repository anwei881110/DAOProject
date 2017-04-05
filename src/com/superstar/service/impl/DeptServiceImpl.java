/**
 * 
 */
package com.superstar.service.impl;

import java.util.List;
import java.util.Set;

import com.superstar.dbc.DatebaseConnection;
import com.superstar.factory.DAOFactory;
import com.superstar.service.IDeptService;
import com.superstar.vo.Dept;

/**
 * @作者:Administrator
 * @创建日期:2017-4-5
 */
public class DeptServiceImpl implements IDeptService {

	private DatebaseConnection dbc=new DatebaseConnection();
	/* (non-Javadoc)
	 * @see com.superstar.service.IDeptService#insert(com.superstar.vo.Dept)
	 */
	@Override
	public boolean insert(Dept vo) throws Exception {
		try {
			if(DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).findById(vo.getDeptno())==null){
				DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).doCreate(vo);
			}
			return false;
		} catch (Exception e) {
			throw e;
		} finally{
			this.dbc.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.superstar.service.IDeptService#update(com.superstar.vo.Dept)
	 */
	@Override
	public boolean update(Dept vo) throws Exception {
		try {
			return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).doUpdate(vo);
		} catch (Exception e) {
			throw e;
		} finally{
			this.dbc.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.superstar.service.IDeptService#delete(java.util.Set)
	 */
	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		try {
			return 
					DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
		} catch (Exception e) {
			throw e;
		} finally{
			this.dbc.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.superstar.service.IDeptService#list()
	 */
	@Override
	public List<Dept> list() throws Exception {
		try {
			return
					DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).findAll();
		} catch (Exception e) {
			throw e;
		} finally{
			this.dbc.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.superstar.service.IDeptService#get(int)
	 */
	@Override
	public Dept get(int id) throws Exception {
		try {
			return
					DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).findById(id);
		} catch (Exception e) {
			throw e;
		} finally{
			this.dbc.close();
		}
	}

}
