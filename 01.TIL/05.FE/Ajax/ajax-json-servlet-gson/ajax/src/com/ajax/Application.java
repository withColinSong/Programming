package com.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
	Connection conn;
	
	public static String JDBC_URL= "jdbc:oracle:thin:@localhost:1521:XE";
	public static String JDBC_USER = "examuser";
	public static String JDBC_PW = "1234";
	
	public Application() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PW);
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		return conn;
	}
}
