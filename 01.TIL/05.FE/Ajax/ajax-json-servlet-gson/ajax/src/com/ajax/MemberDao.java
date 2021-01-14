package com.ajax;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public MemberDao() {

		conn = new Application().getConn();
		if(conn == null) {
			System.out.println("연결실패");
					
		}
	}

	public Kh select(String findStr) {
		
		Kh kh = null;
		String sql = "SELECT * FROM kh_tbl WHERE kh_name = ?";
		
		try {
		
			ps = conn.prepareStatement(sql);
			ps.setString(1, findStr);
			rs = ps.executeQuery();

			while(rs.next()) {
				
				kh = new Kh();
				kh.setKh_no(rs.getInt("kh_no"));
				kh.setKh_name(rs.getString("kh_name"));
				kh.setAddr(rs.getString("addr"));
				kh.setFax(rs.getString("fax"));
				
				System.out.println(kh);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kh;

	}


}
