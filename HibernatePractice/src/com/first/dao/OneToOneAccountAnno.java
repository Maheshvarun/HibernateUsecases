package com.first.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OneToOneAccountAnno")
public class OneToOneAccountAnno 
{
	@Id
	@Column(name="accno")
    private String accno;
	
	@Column(name="accname")
    private String accname;
  
    public String getAccno() 
    {
	return accno;
    }
    public void setAccno(String accno) 
    {
	this.accno = accno;
    }
    public String getAccname() 
    {
	return accname;
    }
    public void setAccname(String accname) 
    {
	this.accname = accname;
   }   
}
