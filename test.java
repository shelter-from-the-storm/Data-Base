import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL_Conn {
    private static final String url = "jdbc:mysql://localhost:3306/mydb?serverTimeZone=UTC";
    private static final String user = "root";
    private static final String pw = "19990331";


    public static void main(String[] args)  throws SQLExeption {

        try (Connection conn = getConnection()){
            System.out.println("정상적으로 연결되었습니다.");
            runSQL(conn);
        }catch (SQLException e){
            System.err.println("연결할 수 없습니다");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pw); //DB 연결 후 커넥션 반환
    }

    private static void runSQL(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()){
            getResult(stmt);
        }
    }

    private static void getResult(Statement stmt) throws SQLException {
        String sql = "SELECT Fname, Salary From EMPLOYEE WHERE sex = 'M'";
        String fname;
        double salary;

        try (ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                fname = rs.getString(1);
                salary = rs.getDouble("salary");
                System.out.printf("Fname : %s Salary : %f\n", fname,salary);
            }
        }
    }
}
