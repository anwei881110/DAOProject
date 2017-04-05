/**
 * 
 */
package com.superstar.vo;

import java.io.Serializable;

/**
 * @作者:Administrator
 * @创建日期:2017-4-5
 */
public class Dept implements Serializable {
	private Integer deptno;
	private String dname;
	/**
	 * @return the deptno
	 */
	public Integer getDeptno() {
		return deptno;
	}
	/**
	 * @param deptno the deptno to set
	 */
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	/**
	 * @return the dname
	 */
	public String getDname() {
		return dname;
	}
	/**
	 * @param dname the dname to set
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}
	/**
	 * @return the loc
	 */
	public String getLoc() {
		return loc;
	}
	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
	private String loc;
}
