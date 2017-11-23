package com.first.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory.SessionFactoryOptions;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

import com.first.dao.ConnectionPollDemo;

public class MainConnectionPollDemo 
{
    public static void main(String[] args)
    {
    	Configuration cfg = new Configuration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");	
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Statistics stc=factory.getStatistics();
		SessionFactoryOptions sfo=factory.getSessionFactoryOptions();
		
		ConnectionPollDemo cpd=new ConnectionPollDemo();
		cpd.setDesignation("devloper");
		cpd.setId(104);
		cpd.setName("rishib");
		Transaction tx=session.beginTransaction();
		session.save(cpd);
		tx.commit();
		System.out.println("record inserted sucessfully");
		session.close();
		factory.close();
    }
}
