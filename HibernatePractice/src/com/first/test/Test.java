package com.first.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.first.dao.Employee;

public class Test {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");
			
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Criteria c = (Criteria)session.createCriteria(Employee.class);
		Criterion c1=Restrictions.gt("empid",2);
		Criterion c2=Restrictions.lt("empid",6);
		c.add(c1);
		c.add(c2);
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property("empid"));
		pl.add(Projections.property("empname"));
		pl.add(Projections.property("address"));
		c.setProjection(pl);
		c.addOrder(Order.desc("empid"));
		System.out.println(c);
		List l= c.list();
		System.out.println(l);
		for(int i=0;i<l.size();i++)
		{
			Object[] o=(Object[])l.get(i);
			System.out.println(o[0]+"   "+o[1]+"   "+o[2]);
		}
		/*Employee e = new Employee();
		e.setEmpid(2);
		e.setEmpname("Sairam");
		e.setAddress("Friends Colony");
		
		Transaction tx = session.beginTransaction();
		
		Query query=session.getNamedQuery("myquery");
		query.setInteger(0, 2);
		//query.setInteger(0, 2);
		//query.addEntity(Employee.class);
		//Iterator<Employee> l=query.iterate();
		   
		//Query query=session.getNamedQuery("myquerydemo");
	    List<Employee> l=query.list();
		//java.util.List<Employee> list = query.list();
        //System.out.println(list);
   	   for(int i=0;i<l.size();i++)
	    {
	    Employee e1=(Employee)l.get(i);
	    System.out.println(e1.getEmpid()+"    "+e1.getAddress()+"   "+e1.getEmpname());
	    }
		session.save(e);
		tx.commit();
		session.close();
       		
	    session = factory.openSession();
		Employee e3=(Employee)session.get(Employee.class,2);
	    System.out.println(e3.getAddress()+"    "+e3.getEmpid()+"    "+e3.getEmpname());*/
		SQLQuery q=session.createSQLQuery("delete from employee where id=?");
		q.setParameter(0,2);
		Transaction tx = session.beginTransaction();
		System.out.println(q.executeUpdate());
		tx.commit();
		session.close();
	    factory.close();
	}
}