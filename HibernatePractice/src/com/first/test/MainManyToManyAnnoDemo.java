package com.first.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.first.dao.ManyToManyCoursesAnno;
import com.first.dao.ManyToManyStudentAnno;
public class MainManyToManyAnnoDemo 
{
   public static void main(String[] args)
   {
    	Configuration cfg = new Configuration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
        
		ManyToManyCoursesAnno mmc=new ManyToManyCoursesAnno();
		mmc.setCid("01");
		mmc.setCname("java");
        
		ManyToManyCoursesAnno mmc1=new ManyToManyCoursesAnno();
		mmc1.setCid("02");
		mmc1.setCname("php");
		
		Set<ManyToManyCoursesAnno> s1=new HashSet<ManyToManyCoursesAnno>();
		s1.add(mmc);
		s1.add(mmc1);
		
		//Set<ManyToManyCourses> s2=new HashSet<ManyToManyCourses>();
		//s2.add(mmc);
		
		ManyToManyStudentAnno mms=new ManyToManyStudentAnno();
		mms.setSid("s1");
		mms.setSname("sai");
        mms.setCourse(s1);
		
		ManyToManyStudentAnno mms1=new ManyToManyStudentAnno();
		mms1.setSid("s2");
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
