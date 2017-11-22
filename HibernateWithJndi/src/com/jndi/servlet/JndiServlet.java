package com.jndi.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
//@WebServlet("/hello")
public class JndiServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Context ctx = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
		ctx = new InitialContext();
		Context initCtx  = (Context) ctx.lookup("java:/comp/env");
		DataSource ds = (DataSource) initCtx.lookup("jdbc/MyLocalDB");
		con = ds.getConnection();
		System.out.println(con);
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from employee");
		PrintWriter out = response.getWriter();
        while(rs.next())
        {
            System.out.println(rs.getInt("id")+"  "+rs.getString("name") +"    "+rs.getString("address"));
        }
        out.print("Database Details");
        out.print("Database Product: "+con.getMetaData().getDatabaseProductName());
        out.print("Database Driver: "+con.getMetaData().getDriverName());
	}catch(NamingException e){
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally
	{
		   try {
			    rs.close();
			    stmt.close();
			    con.close();
			    ctx.close();
		       } catch (SQLException e) {
			    System.out.println("Exception in closing DB resources");
		       } catch (NamingException e) {
			    System.out.println("Exception in closing Context");
	}
		
	}
}
}
