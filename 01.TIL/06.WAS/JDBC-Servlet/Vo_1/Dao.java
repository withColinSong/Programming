package Vo_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public Dao() {
		conn = new Application().getConn();
	}
	
	public List<Vo> getUsers() {
		List<Vo> list = new ArrayList<>();
		
		String sql = "SELECT * FROM emp01";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Vo vo = new Vo();
				vo.setEMPNO(rs.getInt("empno"));
				vo.setENAME(rs.getString("ename"));
				
				list.add(vo);
				
				for(Vo v : list) {
					System.out.println(v);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
		
	}

}
