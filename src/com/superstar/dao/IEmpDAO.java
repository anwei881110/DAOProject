/**
 * 
 */
package com.superstar.dao;

import java.util.List;
import java.util.Set;

import com.superstar.vo.Emp;

/**
 * @作者:Administrator
 * @创建日期:2017-3-29
 */
public interface IEmpDAO {
	/**
	 * 实现数据库增加操作
	 * @param vo 包含了要增加数据库的vo对象
	 * @return 数据保存成功返回true，否则则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean doCreat(Emp vo) throws Exception;
	/**
	 * 实现数据库修改操作，本次修改是根据id进行全部字段数据的修改
	 * @param vo 包含了本次要修改数据的信息，一定要提供ID内容<br>
	 * @return 数据修改成功返回true，否则则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean doUpdate(Emp vo) throws Exception;
	/**
	 * 执行数据的批量操作，所有要删除的数据以set集合的形式保存
	 * @param ids 包含了所有要删除的数据ID，不包含有重复内容
	 * @return 删除成功返回true（删除的数据个数与要删除的数据个数相同），否则<br>
	 * 返回false。
	 * @throws Exception SQL执行异常
	 */
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception;
	/**
	 * 通过ID查找制定的雇员信息
	 * @param id 要查找的雇员编号
	 * @return 如果雇员信息存在，则以vo对象返回查到的雇员信息，否则则返回null
	 * @throws Exception SQL执行异常
	 */
	public Emp findById(Integer id) throws Exception;
	/**
	 * 查询指定数据表全部记录，并且以集合的形式返回
	 * @return 如果表中有数据，则所有的数据会封装为VO对象而后面利用List集合返回，<br>
	 * 如果没有数据，那么集合的长度为0（size（）==0，不是null）
	 * @throws Exception SQL执行异常
	 */
	public List<Emp> findAll() throws Exception; //这里版本问题还是什么原因 修订有错误！！ List<Emp> 不正确
	/**
	 * 分页进行数据的模糊查询，查询结果以集合的形式返回
	 * @param currentPage 当前所在页数
	 * @param linsize 每页显示数据行数
	 * @param column 要进行模糊查询的数据列
	 * @param KeyWord 模糊查询的关键字
	 * @return 如果查询到数据，则所有的数据会封装在VO对象而后利用List集合返回，<br>
	 * 如果没有数据，那么集合的长度为0（size（）==0，不是null）
	 * @throws Exception SQL执行异常
	 */
	public List<Emp> findEsAllSpilt(Integer currentPage,Integer linsize, String column,String KeyWord) throws Exception;
	/**
	 * 进行模糊查询的数据统计
	 * @param column 要进行模糊查询的列名称
	 * @param keyWord  模糊查询的关键字
	 * @return 返回查询统计数量，如果没有数据则返回0
	 * @throws Exception SQL执行异常
	 */
	public Integer getAllCount(String column,String keyWord) throws Exception;
}