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

	public String insert(GuestBookVo vo) {
		String msg = "방명록이 작성되었습니다.";
		try {
			String sql = "INSERT INTO guestbook(serial, mid, pwd, doc, mdate) VALUES (seq_guestbook.nextval, ?, ?, ?, SYSDATE)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getMid());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getDoc());
		
			int rowCnt = ps.executeUpdate(); // insert된 행수가 반환됨.
			if(rowCnt < 1) {
				msg = "방명록 입력 중 오류 발생";
			}
			
			
		} catch(Exception e) {
			 e.printStackTrace();
			 msg = e.getMessage();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return msg;
		}
	}
	
	/*
	update() {

	}

	

	deleter() {

	}
	*/

}
