package com.first.test;
import java.util.List;
import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.first.dao.Account;
public class AccountMain 
{
	public static void main(String[] args)
	{
	Configuration cfg = new Configuration();
	cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");	
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	Query q=session.createQuery("from Account");
	Filter f=session.enableFilter("myfilter");
	f.setParameter("myparam","");
	List l=q.list();
	for(int i=0;i<l.size();i++)
	{
		Account a=(Account)l.get(i);
		System.out.println(a.getAccNo()+"   "+a.getAccName()+"   "+a.getAccBranch()+"  "+a.getAccType());
	}
	}
}
