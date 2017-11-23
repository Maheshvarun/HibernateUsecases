package com.first.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

@Entity
@Table(name="OneToManyStudentAnno")
public class OneToManyStudentAnno 
{
	@Id
	@Column(name="sid")
 private String sid;
	
	@Column(name="sname")
 private String sname;
	
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
