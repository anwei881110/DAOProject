/**
 * 
 */
package com.superstar.dao;

import java.util.List;
import java.util.Set;

import com.superstar.vo.Dept;

/**
 * @作者:Administrator
 * @创建日期:2017-4-5
 */
public interface IDeptDAO extends IDAO<Integer,Dept> {
	/*
	//采用统一的借口继承模式来写
	public boolean doCreate(Dept vo) throws Exception;
	public boolean doUpdate(Dept vo) throws Exception;
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception;
	public Dept findById(Integer id) throws Exception;
	public List<Dept> findAll() throws Exception;
	*/
}
