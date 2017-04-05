/**
 * 
 */
package com.superstar.vo;

import java.io.Serializable;
import java.util.Date;

import com.superstar.dbc.DatebaseConnection;

/**
 * @作者:Administrator

 * @创建日期:2017-3-29

 */
public class Emp implements Serializable {
	private Integer empno;
	private String  ename;
	private String job;
	private Date hiredate;
	private Double sal;
	private Double comm;
	/**
	 * @return the empno
	 */
	public Integer getEmpno() {
		return empno;
	}
	/**
	 * @param empno the empno to set
	 */
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * @return the hiredate
	 */
	public Date getHiredate() {
		return hiredate;
	}
	/**
	 * @param hiredate the hiredate to set
	 */
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	/**
	 * @return the sal
	 */
	public Double getSal() {
		return sal;
	}
	/**
	 * @param sal the sal to set
	 */
	public void setSal(Double sal) {
		this.sal = sal;
	}
	/**
	 * @return the comm
	 */
	public Double getComm() {
		return comm;
	}
	/**
	 * @param comm the comm to set
	 */
	public void setComm(Double comm) {
		this.comm = comm;
	}
	
	
}
