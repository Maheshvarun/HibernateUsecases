package com.first.dao;
public class OneToOneEmployee 
{
   private String eid;
   private String ename;
   OneToOneAccount acc;
   public OneToOneAccount getAcc() 
   {
	return acc;
    }
   public void setAcc(OneToOneAccount acc)   
    {
	this.acc = acc;
    }
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
