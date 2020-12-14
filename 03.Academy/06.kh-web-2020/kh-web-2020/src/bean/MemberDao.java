package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
	Connection conn; // database ��������
	PreparedStatement ps; // ���ڿ��� �Ǿ� �ִ� sql ������ sql ���� ����
	ResultSet rs; //  SELECT���� ���� ���
	
	public MemberDao() {
		conn = new Application().getConn();
	}
	
	public boolean login(String mid, String pwd) {
		boolean b = false;
		
		try {
			String sql = "SELECT count(mid) cnt FROM members WHERE mid=? and pwd=? ";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, mid); // ù ��° ����ǥ�� �� ����
			ps.setString(2, pwd); // �� ��° ����ǥ�� �� ����
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
