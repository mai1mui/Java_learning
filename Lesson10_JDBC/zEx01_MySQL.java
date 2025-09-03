
package session04_JDBC;
import java.sql.*;
public class zEx01_MySQL {
    static Connection cnn;
    public static Connection doConnect(String user, String password, String database){
        String dbURL="jdbc:mysql://localhost;trustServerCertificate=true;databaseName="+database;
        try {
            cnn=DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return cnn;
    }
    
}
