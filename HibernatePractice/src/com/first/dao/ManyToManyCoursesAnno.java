package com.first.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

@Entity
@Table(name="ManyToManyCoursesAnno")
public class ManyToManyCoursesAnno 
{
	@Id
	@Column(name="cid")
    private String cid;
	
	@Column(name="cname")
    private String cname;

    public String getCid() 
    {
	return cid;
    }
    public void setCid(String cid) 
    {
	this.cid = cid;
    }
    public String getCname() 
    {
	  return cname;
    }
    public void setCname(String cname) 
    {
	this.cname = cname;
    }
}
