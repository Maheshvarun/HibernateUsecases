package com.first.test;
import java.util.Collection;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.first.dao.OneToManyBranchAnno;
import com.first.dao.OneToManyStudentAnno;
public class MainOneToManyAnnoDemo 
{
	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
        
		OneToManyStudentAnno oms=new OneToManyStudentAnno();
		oms.setSid("0355");
		oms.setSname("nalamar");
		
		OneToManyStudentAnno oms1=new OneToManyStudentAnno();
		oms1.setSid("0356");
		oms1.setSname("talasila");
		
		Collection<OneToManyStudentAnno> lhs=new HashSet<OneToManyStudentAnno>();
		lhs.add(oms);
		lhs.add(oms1);
		
		OneToManyBranchAnno omb=new OneToManyBranchAnno();
		omb.setBid("05");
		omb.setBname("computers");
		omb.setStds(lhs);
		
		Transaction tx=session.beginTransaction();
		session.save(omb);
		tx.commit();
		
		System.out.println("record inserted sucessfully");
	}	
}
