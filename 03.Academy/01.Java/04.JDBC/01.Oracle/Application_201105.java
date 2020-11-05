import java.sql.*;

public class Application {

    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DB_USER = "system";
    private static final String DB_PASS = "oracle";

    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 드라이버 로드
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 2. 커넥션 요청
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // 3.1. DB작업 - DQL
            select(connection);
            // 3.2. DB작업 - DML
            dml(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void dml(Connection connection) {
        final String sql = "" +
                "INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)\n" +
                "VALUES (8900, ?, ?, 7698, SYSDATE, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, "신민아");
            pstmt.setObject(2, "MANAGER");
            pstmt.setObject(3, 1500.0);
            pstmt.setObject(4, 0.0);
            pstmt.setObject(5, null);
            final int affectedRows = pstmt.executeUpdate();
            System.out.println(affectedRows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void select(Connection connection) {
        final String sql = "SELECT * FROM emp";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            final ResultSet rs = pstmt.executeQuery();
            // bof, eof
            while(rs.next()) {
                final int empno = rs.getInt("empno");
                final String ename = rs.getString("ename");
                final Integer sal = rs.getInt("sal");
                final Integer comm = rs.getInt("comm");
                System.out.println(empno);
                System.out.println(ename);
                System.out.println(sal);
                System.out.println(comm);
                System.out.println("==========================");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
