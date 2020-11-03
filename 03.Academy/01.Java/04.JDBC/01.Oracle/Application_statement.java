import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//statement 사용
public class Application2 {

	public static void main(String[] args) throws ClassNotFoundException{
		// 1. jvm에 클래스 로드 (Oracle JDBC Driver)
		Class.forName("oracle.jdbc.driver.OracleDriver");


		//2. 드라이버 매니저로부터 커넥션 얻어옴
		try(final Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system", "oracle");
				) {
			// 3. 데이터베이스 작업
			//final PreparedStatement pstmt = 
			//conn.prepareStatement("SELECT 1 FROM dual");

			//final ResultSet rs = //query 결과를 담는 객체
			//pstmt.executeQuery(); //query 실행
			//rs.next();
			//int value = rs.getInt(1);
			//System.out.println(value);
      
			final String name = "abc";
			final String sqlFormat = "INSERT INTO jdbc_example VALUES(seq_jdbc_example_pk.nextval, '%s', DEFAULT)"; 
			String sql =  String.format(sqlFormat, name);
			Statement statement = conn.createStatement();
			final int affectedRows = statement.executeUpdate(sql);
			System.out.println(affectedRows);

		}
		catch (SQLException e) {
			e.printStackTrace();
		}


	}//main 끝

}
