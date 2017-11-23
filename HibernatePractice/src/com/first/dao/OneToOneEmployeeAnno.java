package com.first.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="OneToOneEmployeeAnno")
public class OneToOneEmployeeAnno 
{
	@Id
	@Column(name="eid")
   private String eid;
	
	@Column(name="ename")
   private String ename;
	@OneToOne(cascade=CascadeType.ALL)
   OneToOneAccountAnno acc;
   public OneToOneAccountAnno getAcc() 
    {
	return acc;
    }
   public void setAcc(OneToOneAccountAnno acc) 
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
