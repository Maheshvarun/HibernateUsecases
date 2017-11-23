package com.first.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.first.dao.TableperSubClassAnnoAcco;
import com.first.dao.TableperSubClassAnnoMana;

public class MainTableperSubClassAnno 
{
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		TableperSubClassAnnoAcco tpsa=new TableperSubClassAnnoAcco();
		tpsa.setEid("a3");
		tpsa.setEname("accountant");
		tpsa.setQul("mba");
		tpsa.setSal("10000");
	
		TableperSubClassAnnoMana tpsm=new TableperSubClassAnnoMana();
		tpsm.setEid("m3");
		tpsm.setEname("manager");
		tpsm.setEmail("manager@gmail.com");
		tpsm.setAdress("hyd");
		System.out.println("transaction begains");	
		
		Transaction tx=session.beginTransaction();
		//session.beginTransaction();
		session.save(tpsm);
		session.save(tpsa);
		tx.commit();
		System.out.println("record inserted sucessfully");
	}
	
}
