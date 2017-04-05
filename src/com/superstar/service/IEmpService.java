/**
 * 
 */
package com.superstar.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.superstar.vo.Emp;

/**
 * @作者:Administrator
 * @创建日期:2017-3-30<br>
 * 定义的emp表业务层的执行标准，此类一定要负责数据库的打开与关闭操作
 * 此类可以通过DAOFactory类取得IEmpDAO借口对象
 */
public interface IEmpService {
	/**
	 * 实现雇员的增加操作，本操作要调用IEmpDAO接口下的如下方法：<br>
	 * <li>需要调用IEmpDAO.findById()方法，判断要增加数据的ID是否已经存在；
	 * <li>如果现在要增加的数据编号不存在，则调用IEmpDAOI.doCreat()方法，返回
	 * 操作的结果
	 * @param vo 包含了要增加数据的vo对象
	 * @return 如果增加数据的ID重复或者保存失败则返回false，否则返回true
	 * @throws Exception SQL执行异常
	 */
	public boolean insert(Emp vo) throws Exception;
	/**
	 * 实现雇员数据的修改操作，本次要调用IEmpDAO.doUpdate()方法，
	 * 本次修改属于全部内容的修改;
	 * @param vo 包含了要修改的vo对象
	 * @return 修改成功则返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean update(Emp vo) throws Exception;
	/**
	 * 执行雇员信息的删除操作，可以删除多个雇员信息，
	 * 调用IEmpDAO.doRemoveBatch()方法
	 * @param ids 包含了全部要删除数据的集合，没有重复数据
	 * @return 删除成功返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean delete(Set<Integer> ids) throws Exception;
	/**
	 * 查询，调用IEmpDAO.findById()方法
	 * @param id 要查找的雇员的编号
	 * @return 如果知道了雇员则把信息以VO对象返回，否则返回null
	 * @throws Exception SQL执行异常
	 */
	public Emp get(int id) throws Exception;
	/**
	 * 查询全部雇员信息，调用IEmpDAO.findAll()方法
	 * @return 查询结果以List集合的形式返回，如果没有数据则集合的长度为0
	 * @throws Exception SQL执行异常
	 */
	public List<Emp> list() throws Exception;
	/**
	 * 实现数据的模糊查询与数据统计，要调用IEmpDAO接口的两个方法：<br>
	 * <li>调用IEmpDAO.findAllSplit()方法，查询出所有的表数据，返回List<Emp>;
	 * <li>调用IEmpDAO.getAllCount()方法，查询所有数据的数据量，返回Interger；
	 * @param currentPage 当前所在页数
	 * @param linesize每页所显示的记录数
	 * @param column 要模糊查询的数据列的名字
	 * @param keyWord 进行模糊查询的值
	 * @return 本方法由于需要返回多种数据类型，所以用Map集合返回，由于类型不统一，所以所有value的类型设置object，
	 * 返回如下内容：<br>
	 * <li>key=allEmps, value=IEmpDAO.findAllSplit()返回结果，List<Emp>;
	 * <li>key=empCOunt,value=IEmpDAO.getAllCount() 返回结果，Integer；
	 * @throws Exception SQL执行异常
	 */
	public Map<String, Object> list(int currentPage,int linesize,String column,String keyWord) throws Exception;
}
