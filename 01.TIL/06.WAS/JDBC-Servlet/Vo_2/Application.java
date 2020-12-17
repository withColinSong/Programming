package Vo_2;

import java.sql.Connection;
import java.sql.DriverManager;

public class Application {
	Connection conn;
	
	public static final String JDBC_URL= "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String DB_USER= "song";
	public static final String DB_PW ="1234 ";
	public Application() {
		try {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PW);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConn() {
		return conn;
	}
}
