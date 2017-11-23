package com.first.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TableperSubClassAnnoMana")
@PrimaryKeyJoinColumn(name="mid")
public class TableperSubClassAnnoMana extends TableperSubClassAnnoEmp
{
	@Column(name="email")
	private String email;
	
	@Column(name="adress")
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
