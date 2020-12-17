package Vo_1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Application {
	Connection conn;
	public static String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static String JDBC_USER = "song";
	public static String JDBC_PW ="1234";
	
	public Application() {
		
		try {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PW);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConn() {
		return conn;
	}
}
