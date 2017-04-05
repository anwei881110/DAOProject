/**
 * 
 */
package com.superstar.dao;

import java.util.List;
import java.util.Set;

/**
 * 定义公共查询DAO操作借口标准，基本功能包括：<br>
 * 增加、修改、删除、查询、查询全部、数据统计、分页显示等操作
 * @作者:Administrator
 * @创建日期:2017-4-5
 * @param <K> 表示要操作的主键类型，由子接口实现
 * @param <V>表示要操作的VO类型，由子接口实现
 */
public interface IDAO<K,V> {
	/**
	 * 实现数据的增加操作
	 * @param vo 包含要增加数据的VO对象
	 * @return 数据保存成功则返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean doCreate(V vo) throws Exception;
	/**
	 * 实现数据的修改操作，本次修改是根据id进行全部字段数据的修改
	 * @param vo 包含了要修改数据的信息，一定要提供有ID内容
	 * @return 数据修改成功返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean doUpdate(V vo) throws Exception;
	/**
	 * 执行数据的批量删除操作，所有要删除的数据以set集合形式保存
	 * @param ids 包含了所有要删除的数据ID，不包含有重复内容
	 * @return 删除成功返回true（删除的数据个数与要删除的数据个数相同），否则发挥false
	 * @throws Exception SQL执行异常
	 */
	public boolean doRemoveBatch(Set<K> ids) throws Exception;
	/**
	 * 根据雇员编号查询雇员信息
	 * @param id 要查询雇员的id
	 * @return 如果雇员信息存在，则数据将以VO类对象的形式返回，如果雇员数据不存在，<br>
	 * 则返回false
	 * @throws Exception SQL执行异常
	 */
	public V findById(K id) throws Exception;
	/**
	 * 查询指定数据表全部记录，并且以集合的形式返回
	 * @return 如果表中有数据，则所有的数据会封装为VO对象而后面利用List集合返回，<br>
	 * 如果没有数据，那么集合的长度为0（size（）==0，不是null）
	 * @throws Exception SQL执行异常
	 */
	public List<V> findAll() throws Exception;
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
	public List<V> findAllSplit(Integer currentPage,Integer linesize, String column, String KeyWord) throws Exception;
	/**
	 * 进行模糊查询的数据统计
	 * @param column 要进行模糊查询的列名称
	 * @param keyWord  模糊查询的关键字
	 * @return 返回查询统计数量，如果没有数据则返回0
	 * @throws Exception SQL执行异常
	 */
	public Integer getAllCount(String column,String KeyWord) throws Exception;
}
