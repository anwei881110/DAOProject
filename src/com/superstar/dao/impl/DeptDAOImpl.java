/**
 * 
 */
package com.superstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.superstar.dao.IDeptDAO;
import com.superstar.vo.Dept;
import com.superstar.vo.Emp;

/**
 * @作者:Administrator
 * @创建日期:2017-4-5
 */
public class DeptDAOImpl implements IDeptDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	/**
	 * 重写构造函数，建立数据库连接
	 * @param conn 数据库连接对象
	 */
	public DeptDAOImpl(Connection conn){
		this.conn=conn;
	}

	/* (non-Javadoc)
	 * @see com.superstar.dao.IDAO#doCreate(java.lang.Object)
	 */
	@Override
	public boolean doCreate(Dept vo) throws Exception {
		String sql="INSERT INTO dept (deptno,dname,loc) VALUES (?,?,?);";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getDeptno());
		this.pstmt.setString(2, vo.getDname());
		this.pstmt.setString(3, vo.getLoc());
		return this.pstmt.executeUpdate()>0; //执行插入跟新且更新条数大于0，说明数据插入操作成功
	}

	/* (non-Javadoc)
	 * @see com.superstar.dao.IDAO#doUpdate(java.lang.Object)
	 */
	@Override
	public boolean doUpdate(Dept vo) throws Exception {
		String sql="UPDATE dept SET dname=?,loc=? WHERE deptno=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getDname());
		this.pstmt.setString(2, vo.getLoc());
		this.pstmt.setInt(3, vo.getDeptno());
		return this.pstmt.executeUpdate()>0;
	}

	/* (non-Javadoc)
	 * @see com.superstar.dao.IDAO#doRemoveBatch(java.util.Set)
	 */
	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		if(ids==null|| ids.size()==0){
			return false; //集合内容为空 没有执行删除操作，删除失败
		}
		StringBuffer sql= new StringBuffer();
		sql.append("DELETE FROM dept WHERE deptno IN(");
		Iterator<Integer> iter=ids.iterator();
		while(iter.hasNext()){
			sql.append(iter.next());
			sql.append(",");
		}
		sql.delete(sql.length()-1, sql.length());	 //删除迭代方法生成字符串的最后一个多余逗号
		sql.append(")");
		this.pstmt=this.conn.prepareStatement(sql.toString());
		return this.pstmt.executeUpdate()==ids.size();	//执行更新数等于ids尺寸数 即为更新结果成功且正确
	}

	/* (non-Javadoc)
	 * @see com.superstar.dao.IDAO#findById(java.lang.Object)
	 */
	@Override
	public Dept findById(Integer id) throws Exception {
		Dept vo=null;
		String sql="SELECT deptno,dname,loc WHERE deptno=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()){
			vo=new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
		}
		return vo;
	}

	/* (non-Javadoc)
	 * @see com.superstar.dao.IDAO#findAll()
	 */
	@Override
	public List<Dept> findAll() throws Exception {
		List<Dept> all=new ArrayList<Dept>();
		String sql="SELECT deptno,dname,loc FROM dept";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()){
			Dept vo=new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
			all.add(vo);
		}
		return all;
	}

	/* (non-Javadoc)
	 * @see com.superstar.dao.IDAO#findAllSplit(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Dept> findAllSplit(Integer currentPage, Integer linesize,
			String column, String KeyWord) throws Exception {
		throw new Exception("此方法未实现!");
	}

	/* (non-Javadoc)
	 * @see com.superstar.dao.IDAO#getAllCount(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer getAllCount(String column, String KeyWord) throws Exception {
		throw new Exception("此方法未实现!");
	}

}
