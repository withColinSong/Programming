import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Dao {
	public Memo selectOne(int no) {
		Memo m = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from memo where no = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "system", "oracle");
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Memo();
				m.setNo(rset.getInt(1));
				m.setName(rset.getString(2));
				m.setMsg(rset.getString(3));
				m.setWriteday(rset.getDate(4));				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {   
				rset.close();    
				pstmt.close();    
				conn.close();
			} catch (SQLException e) {    
				e.printStackTrace();
			}
		}
		return m;
	}
}
