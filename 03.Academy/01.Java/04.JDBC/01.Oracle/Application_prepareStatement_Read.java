import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;


//prepareStatement 사용
// READ

public class Application5_1 {

	private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system"; //계정이름
	private static final String DB_PASS = "oracle"; //비밀번호

	public static void main(String[] args) throws ClassNotFoundException{
		// 1. jvm에 클래스 로드 (Oracle JDBC Driver)
		Class.forName("oracle.jdbc.driver.OracleDriver");



		//2. 드라이버 매니저로부터 커넥션 얻어옴
		try(final Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS))

		{

			final String sql = "SELECT * FROM jdbc_example WHERE id = 4"; //sqlDEV에서 확인해본다.
			final PreparedStatement pstmt = conn.prepareStatement(sql);
			final ResultSet rs = pstmt.executeQuery(); //이 때 쿼리가 실행된다.
			//executeQuery를 생성하면 아래처럼 실행되고 데이터를 가져온다.

			//BOF <<<cousor -- 파일의 시작을 알림
			//4	abc	20/11/03 11:10:41.000000000	abc@gmail.com
			//EOF -- 파일의 끝을 알림

			rs.next(); //rs.next()를 생성해야 커서가 원하는 행으로부터 값을 추출한다.

			// BOF 
			//4	abc	20/11/03 11:10:41.000000000	abc@gmail.com <<<cousor
			//EOF			

			//next() boolean으로 다음 행이 있으면 true
			//next() 메소드는 EOF를 만나면 false로 메소드가 끝이난다.

			final int id = rs.getInt(1);
			final String name = rs.getString(2);
			final LocalDateTime time = rs.getTimestamp(3).toLocalDateTime();
			final String email =  rs.getString(4);

			System.out.println(id);
			System.out.println(name);
			System.out.println(time);
			System.out.println(email);

		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
