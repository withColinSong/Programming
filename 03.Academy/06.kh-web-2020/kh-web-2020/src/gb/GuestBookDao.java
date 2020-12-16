package gb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Application;

public class GuestBookDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public GuestBookDao() {
		conn = new Application().getConn();
	}
	
	public List<GuestBookVo> select(String findStr){
		List<GuestBookVo> list = new ArrayList<GuestBookVo>();
		
		try {
			String sql = " select serial, mid, mdate, doc from guestbook where mid like ? or doc like ? "
					   + " order by serial desc ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + findStr + "%");
			ps.setString(2, "%" + findStr + "%");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				GuestBookVo gb = new GuestBookVo();
				gb.setSerial(rs.getInt("serial"));
				gb.setMid(rs.getString("mid"));
				gb.setMdate(rs.getString("mdate"));
				gb.setDoc(rs.getString("doc"));
				
				list.add(gb);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	}
	
	public String insert(GuestBookVo vo){
		String msg = "방명록이 작성되었습니다.";
		try {
			String sql = " insert into guestbook(serial, mid, pwd, doc, mdate) " 
		               + " values( seq_guestbook.nextval, ?, ?, ?, sysdate )";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,  vo.getMid());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getDoc());
			
			int rowCnt = ps.executeUpdate(); // insert된 행수가 반환됨.
			if(rowCnt<1) {
				msg = "방명록 입력중 오류 발생";
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			msg = ex.getMessage();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return msg;
		}
	}
	
	public String update(GuestBookVo vo){
		String msg = "방명록 내용을 수정하였습니다.";
		try {
			String sql = "update guestbook set doc=? where serial=? and pwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getDoc());
			ps.setInt(2,  vo.getSerial());
			ps.setString(3, vo.getPwd());
			
			int rowCnt = ps.executeUpdate();
			if(rowCnt<1) {
				msg="방명록 수정중 오류 발생";
			}
			
		}catch(Exception ex) {
			msg = ex.getMessage();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return msg;
		}
	}
	
	
	public String delete(GuestBookVo vo){
		System.out.println("serial : " + vo.getSerial());
		System.out.println("pwd : " + vo.getPwd());
		
		
		
		String msg = "방명록이 삭제되었습니다.";
		try {
			String sql = "delete from guestbook where serial=? and pwd=?";
			
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getSerial());
			ps.setString(2, vo.getPwd());
			
			int rowCnt = ps.executeUpdate();
			if(rowCnt<1) {
				msg = " 방명록 삭제중 오류 발생";
			}else {
				conn.commit();
			}
			
		}catch(Exception ex) {
			msg = ex.getMessage();
			conn.rollback();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return msg;
		}
	}
	
	
	/*
	*/
	
}
