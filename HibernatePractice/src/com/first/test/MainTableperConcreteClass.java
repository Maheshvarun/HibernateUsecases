package com.first.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.first.dao.TableperConcreteClassCustomer;
import com.first.dao.TableperConcreteClassEmployee;
import com.first.dao.TableperConcreteClassPerson;

public class MainTableperConcreteClass 
{
   public static void main(String[] args)
   {
	   Configuration cfg = new Configuration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		TableperConcreteClassCustomer tpcc=new TableperConcreteClassCustomer();  
		tpcc.setPaddr("hyd");
		tpcc.setPnmae("ta");
		tpcc.setCid("c7");
		tpcc.setCmobile("9701136377");
		
		TableperConcreteClassEmployee tpcm=new TableperConcreteClassEmployee();
		tpcm.setEid("e7");
		tpcm.setEsal("15000");
		tpcm.setPaddr("warangal");
		tpcm.setPnmae("ch");
		
		
		Transaction tx=session.beginTransaction();
		session.save(tpcm);
		session.save(tpcc);
		tx.commit();
		System.out.println("record inserted sucessfully");
		session.close();
		factory.close();
   }
}
