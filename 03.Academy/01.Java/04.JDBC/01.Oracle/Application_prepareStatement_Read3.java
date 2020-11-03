import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;


//prepareStatement 사용
// READ
public class Application5 {

	public static void main(String[] args) throws ClassNotFoundException{
		// 1. jvm에 클래스 로드 (Oracle JDBC Driver)
		Class.forName("oracle.jdbc.driver.OracleDriver");


		//2. 드라이버 매니저로부터 커넥션 얻어옴
		try(final Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system", "oracle");
				) {
		
			final String sql = "SELECT * FROM jdbc_example WHERE id = 4";
			final PreparedStatement pstmt = conn.prepareStatement(sql);
			final ResultSet rs = pstmt.executeQuery();
			// BOF <<<< cursor를 이동시키는게 next
			//20/11/03 11:10:41.000000000
			//EOF
			
			rs.next();
			//1번
//			final int id = rs.getInt(1);
//			final String name = rs.getString(2);
//			final LocalDateTime localDateTime = rs.getTimestamp(3).toLocalDateTime();
//			final String email = rs.getString(4);
//			System.out.println(id);
//			System.out.println(name);
//			System.out.println(localDateTime);
//			System.out.println(email);
			
			//2번
			final int id = rs.getInt("id");
			final String name = rs.getString("name");
			final LocalDateTime localDateTime = rs.getTimestamp("time").toLocalDateTime();
			final String email = rs.getString("emial");
			System.out.println(id);
			System.out.println(name);
			System.out.println(localDateTime);
			System.out.println(email);
			
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
