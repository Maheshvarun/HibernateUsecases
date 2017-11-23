package com.first.dao;

import java.util.Collection;

public class ManyToManyStudent 
{
private String sid;
private String sname;
private Collection<ManyToManyCourses> course;

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
public Collection<ManyToManyCourses> getCourse() 
{
	return course;
}
public void setCourse(Collection<ManyToManyCourses> course) 
{
	this.course = course;
}
}
