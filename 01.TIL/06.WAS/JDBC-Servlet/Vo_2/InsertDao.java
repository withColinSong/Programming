package Vo_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InsertDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public InsertDao() {
		conn = new Application().getConn();
	}
	
	public void insertUsers() throws SQLException {

		String sql = "INSERT INTO INTABLE (ename, job) VALUES(?,?)";
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, "song");
		ps.setString(2, "develop");
		
		final int affectedRows = ps.executeUpdate();
		System.out.println(affectedRows);

	}
}
