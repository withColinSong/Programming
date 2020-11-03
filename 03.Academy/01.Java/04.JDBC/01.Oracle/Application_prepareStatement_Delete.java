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
// DELETE
public class Application7 {

	private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system"; //계정이름
	private static final String DB_PASS = "oracle"; //비밀번호

	public static void main(String[] args) throws ClassNotFoundException{
		// 1. jvm에 클래스 로드 (Oracle JDBC Driver)
		Class.forName("oracle.jdbc.driver.OracleDriver");



		//2. 드라이버 매니저로부터 커넥션 얻어옴
		try(final Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS))

		{
			final String sql = "DELETE FROM jdbc_example WHERE id <= 2";
			final PreparedStatement pstmt = conn.prepareStatement(sql);
			final int affectedRows = pstmt.executeUpdate(); //영향 받은 행을 출력한다.
			System.out.println(affectedRows);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
