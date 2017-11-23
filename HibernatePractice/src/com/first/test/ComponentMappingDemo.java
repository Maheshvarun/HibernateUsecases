package com.first.test;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.first.dao.Adress;
import com.first.dao.Jober;
import com.first.dao.Salary;

public class ComponentMappingDemo 
{
	public static void main(String[] args)
	{
	Configuration cfg = new Configuration();
	
	cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");	
	
	SessionFactory factory = cfg.buildSessionFactory();
	
	Session session = factory.openSession();
	
	/*Salary sal=new Salary();
	sal.setAccName("sairamT");
	sal.setAccNo("100");
	sal.setAccType("savings");
	
	Adress adr=new Adress();
	adr.setPno("506344");
	adr.setStreet("baburaoStreet");
	
	Jober job=new Jober();
	job.setEid("e101");
	job.setEname("Tsairam");
	job.setEaddr(adr);
	job.setEsal(sal);
	
	Transaction tx=session.beginTransaction();
	session.save(job);
	tx.commit();
	System.out.println("employee record inserted sucessfully");
	System.out.println("---------------");*/
	
	Jober job1=(Jober)session.get(Jober.class,"e100");
	System.out.println(job1.getEid()+"   "+job1.getEname());
	
	System.out.println("Address Details");
	Adress adr1=job1.getEaddr();
	System.out.println(adr1.getPno()+"   "+adr1.getStreet());
	
	System.out.println("Salary Details");
	Salary sal1=job1.getEsal();
	System.out.println(sal1.getAccName()+"  "+sal1.getAccNo()+"   "+sal1.getAccType());
	
	Transaction tx1 = session.beginTransaction();
	SQLQuery q=session.createSQLQuery("delete from jober1 where eid=?");
	q.setParameter(0,"e100");
    System.out.println(q.executeUpdate());
    tx1.commit();
	/*Transaction tx1 = session.beginTransaction();
	Jober job2=(Jober)session.get(Jober.class,"e101");
	System.out.println(job2);
	session.delete(job2);
	tx1.commit();*/
	session.close();
	factory.close();
   }
}