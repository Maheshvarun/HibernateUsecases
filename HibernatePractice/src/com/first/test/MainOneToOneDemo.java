package com.first.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.first.dao.OneToOneAccount;
import com.first.dao.OneToOneEmployee;
public class MainOneToOneDemo 
{
	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		OneToOneAccount ooa=new OneToOneAccount();
		ooa.setAccname("akshaynalamwar");
		ooa.setAccno("2222");
		
		OneToOneEmployee ote=new OneToOneEmployee();
		ote.setEid("a23");
		ote.setEname("akshay");
		ote.setAcc(ooa);
		
		Transaction tx=session.beginTransaction();
	     //session.save(ote);
		//session.save(ooa);
		tx.commit();
		
		OneToOneEmployee ote1=(OneToOneEmployee)session.get(OneToOneEmployee.class,"a1");
		System.out.println(ote1);
		System.out.println(ote1.getAcc());
		session.close();
		factory.close();
	}

}
