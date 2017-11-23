package com.first.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TableperSubClassAnnoAcco")
@PrimaryKeyJoinColumn(name="aid")
public class TableperSubClassAnnoAcco extends TableperSubClassAnnoEmp
{
	  @Column(name="sal")
	 private String sal;
	  
	 @Column(name="qul") 
	 private String qul;
	 
	 public String getSal() 
	{
		return sal;
	}
	public void setSal(String sal) 
	{
		this.sal = sal;
	}
	public String getQul() 
	{
		return qul;
	}
	public void setQul(String qul) 
	{
		this.qul = qul;
	}
}
