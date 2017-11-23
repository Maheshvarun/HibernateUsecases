package com.first.dao;
public class TableperSubClassManager extends TableperSubClassEmployee 
{
	private String email;
	private String adress;
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getAdress() 
	{
		return adress;
	}
	public void setAdress(String adress) 
	{
		this.adress = adress;
	}
}
