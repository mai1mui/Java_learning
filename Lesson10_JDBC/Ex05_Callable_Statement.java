/*
Mô tả: gọi stored procedure từ Java thông qua CallableStatement, truy xuất dữ liệu từ bảng Item theo ICode.
???stored procedure(thủ tục được lưu trữ) là gì?
    - là 1 tập lệnh SQL dc lưu trữ trong DB giúp thực thi nhanh và bảo mật
    - có thể nhận tham số đầu ra/vào
    - dc gọi từ ứng dụng java, C#, SQL,...
tổng quan cấu trúc:
    public class Ex05_Callable_Statement {
        //1. Khai báo thông tin DB
        //2. Kết nối DB
        //3. Hiển thị dữ liệu (gọi stored procedure)-tạo trong SQLServer
        //4. main() để chạy test
    }

*/
package session04_JDBC;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Ex05_Callable_Statement {
    //1.Database information
    Connection cnn;
    String user = "sa";
    String password = "127897";
    String database = "stronghold";
    CallableStatement st;
    ResultSet rs;

    //2. Constructor to connect
    public Ex05_Callable_Statement() {
        cnn = zEx01_SQL.doConnect(user, password, database);
    }
    //3. Display

    void display(String code) throws SQLException {
        //3.1. Query String
        //String query = "{call spItem (?)}";
        String query = "exec spItem ?";
        //3.2. ResultSet
        st = cnn.prepareCall(query);//dùng để gọi stored procedure
        st.setString(1, code);
        rs = st.executeQuery();
        //3.3. Display
        String title = String.format("%-15s %-30s %-10s", "Code", "Name", "Price");
        System.out.println(title);
        System.out.println("-----------------------------------------");
        //vòng lặp duyệt ResultSet
        while (rs.next()) {
            var icode = rs.getString("ICode");
            var name = rs.getString(2); //rs.getString("ItemName")
            var price = rs.getInt(3);
            String s = String.format("%-15s %-30s %-10d", icode, name, price);
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws SQLException {
        new Ex05_Callable_Statement().display("RKSK-T");
    }
}
