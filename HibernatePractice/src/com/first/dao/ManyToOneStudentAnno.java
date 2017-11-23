package com.first.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="ManyToOneStudentAnno")
public class ManyToOneStudentAnno 
{
	@Id
	@Column(name="sid")
    private String sid;
	@Column(name="sname")
    private String sname;
	@ManyToOne(cascade=CascadeType.ALL)
    private ManyToOneBranchAnno bid;
	
	public ManyToOneBranchAnno getBid() 
	{
		return bid;
	}
	public void setBid(ManyToOneBranchAnno bid) 
	{
		this.bid = bid;
	}
    public String getSid() 
    {
	return sid;
    }
    public void setSid(String sid) 
    {
	this.sid = sid;
    }
    public String getSname() 
    {
	return sname;
    }
    public void setSname(String sname) 
    {
	this.sname = sname;
    }
}
