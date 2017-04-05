/**
 * 
 */
package com.superstar.service;

import java.util.List;
import java.util.Set;

import com.superstar.vo.Dept;

/**
 * @作者:Administrator
 * @创建日期:2017-4-5
 */
public interface IDeptService {
	public boolean insert(Dept vo) throws Exception;
	public boolean update(Dept vo) throws Exception;
	public boolean delete(Set<Integer> ids) throws Exception;
	public List<Dept> list() throws Exception;
	public Dept get(int id) throws Exception;
}
