package com.first.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.first.dao.OneToOneAccountAnno;
import com.first.dao.OneToOneEmployeeAnno;

public class MainOneToOneAnno 
{
	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		OneToOneAccountAnno ooa=new OneToOneAccountAnno();
		ooa.setAccname("sairamT");
		ooa.setAccno("1112");
		
		OneToOneEmployeeAnno ote=new OneToOneEmployeeAnno();
		ote.setEid("a10");
		ote.setEname("sairam");
		ote.setAcc(ooa);
		Transaction tx=session.beginTransaction();
	 	session.save(ote);
		//session.save(ooa);
		tx.commit();
		OneToOneEmployeeAnno ote1=(OneToOneEmployeeAnno)session.get(OneToOneEmployeeAnno.class,"a10");
		System.out.println("Employee details");
		System.out.println(ote1.getEid()+"  "+ote1.getEname());
		
		OneToOneAccountAnno ooa1=ote1.getAcc();
		System.out.println("Account details");
		
		System.out.println(ooa1.getAccname()+"    "+ooa1.getAccno());
		
		System.out.println("transaction begains");
		
		OneToOneEmployeeAnno ote2=new OneToOneEmployeeAnno();
		OneToOneEmployeeAnno ote3=(OneToOneEmployeeAnno)session.get(OneToOneEmployeeAnno.class,"a1");
	//	session.delete(ote3);
		
		System.out.println("transaction complted");
		session.close();
		factory.close();
	}
}
