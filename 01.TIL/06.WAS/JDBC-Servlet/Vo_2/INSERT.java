package Vo_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class INSERT {
	Connection conn;
	PreparedStatement rs;
	
	public INSERT() {
		conn = new Application().getConn();
	
	}
	
	public void Addinsert() {
		String sql = "INSERT INTO INTABLE (ename, job) VALUES (?,?)";
		try {
			rs = conn.prepareStatement(sql);
			rs.setString(1, "song1");
			rs.setString(2, "designer");
			
			int printRows = rs.executeUpdate();
			System.out.println(printRows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
