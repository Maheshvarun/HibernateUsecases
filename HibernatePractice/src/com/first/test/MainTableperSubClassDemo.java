package com.first.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.first.dao.TableperSubClassAccountant;
import com.first.dao.TableperSubClassManager;

public class MainTableperSubClassDemo 
{
	public static void main(String[] args) 
	{
        Configuration cfg = new Configuration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		TableperSubClassManager tpm=new TableperSubClassManager();
		tpm.setEid("m-1");
		tpm.setEname("manager");
		tpm.setEmail("manager@gmail,com");
		tpm.setAdress("hyd");
		
		TableperSubClassAccountant tpa=new TableperSubClassAccountant();
		tpa.setEid("a-1");
		tpa.setEname("accountant");
		tpa.setQul("mba");
		tpa.setSal("15000");
		
		TableperSubClassManager tpm1=(TableperSubClassManager)session.get(TableperSubClassManager.class,"m-1");
		TableperSubClassAccountant tpa1=(TableperSubClassAccountant)session.get(TableperSubClassAccountant.class,"a-1");
		Transaction tx=session.beginTransaction();
	//	session.save(tpm);
	//	session.save(tpa);
		System.out.println("manager details");
		System.out.println(tpm1.getEid()+"   "+tpm1.getEname()+"   "+tpm1.getEmail()+"  "+tpm1.getAdress());
		System.out.println("------------------");
		System.out.println("manager details");
		System.out.println(tpa1.getEid()+"   "+tpa1.getEname()+"   "+tpa1.getSal()+"  "+tpa1.getQul());
		tx.commit();
	}
}
