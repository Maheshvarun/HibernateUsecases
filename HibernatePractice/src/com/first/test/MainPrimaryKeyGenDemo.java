package com.first.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.first.dao.PrimaryKeyGenDemo;

public class MainPrimaryKeyGenDemo 
{
	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");	
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		PrimaryKeyGenDemo pgd=new PrimaryKeyGenDemo();
	 	//pgd.setId(1);
	    pgd.setName("vinay");
	    Transaction tx=session.beginTransaction();
	    session.save(pgd);
	    tx.commit();
	    System.out.println("inserted sucessfully");
	}
}
