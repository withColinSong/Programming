package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
	Connection conn; // database 연결정보
	PreparedStatement ps; // 문자열로 되어 있는 sql 문장을 sql 실행 문장
	ResultSet rs; //  SELECT문의 실행 결과
	
	public MemberDao() {
		conn = new Application().getConn();
	}
	
	public boolean login(String mid, String pwd) {
		boolean b = false;
		
		try {
			String sql = "SELECT count(mid) cnt FROM members WHERE mid=? and pwd=? ";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, mid); // 첫 번째 물음표의 값 지정
			ps.setString(2, pwd); // 두 번째 물음표의 값 지정
			rs = ps.executeQuery();
	
			if(rs.next()) {
				int cnt = rs.getInt("cnt"); // Alias cnt
				if(cnt >= 1 ) {
					b = true;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			return b;
		}
				
	}
}