import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Application {

	private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system";
	private static final String DB_PASS = "oracle";

	//1. 드라이버 클래스 로드
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//2. 커넥션을 얻는다. - DB에 접속(세션)

		try (final Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				) {
			//3. 데이터버스 작업
			//1.excuteQuery - ResultSet
			test1(conn);

			//2. excuteUpdate - int (영향 받은 행의 수)
			test2(conn);

			//4. 연결종료
		}catch (SQLException throwables) {
			throwables.printStackTrace();

		}

	}


	private static void test3(Connection conn) throws SQLException {
		conn.setAutoCommit(false); //auto commit 설정, true면 켬
		conn.commit(); //commit - 물리적인 저장소에 반영됨
		conn.rollback(); // rollback - 반영할 내용들이 취소됨
		conn.getAutoCommit(); // 현재 auto commit 설정 상태를 나타낸다 true면 켜진상태.

	}


	private static void test2(Connection conn) throws SQLException {
		// 1. 파라미터 세팅 setXXXX(파라미터번호, 값)
		//2. excuteUpdate의 결과는 영향 받은 행의 개수를 나타냄
		String sql = "INSERT INTO bank_account VALUES(?, ? , ?)";
		final PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, 10);
		pstmt.setString(2, "yj");
		pstmt.setLong(3, 10000);
		final int affectedRows = pstmt.executeUpdate();
		System.out.println(affectedRows);
	}


	private static void test1(Connection conn) throws SQLException {
		// 1. prepared statement
		// 2. excuteQuery SLEECT 문 실행
		// 3. 그 결과는 ResultSet
		// 4. cousor

		final String sql = "SELECT * FROM bank_account";
		final PreparedStatement pstmt = conn.prepareStatement(sql);
		final ResultSet resultSet = pstmt.executeQuery();


		while(resultSet.next()) {
			final int id = resultSet.getInt("id");
			final String username = resultSet.getString("username");
			final int balance = resultSet.getInt("balance");
			System.out.println(id);
			System.out.println(username);
			System.out.println(balance);
			System.out.println("--------------------");

		}
	}


}
