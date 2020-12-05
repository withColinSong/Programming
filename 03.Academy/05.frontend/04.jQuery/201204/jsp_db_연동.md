

1. jdbc 드라이버 파일 복사
    WEB-INF/lib
2. 드라이버 로딩(Class.forName)
3. Connection 

## Connection
```java
package bean;


import java.sql.Connection;
import java.sql.DriverManager;

public class Application {
	Connection conn;
	
	public Application() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", 
					"system", "oracle"
					);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}

	public Connection getConn() {
		return conn;
	}
}

```