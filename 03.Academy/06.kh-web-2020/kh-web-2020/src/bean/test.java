package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public test() {
		conn = new Application().getConn();
	}
	
	public void login(String a, String b) {
		
		
		try {
			
			final String sql = "SELECT * FROM emp";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
