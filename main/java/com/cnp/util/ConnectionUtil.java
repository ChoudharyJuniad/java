package com.cnp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtil {
	public static Connection getConnection() {
		Connection con = null;

		   try {
			   Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coupon","root","open1234");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 
		 

		/*
		 * try { InitialContext context=new InitialContext();
		 * System.out.println(context); DataSource
		 * ds=(DataSource)context.lookup("java:comp/env/my"); con = ds.getConnection();
		 * System.out.println(ds); } catch (NamingException e) {
		 * 
		 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
		 * e.printStackTrace(); }
		 */

		return con;
	}

}
