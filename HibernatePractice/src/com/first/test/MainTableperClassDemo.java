package com.first.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.first.dao.*;

public class MainTableperClassDemo 
{
  public static void main(String[] args)
  {
	  Configuration cfg = new Configuration();
		
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");	
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		TableperClassStudent tcs=new TableperClassStudent();
		tcs.setAccName("BharathStudent");
		tcs.setAccNo("s-101");
		tcs.setSbranch("kkply");
		tcs.setSid("s-1001");
		
		TableperClassEmployee tce=new TableperClassEmployee();
        tce.setAccName("Bharathmployee");
        tce.setAccNo("e-101");
        tce.setEdept("accounts");
        tce.setEid("e-1001");
        
        Transaction tx=session.beginTransaction();
    //	session.save(tcs);
    //	session.save(tce);
        TableperClassEmployee tce1=(TableperClassEmployee)session.get(TableperClassEmployee.class,"e-100");
        TableperClassStudent tcs1=(TableperClassStudent)session.get(TableperClassStudent.class,"s-100");
        System.out.println("Employee datails");
        System.out.println(tce1.getAccName()+"  "+tce1.getAccNo()+"   "+tce1.getEid()+"   "+tce1.getEdept());
        System.out.println("-------------");
        System.out.println("Student datails");
        System.out.println(tcs1.getAccName()+"  "+tcs1.getAccNo()+"   "+tcs1.getSbranch()+"   "+tcs1.getSid());
    	tx.commit();
        System.out.println("record inserted sucessfully");
  }
}
