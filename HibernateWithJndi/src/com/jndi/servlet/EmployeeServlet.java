package com.jndi.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.ServiceRegistry;

import com.jndi.beans.Employee;




/*@WebServlet("/employeeServ")*/
public class EmployeeServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try{
			/*-------------------First Way---------------*/
			
			/*This Process is used to get DataSource Object from JNDI Registry in tomcat Server.to achieve this we have to provide some configuration 
			 * in configuration file(Default Implimentation is "org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory" Implimentation provided by Tomcat People)
			 * 1)place context.xml file inside META-INF Directory. inside this directory we will write some configuration logic about our database 
			 *  This approach is having some drawbacks.Means this we will be placing inside meta-inf folder if we modified any thing inside this again we have to genrate one more jar file
			 *  And here we have to provide <resource-ref> tag we have to provide in web.xml 
			 *  
			 *  2)Server Context.xml And And here we have to provide <resource-ref> tag we have to provide in web.xml
			 *  having some drawbacks
			 *  
			 *  3)server.xml and context.xml
			 *  Declared in server.xml and providing link in context.xml 
			 *  
			 *  
			 *  Declare This in Server.xml
	           <GlobalNamingResources>
				  <Resource auth="Container" 
				  driverClassName="oracle.jdbc.driver.OracleDriver" 
				  global="jdbc/MyDB" 
				  maxActive="100" 
				  maxIdle="20" 
				  maxWait="10000" 
				  minIdle="5" 
				  name="jdbc/MyDB" 
				  password="system" 
				  type="javax.sql.DataSource" 
				  url="jdbc:oracle:thin:@localhost:1521:XE" 
				  username="system"/>
			  </GlobalNamingResources>
			   
			   
			   Declare This in Context.xml
			   
			     <ResourceLink name="jdbc/MyLocalDB"
	            global="jdbc/MyDB"
	            auth="Container"
	            type="javax.sql.DataSource" />
	            
	            
			Context ctx = null;
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			ctx = new InitialContext();
			Context initCtx  = (Context) ctx.lookup("java:/comp/env");
			DataSource ds = (DataSource) initCtx.lookup("jdbc/MyLocalDB");
			
			System.out.println("DataSource implemented class is "+ds.getClass().getName());
			for(Class classType : ds.getClass().getClasses()){
				System.out.println("Classes are  "+classType.getName());
			}
			
			System.out.println("-------------------------------------------------------------");
			for(Class classType : ds.getClass().getInterfaces()){
				System.out.println("Interfaces are   "+classType.getName());
			}
			
			con = ds.getConnection();
			if(con != null)
			{
				System.out.println("connection is created"+con.getClass().getName());
			}
			else
			{
				System.out.println("connection is not created");
			}*/
			
			
			/*----------------------Second Way-----------------------*/
			
			/* This is by Using Hibernate we are getting Connection Object
			 * Hibernate also will use Internal Connection Pool object insted calling getConnection() every time
			 * That class is "org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl"
			 * But this connetion poll size is very limited it will not sufficient to production use only in devlopment environment
			
				Configuration configuration = new Configuration();
	            configuration.configure("com/jndi/common/hibernate.cfg.xml");
	            System.out.println("Hibernate Configuration loaded");
	             
	            //apply configuration property settings to StandardServiceRegistryBuilder
	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	            System.out.println("Hibernate serviceRegistry created");
	             
	            SessionFactory sessionFactory= configuration.buildSessionFactory(serviceRegistry);
	            Session session = sessionFactory.openSession();
	            Configuration cfg = new Configuration();
	            
	            long i =sessionFactory.getStatistics().getConnectCount();
                System.out.println("no of connections are "+i);
				
	          // This Is Old way of getting session Object 
	             
			  // cfg.configure("com\\hibernate.cfg.xml");
			  // SessionFactory factory = cfg.buildSessionFactory();
			  // Session session=factory.openSession(); 
			
			
					PrintWriter out = response.getWriter();
			        Employee emp = new Employee();
			        emp.setAddress("hyd");
			        emp.setEmpid(11);
			        emp.setEmpname("sairam");
			        Transaction tx = session.beginTransaction();
			        session.save(emp);
			        System.out.println("inserted sucessfully");
			        tx.commit();	 */
			        
			        
		/*------------------Third Way-----------------------*/
		
		 /* This is same as Second Approach but only the difference is that
			Insted of depending on the HibernateInternalConnectionPool we are telling Hibernate to 
			Use Third Party Connection Pooling.When we run the program this way comman lines it will show
			org.hibernate.engine.jdbc.connections.internal.ConnectionProviderInitiator instantiateExplicitConnectionProvider
			INFO: HHH000130: Instantiating explicit connection provider: org.hibernate.connection.C3P0ConnectionProvider
			Nov 21, 2017 6:06:16 PM org.hibernate.c3p0.internal.C3P0ConnectionProvider configure
			
			Configuration configuration = new Configuration();
            configuration.configure("com/jndi/common/hibernate.cfg.xml");
            System.out.println("Hibernate Configuration loaded");
             
            //apply configuration property settings to StandardServiceRegistryBuilder
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");
             
            SessionFactory sessionFactory= configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            
            SessionFactoryImplementor sessionFactoryImplementor = (SessionFactoryImplementor)session.getSessionFactory();
            sessionFactoryImplementor.getConnectionProvider();
           
            
            //This Is Old way of getting session Object 
            //Configuration cfg = new Configuration();
			//cfg.configure("com\\hibernate.cfg.xml");
			//SessionFactory factory = cfg.buildSessionFactory();
			//Session session=factory.openSession(); 
		
		
				PrintWriter out = response.getWriter();
		        Employee emp = new Employee();
		        emp.setAddress("Warangal");
		        emp.setEmpid(15);
		        emp.setEmpname("RamanaReddy");
		        Transaction tx = session.beginTransaction();
		        session.save(emp);
		        System.out.println("inserted sucessfully");
		        tx.commit();*/  
			
			/*------------------Fourth Way-------------------- */
		        
			
			/*
			//This is same as Second and Third Approach but only the difference is that
			//Insted of depending on the HibernateInternalConnectionPool and Third PartyConnectionpool like C3PO,
			//we are using DataSource created by ApplicationServer(Tomcat). i.e "org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory" This DataSource Object will be initialized at the time of server 
			//Start up.No of Objects will created and Will supports Global connetion pooling or not, will it supports global Transactions are not
			//Every thing will be depending on Webserver(Tomcat) Implimenation to DataSource Object.Different server vendors will provide different implimentations
			//Tomcat will use internally "org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory" It is a basic Implimantation as we already discussed in First Approach
			
			Configuration configuration = new Configuration();
            configuration.configure("com/jndi/common/hibernate.cfg.xml");
            System.out.println("Hibernate Configuration loaded");
             
            //apply configuration property settings to StandardServiceRegistryBuilder
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");
             
            SessionFactory sessionFactory= configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            
            SessionFactoryImplementor sessionFactoryImplementor = (SessionFactoryImplementor)session.getSessionFactory();
            sessionFactoryImplementor.getConnectionProvider();
           
            
            //This Is Old way of getting session Object 
            //Configuration cfg = new Configuration();
			//cfg.configure("com\\hibernate.cfg.xml");
			//SessionFactory factory = cfg.buildSessionFactory();
			//Session session=factory.openSession(); 
		
		
				PrintWriter out = response.getWriter();
		        Employee emp = new Employee();
		        emp.setAddress("Warangal");
		        emp.setEmpid(16);
		        emp.setEmpname("Ganesh");
		        Transaction tx = session.beginTransaction();
		        session.save(emp);
		        System.out.println("inserted sucessfully");
		        tx.commit(); */
			
			/*---------------------------Fifth Way ----------------------*/
			
		//	This is same as Second Approach but only the difference is that
		//	Insted of depending on the HibernateInternalConnectionPool we are telling Hibernate to 
		//	Use Third Party Connection Pooling.When we run the program this way comman lines it will show
		//	org.hibernate.engine.jdbc.connections.internal.ConnectionProviderInitiator instantiateExplicitConnectionProvider
		//	INFO: HHH000130: Instantiating explicit connection provider: org.hibernate.connection.C3P0ConnectionProvider
		//	Nov 21, 2017 6:06:16 PM org.hibernate.c3p0.internal.C3P0ConnectionProvider configure
			
			Configuration configuration = new Configuration();
            configuration.configure("com/jndi/common/hibernate.cfg.xml");
            System.out.println("Hibernate Configuration loaded");
             
            //apply configuration property settings to StandardServiceRegistryBuilder
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");
             
            SessionFactory sessionFactory= configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            
            //This Is Old way of getting session Object 
            //Configuration cfg = new Configuration();
			//cfg.configure("com\\hibernate.cfg.xml");
			//SessionFactory factory = cfg.buildSessionFactory();
			//Session session=factory.openSession(); 
		
		
				PrintWriter out = response.getWriter();
		        Employee emp = new Employee();
		        emp.setAddress("West");
		        emp.setEmpid(17);
		        emp.setEmpname("Teja");
		        Transaction tx = session.beginTransaction();
		        session.save(emp);
		        System.out.println("inserted sucessfully");
		        tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
