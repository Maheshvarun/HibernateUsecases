package com.first.dao;

import java.util.Collection;
import com.first.dao.OneToManyStudentAnno;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="OneToManyBranchAnno")
public class OneToManyBranchAnno 
{
	@Id
	@Column(name="bid")
  private String bid;
	
  @Column(name="bname")	
  private String bname;
  
  @OneToMany(cascade=CascadeType.ALL)
  @JoinTable(name = "studentanno_branchanno",joinColumns={@JoinColumn(name = "branchid")},inverseJoinColumns = {@JoinColumn(name="studentid")})
  private Collection<OneToManyStudentAnno> stds;
  
  public Collection<OneToManyStudentAnno> getStds() 
   {
	return stds;
   }
  public void setStds(Collection<OneToManyStudentAnno> stds) 
   {
	this.stds = stds;
   }
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