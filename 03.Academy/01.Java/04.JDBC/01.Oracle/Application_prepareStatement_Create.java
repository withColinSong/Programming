import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//prepareStatement 사용
// 컬럼 email을 추가했을 때
//CREATE
public class Application4 {

	public static void main(String[] args) throws ClassNotFoundException{
		// 1. jvm에 클래스 로드 (Oracle JDBC Driver)
		Class.forName("oracle.jdbc.driver.OracleDriver");


		//2. 드라이버 매니저로부터 커넥션 얻어옴
		try(final Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system", "oracle");
				) {

			final String name = "abc";
			final String email = "abc@gmail.com";
			final String sql = 
					"INSERT INTO jdbc_example VALUES(seq_jdbc_example_pk.nextval, ?, DEFAULT, ?)"; 
			final PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			final int affectedRows = pstmt.executeUpdate();
			System.out.println(affectedRows);
		}

		catch (SQLException e) {
			e.printStackTrace();
		}


	}//main 끝

}
