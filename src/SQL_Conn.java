import java.sql.*;

public class SQL_Conn {
    private static final String url = "jdbc:mysql://localhost:3306/mydb?";
    private static final String user = "root";
    private static final String pw = "19990331";

    public static void main(String[] args)  {
        try (Connection conn = getConnection()){
            System.out.println("정상적으로 연결되었습니다.");
            //runSQL(conn);
        }catch (SQLException e){
            System.err.println("연결할 수 없습니다");
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pw); //DB 연결 후 커넥션 반환
    }
}
