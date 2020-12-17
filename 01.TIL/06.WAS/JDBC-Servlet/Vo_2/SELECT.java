package Vo_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SELECT {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public SELECT() {
		conn = new Application().getConn();
	}
	
	public List<Vo> SELECT() throws SQLException {
		List<Vo> list = new ArrayList<>();
		
		String sql = "SELECT ename, job FROM INTABLE WHERE ename = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, "song");
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Vo vo = new Vo();
			vo.setENAME(rs.getString("ename"));
			vo.setJOB(rs.getString("job"));
			
			list.add(vo);
			
			for (Vo v : list) {
				System.out.println(v);
			}
		}
		
		return list;
	}
	
}
