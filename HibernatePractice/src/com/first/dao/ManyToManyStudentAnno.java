package com.first.dao;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@Entity
@Table(name="ManyToManyStudentAnno")
public class ManyToManyStudentAnno 
{
	@Id
	@Column(name="sid")
	private String sid;
	
	@Column(name="sname")
    private String sname;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "studentanno_courseanno",joinColumns={@JoinColumn(name = "sid")},inverseJoinColumns = {@JoinColumn(name="cid")})
	private Collection<ManyToManyCoursesAnno> course;

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
   public Collection<ManyToManyCoursesAnno> getCourse() 
   {
	return course;
   }
   public void setCourse(Collection<ManyToManyCoursesAnno> course) 
   {
	this.course = course;
   }
}