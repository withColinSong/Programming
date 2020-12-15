package guestbook;

import java.util.*;

import bean.Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestBookDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public GuestBookDao() {
		conn = new Application().getConn();
	}

	public List<GuestBookVo> select(String findStr) {
		
		List<GuestBookVo> list = new ArrayList<>();

		try {
			String sql = "SELECT serial, mid, mdate, doc FROM guestbook WHERE mid LIKE ? OR doc LIKE ? "
					+ "ORDER BY serial DESC";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + findStr + "%");
			ps.setString(2, "%" + findStr + "%");

			rs = ps.executeQuery();
			
			while(rs.next()) {
				GuestBookVo guestbook = new GuestBookVo();
				guestbook.setSerial(rs.getInt("serial"));
				guestbook.setMid(rs.getString("mid"));
				guestbook.setMdate(rs.getString("mdate"));
				guestbook.setDoc(rs.getString("doc"));
				
				list.add(guestbook);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	}

	/*
	update() {

	}

	insert() {

	}

	deleter() {

	}
	*/

}
