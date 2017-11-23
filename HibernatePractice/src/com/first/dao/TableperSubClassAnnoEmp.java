package com.first.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="TableperSubClassAnnoEmp")
public class TableperSubClassAnnoEmp 
{ 
	 @Id
	 @Column(name="eid")
	 private String eid;
	 
	 @Column(name="ename")
	 private String ename;
	 
	 public String getEid() 
	{
		return eid;
	}
	public void setEid(String eid) 
	{
		this.eid = eid;
	}
	public String getEname() 
	{
		return ename;
	}
	public void setEname(String ename) 
	{
		this.ename = ename;
	}   
}
