
package session04_JDBC;
import java.sql.*;
public class Ex01_DBConnection {
    //1.Database Information
    Connection cnn;
    String user, password, database;
    //2.Constructor connect to database
    public Ex01_DBConnection( String user, String password, String database) {
        this.user = user;
        this.password = password;
        this.database = database;
    }
    //3.test SQL Server
    void testSQL(){
        //3.1.Connect
        cnn=zEx01_SQL.doConnect(user, password, database);
        //3.2.Test
        if(cnn==null){
            System.out.println("Connection fails!");
        }else{
            System.out.println("Congratulation!");
        }
    }
    //4.test MySQL
    void testMySQL(){
        //3.1.Connect
        cnn=zEx01_MySQL.doConnect(user, password, database);
        //3.2.Test
        if(cnn==null){
            System.out.println("Connection fails!");
        }else{
            System.out.println("Congratulation!");
        }
    }
    //5.main()method
    public static void main(String[] args) {
        var sql=new Ex01_DBConnection( "sa","127897", "stronghold");
        sql.testSQL();
//        var mysql=new Ex01_DBConnection( "root","", "localhost");
//        mysql.testMySQL();
        
    } 
    
}
