package com.first.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ManyToOneBranchAnno")
public class ManyToOneBranchAnno 
{
 @Id
 @Column(name="bid")
private String bid;
	
@Column(name="bname")	
private String bname;

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
