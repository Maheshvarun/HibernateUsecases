package com.first.dao;

public class CacheEmployee 
   {
	 private int eid;
     private String Ename;
     private int esal;
	 private String eaddr;
	public int getEid() 
	{
		return eid;
	}
	public void setEid(int eid) 
	{
		this.eid = eid;
	}
	public String getEname() 
	{
		return Ename;
	}
	public void setEname(String ename) 
	{
		Ename = ename;
	}
	public int getEsal() 
	{
		return esal;
	}
	public void setEsal(int esal) 
	{
		this.esal = esal;
	}
	public String getEaddr() 
	{
		return eaddr;
	}
	public void setEaddr(String eaddr) 
	{
		this.eaddr = eaddr;
	} 
}