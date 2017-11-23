package com.first.dao;
public class ManyToOneStudent 
{	
 private String sid;
 private String sname;
 private ManyToOneBranch bid;
public ManyToOneBranch getBid() 
{
	return bid;
}
public void setBid(ManyToOneBranch bid) 
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
