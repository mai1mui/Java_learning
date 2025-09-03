/*
Mô tả: Duyệt dữ liệu bằng ResultSet cuộn được (scrollable). Hiển thị dòng đầu tiên và dòng cuối cùng
Tổng quan cấu trúc:
    public class Ex06_Scrollable {
        // 1. Khai báo kết nối
        // 2. Constructor kết nối DB + load dữ liệu
        // 3. load() để thực thi truy vấn
        // 4. display() in dòng dữ liệu
        // 5. moveFirst(), moveLast() di chuyển con trỏ
        // 6. main() test chương trình
    }
 */
package session04_JDBC;

import java.sql.*;

public class Ex06_Scrollable {

    //1.Database information
    Connection cnn;
    String user = "sa";
    String password = "127897";
    String database = "stronghold";

    //String input
    PreparedStatement st;
    ResultSet rs;

    //2.Constructor
    public Ex06_Scrollable() throws SQLException {
        cnn = zEx01_SQL.winConnect(database);//kết nối DB
        load();//nạp dữ liệu vào ResultSet cuộn được
    }

    //3.load() method
    void load() throws SQLException {
        String query = "select * from item";
        st = cnn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        /*
        TYPE_SCROLL_SENSITIVE: cho phép rs cuộn (first(), last(), previous(), absolute(),...) và nhạy với thay đổi DB
        CONCUR_READ_ONLY: k cho phép cập nhật qua rs
         */
        rs = st.executeQuery();
    }

    // 4. display() method
    void display(String code, String name, int price) {
        String title = String.format("%-15s %-30s %-10s", code, name, price);
        System.out.println(title);

    }

    // 5. moveFirst() method
    void moveFirst() throws SQLException {
        rs.first();//đưa con trỏ về dòng đầu tiên
        var code = rs.getString(1);
        var name = rs.getString(2); //rs.getString("ItemName")
        var price = rs.getInt(3);
        display(code, name, price);
    }

    // 6. moveLast() method
    void moveLast() throws SQLException {
        rs.last();//đưa con trỏ về dòng cuối cùng
        var code = rs.getString(1);
        var name = rs.getString(2); //rs.getString("ItemName")
        var price = rs.getInt(3);
        display(code, name, price);
    }

    // 7. movePre() method
    void movePre() throws SQLException {
        if (rs.previous()) { // Di chuyển về dòng trước, nếu còn
            var code = rs.getString(1);
            var name = rs.getString(2);
            var price = rs.getInt(3);
            display(code, name, price);
        } else {
            System.out.println("Already at the beginning.");
        }
    }

    // 8. moveNext() method
    void moveNext() throws SQLException {
        if (rs.next()) { // Di chuyển tới dòng sau, nếu còn
            var code = rs.getString(1);
            var name = rs.getString(2);
            var price = rs.getInt(3);
            display(code, name, price);
        } else {
            System.out.println("Already at the end.");
        }
    }

    // main() method
    public static void main(String[] args) throws SQLException {
        var ex06 = new Ex06_Scrollable();
        ex06.moveFirst();
        System.out.println("---------------------------------------");
        ex06.moveLast();
    }
}
