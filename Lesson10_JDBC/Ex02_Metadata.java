/*
Mô tả: hiển thị thông tin các cột (tên và kiểu dữ liệu) của bảng item trong DB stronghold
bằng cách sd rs(ResultSet) trong JDBC
Cấu trúc chương trình:
    public class Ex02_Metadata {
        // 1. Thông tin cơ sở dữ liệu
        // 2. Constructor: Kết nối database
        // 3. Method display(): Lấy metadata và hiển thị
        // 4. main(): Gọi display()
    }
*/
package session04_JDBC;
import java.sql.*;
public class Ex02_Metadata {
    //1.Database information: khai báo các thuộc tính
        Connection cnn;//đối tượng JDBC để kết nối DB
        String user="sa";//tk SQLServer
        String password="127897";
        String database="stronghold";//tên DB
    //2.Contructor to connect: kết nối đến DB khi tạo đối tượng
    public Ex02_Metadata(){
        cnn=zEx01_SQL.doConnect(user, password, database);
    }
    //3.display()method
    void display(){
        //3.1.Query String
        String query ="select * from item";
        try {
            //3.2.Create ResultSet to item table
            ResultSet rs=cnn.createStatement().executeQuery(query);//ResultSet: tập hợp truy vấn SQL
            ResultSetMetaData meta=rs.getMetaData();//meta: đối tượng lưu thông tin của ResultSet
            
            //3.3.Get number of columns in item: lấy số lượng cột
            int columns=meta.getColumnCount();
            
            //3.4.Display information.Bắt đầu Col=1
            System.out.println("Item(table) Information: \n");
            System.out.println("----------------------------------------");
            String title= String.format("%10s | %-10s", "Fields","Datatype");
            System.out.println(title);
            
            //vòng lặp: lặp qua từng cột để lấy thông tin
            for(int i=1; i<=columns;i++){
                String field=meta.getColumnName(i);
                String type=meta.getColumnTypeName(i);
                
                String s= String.format("%10s | %-10s", field,type);
                System.out.println(s);
            }
            /*Note: index cột trong JDBC bắt đầu =1*/
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }
    //4.main()method
    public static void main(String[] args) {
        new Ex02_Metadata().display();
    }
    
}
