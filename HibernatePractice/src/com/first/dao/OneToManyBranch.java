package com.first.dao;

import java.util.Collection;

public class OneToManyBranch 
{
  private String bid;
  private String bname;
  private Collection<OneToManyStudent> stds;
  
public Collection<OneToManyStudent> getStds() 
{
	return stds;
}
public void setStds(Collection<OneToManyStudent> stds) 
{
	this.stds = stds;
}
public String getBid() 
{
	return bid;
}
public void setBid(String bid) 
{
	this.bid = bid;
}
public String getBname() 
{
	return bname;
}
public void setBname(String bname) 
{
	this.bname = bname;
}
}
