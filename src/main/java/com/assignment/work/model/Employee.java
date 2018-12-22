package com.assignment.work.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="eid")
	private long eid;
	
	@Column(name="ename")
	private String ename;
	
	@Column(name="emailid")
	private String emailid;
	
	

	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getEmobile() {
		return emobile;
	}

	public void setEmobile(String emobile) {
		this.emobile = emobile;
	}

	@Column(name="emobile")
	private String emobile;

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", emailid=" + emailid + ", emobile=" + emobile + "]";
	}

	public Employee(long eid, String ename, String emailid, String emobile) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.emailid = emailid;
		this.emobile = emobile;
	}

	public Employee(String ename, String emailid, String emobile) {
		super();
		this.ename = ename;
		this.emailid = emailid;
		this.emobile = emobile;
	}

	public Employee() {
		super();
	}
	
	
}
