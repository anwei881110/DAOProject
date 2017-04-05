/**
 * 
 */
package com.superstar.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.superstar.dao.IEmpDAO;
import com.superstar.vo.Emp;

/**
 * @作者:Administrator
 * @创建日期:2017-3-29
 */
public class EmpDAOImpl implements IEmpDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	/**
	 * 如果想要使用数据层进行原子性的功能操作实现，必须要提供有connection借口对象<br>
	 * 另外，由于开发中业务层要调用数据层，所有数据库的打开与关闭交由业务层处理
	 * @param conn 表示数据库连接对象
	 */
	public EmpDAOImpl(Connection conn){
		this.conn=conn;
	}

	/* (non-Javadoc)
	 * @see com.superstar.dao.IEmpDAO#doCreat(com.superstar.vo.Emp)
	 */
	@Override
	public boolean doCreat(Emp vo) throws Exception {
		String sql="INSERT INTO emp (empno,ename,job,hiredate,sal," +
				"comm) values (?,?,?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getEmpno());
		this.pstmt.setString(2, vo.getEname());
		this.pstmt.setString(3, vo.getJob());
		this.pstmt.setDate(4, new java.sql.Date (vo.getHiredate().getTime())); //进行强制类型转换 new(java.sql.Date(vo.getHiredate().getTime));
		this.pstmt.setDouble(5, vo.getSal());
		this.pstmt.setDouble(6, vo.getComm());
		return this.pstmt.executeUpdate()>0; 	//增加执行返回结果数大于0，即说明数据库添加操作成功
	}

	/* (non-Javadoc)
	 * @see com.superstar.dao.IEmpDAO#doUpdate(com.superstar.vo.Emp)
	 */
	@Override
	public boolean doUpdate(Emp vo) throws Exception {
		String sql="UPDATE emp SET ename=?,job=?,hiredate=?,sal=?,comm=? WHERE empno=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getEname());
		this.pstmt.setString(2, vo.getJob());
		this.pstmt.setDate(3, new java.sql.Date( vo.getHiredate().getTime())); //进行强制类型转换 new(java.sql.Date(vo.getHiredate().getTime));
		this.pstmt.setDouble(4, vo.getSal());
		this.pstmt.setDouble(5, vo.getComm());
		this.pstmt.setInt(6, vo.getEmpno());
		return this.pstmt.executeUpdate()>0;
	}

	/* (non-Javadoc)
	 * @see com.superstar.dao.IEmpDAO#doRemoveBatch(java.util.Set)
	 */
	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		if(ids==null|| ids.size()==0){
			return false; //集合内容为空 没有执行删除操作，删除失败
		}
		StringBuffer sql= new StringBuffer();
		sql.append("DELETE FROM EMP WHERE empno IN(");
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
	 * @see com.superstar.dao.IEmpDAO#findById(java.lang.Integer)
	 */
	@Override
	public Emp findById(Integer id) throws Exception {
		Emp vo=null;
		String sql="SELECT empno,ename,job,hiredate,sal,comm FROM emp WHERE empno=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()){
			vo=new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
		}
		return vo;
	}

	/* (non-Javadoc)
	 * @see com.superstar.dao.IEmpDAO#findAll()
	 */
	@Override
	public List<Emp> findAll() throws Exception {
		List<Emp> all=new ArrayList<Emp>();
		String sql="SELECT empno,ename,job,hiredate,sal,comm FROM emp";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()){
			Emp vo=new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			all.add(vo);
		}
		return all;
	}

	/* (non-Javadoc)
	 * @see com.superstar.dao.IEmpDAO#findEsAllSpilt(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Emp> findEsAllSpilt(Integer currentPage, Integer linsize,
			String column, String KeyWord) throws Exception {
		List<Emp> all= new ArrayList<Emp>();
		/**
		 * 分页查询sql 语句重点掌握 多加回顾
		 * pagesize： 每页显示记录数
			cureentpage：当前页数
 
			select * from (   select TOP pagesize * 
			FROM ( SELECT TOP pagesize*cureentpage   * 
			from user_table   ORDER BY id ASC ) 
			as aSysTable   ORDER BY id DESC ) 
			as bSysTable   ORDER BY id ASC
			
		 *	Select * from 
		 	(select empno,ename,job,hiredate,sal,comm,
		 	ROWNUM rn from emp where rownum<=2*5)
		 	temp where temp.rn>(2-1)*5;
		 */
		//如此sql语句太容易写错了 囧
		String sql="SELECT * FROM "
				+"(SELECT empno,ename,job,hiredate,sal,comm, ROWNUM rn "
				+"FROM emp "
				+"WHERE "+column+" LIKE ? AND ROWNUM<=?) temp "
				+"WHERE temp.rn>?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+KeyWord+"%");
		this.pstmt.setInt(2, currentPage*linsize);
		this.pstmt.setInt(3, (currentPage-1)*linsize);
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()){
			Emp vo=new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			all.add(vo);
		}
		return all;
	}

	/* (non-Javadoc)
	 * @see com.superstar.dao.IEmpDAO#getAllCount(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		String sql="SELECT COUNT(empno) FROM emp WHERE "+column+"LIKE ?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, keyWord);
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()){
			return rs.getInt(1);
		}
		return null;
	}

}
