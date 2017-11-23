package com.first.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.first.dao.ManyToOneBranchAnno;
import com.first.dao.ManyToOneStudentAnno;
public class MainManyToOneAnnoDemo 
{
   public static void main(String[] args)
   {
	    Configuration cfg = new Configuration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
       
		ManyToOneBranchAnno mob=new ManyToOneBranchAnno();
		mob.setBid("03");
		mob.setBname("computers");
		
		ManyToOneStudentAnno mos1=new ManyToOneStudentAnno();
		mos1.setSid("375");
		mos1.setSname("venkatesh");
		mos1.setBid(mob);
        
		ManyToOneStudentAnno mos2=new ManyToOneStudentAnno();
		mos2.setSid("0376");
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
