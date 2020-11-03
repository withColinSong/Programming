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
// 트랜젝션
public class Application8 {

	private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system"; //계정이름
	private static final String DB_PASS = "oracle"; //비밀번호

	public static void main(String[] args) throws ClassNotFoundException{
		// 1. jvm에 클래스 로드 (Oracle JDBC Driver)
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//2. 드라이버 매니저로부터 커넥션 얻어옴

		Connection conn  = null;

		try {
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			conn.setAutoCommit(false);
			//			conn.setAutoCommit(true); //매번 저장될 것. 고로 둘다 balace가 0,0이 됨.

			String sql1 = "UPDATE bank_account SET balance = 0 WHERE username = 'A'";
			String sql2 = "UPDATE bank_account SET balance = 1000 WHERE username = 'B'";


			//A의 계좌를 0으로
			final PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			final int affectedRows1 = pstmt1.executeUpdate();
			System.out.println("1:" + affectedRows1);

			if(System.currentTimeMillis() > 0) { //에러발생코드 (의미없음)
				throw new SQLException("롤백 테스트");
			}

			//B의 계좌를 100으로
			final PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			final int affectedRows2 = pstmt2.executeUpdate();
			System.out.println("2:" + affectedRows2);

			conn.commit();
			conn.setAutoCommit(true);


		} catch (SQLException throwables) {
			if(conn != null) {
				try {
					System.out.println("제발 롤백");
					conn.rollback();
				}catch (SQLException e) {
					e.printStackTrace();
				}

			}
			throwables.printStackTrace();

		}finally {
			close(conn);
		}


	}

	private static void close(AutoCloseable closeable) {
		try {
			closeable.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}

//SQL 복구
//--2. 계좌복구
//UPDATE bank_account SET balance = 1000 WHERE username = 'A';
//UPDATE bank_account SET balance = 0 WHERE username = 'B';
//COMMIT;
