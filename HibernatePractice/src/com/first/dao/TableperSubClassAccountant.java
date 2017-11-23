package com.first.dao;
public class TableperSubClassAccountant extends TableperSubClassEmployee 
{
   private String sal;
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
