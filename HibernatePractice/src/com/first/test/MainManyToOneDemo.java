package com.first.test;

import java.util.Collection;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.first.dao.ManyToOneBranch;
import com.first.dao.ManyToOneStudent;

public class MainManyToOneDemo 
{
   public static void main(String[] args)
   {
	   Configuration cfg = new Configuration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
       
		ManyToOneBranch mob=new ManyToOneBranch();
		mob.setBid("04");
		mob.setBname("computers");
		
		ManyToOneStudent mos1=new ManyToOneStudent();
		mos1.setSid("0360");
		mos1.setSname("venkatesh");
		mos1.setBid(mob);
        
		ManyToOneStudent mos2=new ManyToOneStudent();
		mos2.setSid("0361");
		mos2.setSname("jeevan");
		mos2.setBid(mob);
	   
		Transaction tx=session.beginTransaction();
		session.save(mos1);
		session.save(mos2);
		tx.commit();
		
		System.out.println("record inserted sucessfully");
		session.close();
		factory.close();
   }
}