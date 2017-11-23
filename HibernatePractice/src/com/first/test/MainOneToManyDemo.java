package com.first.test;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.first.dao.OneToManyBranch;
import com.first.dao.OneToManyStudent;
public class MainOneToManyDemo 
{
	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
        
		OneToManyStudent oms=new OneToManyStudent();
		oms.setSid("0370");
		oms.setSname("akshay");
		
		OneToManyStudent oms1=new OneToManyStudent();
		oms1.setSid("0371");
		oms1.setSname("rishib");
		
		Collection<OneToManyStudent> lhs=new HashSet<OneToManyStudent>();
		lhs.add(oms);
		lhs.add(oms1);
		
		OneToManyBranch omb=new OneToManyBranch();
		omb.setBid("04");
		omb.setBname("electrical");
		omb.setStds(lhs);
		Transaction tx=session.beginTransaction();
	  //session.save(omb);
		//session.delete(omb4);
		tx.commit();
		OneToManyBranch omb4=(OneToManyBranch)session.get(OneToManyBranch.class,"03");
		System.out.println("branch details");
		System.out.println(omb4.getBid()+"   "+omb4.getBname());
		Collection<OneToManyStudent> p=omb4.getStds();
		Iterator<OneToManyStudent> i=p.iterator();
		System.out.println("Students belongs to particular branch");
		while(i.hasNext())
		{
			OneToManyStudent oms3=i.next();
			System.out.println(oms3.getSid()+"   "+oms3.getSname());
		}
		System.out.println("record inserted sucessfully");
	}	
}
