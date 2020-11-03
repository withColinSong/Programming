import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


//prepareStatement 사용
// READ
public class Application5_2 {

	private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system"; //계정이름
	private static final String DB_PASS = "oracle"; //비밀번호

	public static void main(String[] args) throws ClassNotFoundException{
		// 1. jvm에 클래스 로드 (Oracle JDBC Driver)
		Class.forName("oracle.jdbc.driver.OracleDriver");



		//2. 드라이버 매니저로부터 커넥션 얻어옴
		try(final Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS))
		
		{

			final String sql = "SELECT * FROM jdbc_example"; //sqlDEV에서 확인해본다.
			final PreparedStatement pstmt = conn.prepareStatement(sql);
			final ResultSet rs = pstmt.executeQuery();
			
//			BOF << cousor
//			1	yj	20/11/03 10:52:53.000000000	
//			2	abc	20/11/03 10:57:21.000000000	
//			3	abc	20/11/03 11:02:31.000000000	
//			4	abc	20/11/03 11:10:41.000000000	abc@gmail.com
//			EOF
			
			final List<JdbcExample> list = new ArrayList<>();
			while(rs.next()) {
				final JdbcExample jdbcExample = read(rs);
				list.add(jdbcExample);
			}
			
			for(JdbcExample jdbcExample : list) {
				System.out.println(jdbcExample);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static JdbcExample read(ResultSet rs) throws SQLException{
		final long id = rs.getLong("id");
		final String name = rs.getString("name");
		final LocalDateTime time = rs.getTimestamp("time").toLocalDateTime();
		final String email = rs.getString("emial");
		
		return new JdbcExample(id, name, time, email);
	}
}
