package com.revature.rkiesling.project1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class JDBCConnection {
		
	public static Connection getJDBCConnection () {
		/* 
		 *  Connect to the DBMS set in the 
		 *  following environment variables:
		 *  
		 *    db_user
		 *    db_password
		 *    db_url
		 */
		String username = System.getenv("db_user");
		String password = System.getenv("db_password");
		String url = System.getenv("db_url");

		Connection con = null;

		try {
			DriverManager.registerDriver(new Driver ());
			con = DriverManager.getConnection
					(url, username, password);
			con.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println (e.getMessage ());
		}	
		
		return con;
	}	
}	
	