package com.first.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.first.dao.ManyToManyCourses;
import com.first.dao.ManyToManyStudent;

public class MainManyToManyDemo 
{
   public static void main(String[] args)
   {
    	Configuration cfg = new Configuration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
        
		ManyToManyCourses mmc=new ManyToManyCourses();
		mmc.setCid("06");
		mmc.setCname("java");
        
		ManyToManyCourses mmc1=new ManyToManyCourses();
		mmc1.setCid("07");
		mmc1.setCname("php");
		
		Set<ManyToManyCourses> s1=new HashSet<ManyToManyCourses>();
		s1.add(mmc);
		s1.add(mmc1);
		
		//Set<ManyToManyCourses> s2=new HashSet<ManyToManyCourses>();
		//s2.add(mmc);
		
		
		ManyToManyStudent mms=new ManyToManyStudent();
		mms.setSid("s6");
		mms.setSname("sai");
        mms.setCourse(s1);
		
		ManyToManyStudent mms1=new ManyToManyStudent();
		mms1.setSid("s7");
		mms1.setSname("rishabh");
		mms1.setCourse(s1);
		
		Transaction tx=session.beginTransaction();
		session.save(mms);
		session.save(mms1);
		tx.commit();
		
		System.out.println("record inserted sucessfully");
		session.close();
		factory.close();
   }
}
