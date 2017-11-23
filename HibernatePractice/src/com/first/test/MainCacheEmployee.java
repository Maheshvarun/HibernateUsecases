package com.first.test;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.first.dao.CacheEmployee;
public class MainCacheEmployee 
{
	public static void main(String[] args) throws InterruptedException
	{
		Configuration cfg=new Configuration();
  /*cfg.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
	cfg.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/hibernatepurpose");
	cfg.setProperty("hibernate.connection.user","root");
	cfg.setProperty("hibernate.connection.password","root");
	cfg.setProperty("hibernate.connection.dialect","org.hibernate.dialect.MYSQLDialect");
	cfg.setProperty("hibernate.show_sql","true");
	cfg.setProperty("hibernate.hbm2ddl.auto","update");
	cfg.addFile("src\\com\\first\\cfg\\cache.hbm.xml");*/
	
	cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	/*CacheEmployee ce=new CacheEmployee();
	ce.setEid(2);
	ce.setEaddr("hyd");
	ce.setEsal(10000);
	ce.setEname("appstek");
    Transaction	 tx=session.beginTransaction();
	//session.save(ce);
	tx.commit();	*/
	
	CacheEmployee ce1=(CacheEmployee)session.get(CacheEmployee.class,1);
	System.out.println(ce1.getEaddr()+"  "+ce1.getEid()+"  "+ce1.getEname()+" "+ce1.getEsal());
	//session.evict(ce1);
	Session session1 = factory.openSession();
	
	CacheEmployee ce2=(CacheEmployee)session.get(CacheEmployee.class,1);
	System.out.println(ce2.getEaddr()+"  "+ce2.getEid()+"  "+ce2.getEname()+" "+ce2.getEsal());
	

	//Query q=session.createQuery("select eid,ename,esal,eaddr from CacheEmployee where esal>900 order by ename asc");
	//Query q=session.createQuery("select sum(esal) from CacheEmployee group by eid having eid>5");
	//Query q=session.createQuery("select count(esal) from CacheEmployee ");
	Query q=session.createQuery("select esal,eaddr from CacheEmployee where eid=6");
	 // Query q=session.createQuery("select sum(esal) from CacheEmployee");
	 // Query q=session.createQuery("select min(esal) from CacheEmployee");	
	//Query q=session.createQuery("select max(esal) from CacheEmployee");	
	//Query q=session.createQuery("select avg(esal) from CacheEmployee");	
	//Query q=session.createQuery("select (esal-100) from CacheEmployee");
	  //Query q=session.createQuery("select eid,ename,esal,eaddr from CacheEmployee where ename in('sai','ram','vinay')");
	//Query q=session.createQuery("select eid,ename,esal,eaddr from CacheEmployee where eid between 3 and 8");
	//Query q=session.createQuery("select eid,ename,esal,eaddr from CacheEmployee where ename like '%h'");
	//Query q=session.createQuery("select eid,ename,esal,eaddr from CacheEmployee where ename is not null");
	//Query q=session.createQuery("select eid,ename,esal,eaddr from CacheEmployee where esal>? and esal<:sal");
	//Query q=session.createQuery("delete CacheEmployee where ename='chander'");
	 // Query q=session.createQuery("insert into CacheEmployee(ename='vinay',esal=2000,eaddr='gpt')");
	  //Transaction tx=session.beginTransaction();
	  //int i=q.executeUpdate();
	  //System.out.println(i);
	  //tx.commit();
	/*q.setFetchSize(6);
    q.setCacheable(true);
	q.setMaxResults(4);
	q.setFirstResult(1); 
	q.setTimeout(100);*/
	//q.setParameter(0,1006);
	//q.setParameter("sal",1500);
	  List l=q.list();
	 /* for(int i=0;i<l.size();i++)
     	{
		//System.out.println(l.get(i));
		Object[] ce3=(Object[])l.get(i);
		  //System.out.println(ce3[0]+"  "+ce3[1]);
		  //Object ce3=l.get(i);
		//  System.out.println(ce3);
		System.out.println(ce3[0]+"   "+ce3[1]+"   "+ce3[2]+"   "+ce3[3]);
	}*/
	Object[] ce3=(Object[])q.uniqueResult();
	System.out.println(ce3[0]+"  "+ce3[1]+"  "+ce3.getClass()); 
	session.close();
	factory.close();
	}
}