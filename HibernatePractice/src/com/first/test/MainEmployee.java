package com.first.test;

import java.sql.CallableStatement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.first.dao.Employee;

public class MainEmployee 
{
		public static void main(String[] args) {
			
			Configuration cfg = new Configuration();
			cfg.configure("com\\first\\cfg\\hibernate.cfg.xml");	
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			Query q=session.getNamedQuery("myquery");
			q.setInteger(0,2);
			q.setInteger(1,7);
			List<Employee> l=q.list();
			for(int i=0;i<l.size();i++)
			{
				//Object[] o=(Object[])l.get(i);
				Employee o=(Employee)l.get(i);
			   //System.out.println(o[0]+"  "+o[1]);
				System.out.println(o.getAddress()+"  "+o.getEmpid()+" "+o.getEmpname());
			}
		}
}
