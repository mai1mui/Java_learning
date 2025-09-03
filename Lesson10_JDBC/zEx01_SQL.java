
package session04_JDBC;
import java.sql.*;
public class zEx01_SQL {
    static Connection cnn;
    //doConnect
    /* biến kết nối toàn cục và duy nhất cho cả class*/
    public static Connection doConnect(String user, String password, String database){
        String dbURL="jdbc:sqlserver://localhost:1433;trustServerCertificate=true;databaseName="+database;
        /*
        localhost:1433- cổng mặc định
        trustServerCertificate=true- bỏ qua cảnh báo SSL
        */
        try {
            cnn=DriverManager.getConnection(dbURL, user, password);
            /*
            truy cập DB bằng URL+ user+pass
            kết nối thành công sẽ gán vào biến cnn và trả về
            */
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return cnn;
    }
    //winConnect()
    public static Connection winConnect(String database) {
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=" + database + ";trustServerCertificate=true;integratedSecurity=true;";
        try {
            cnn = DriverManager.getConnection(dbURL);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return cnn;

    }
    //test kết nối
    public static void main(String[] args) {
        Connection conn = doConnect("sa", "127897", "stronghold");
        if (conn != null) {
            System.out.println("Connection successful.");
        } else {
            System.err.println("Connection failed!");
        }
    }
    
}
