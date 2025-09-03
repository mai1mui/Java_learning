/*
Mô tả: CRUD trong DB
Tổng quan cấu trúc:
    public class Ex03_Statement {
        //1. Thuộc tính
        //2. Constructor kết nối DB
        //3. closeResource(): đóng tài nguyên
        //4. read(): đọc dữ liệu bảng item
        //5. create(): thêm dữ liệu mới
        //6. update(): cập nhật dòng
        //7. delete(): xóa dòng
        //8. main(): để gọi test
    }

*/

package session04_JDBC;
import java.sql.*;
public class Ex03_Statement {

    //1.Databaseinformation: khai báo thuộc tính
    Connection cnn;//kết nối đến DB
    String user = "sa";
    String password = "127897";
    String database = "stronghold";

    Statement st;//tạo lệnh SQL
    ResultSet rs;//chứa kết quả select

    //2.Contructor
    public Ex03_Statement() {
        cnn = zEx01_SQL.doConnect(user, password, database);

    }

    //3.closeResource()method: đóng phương thức- đảm bảo giải phóng tài nguyên JDBC sau khi dùng
    void closeResource() throws Exception {
        if ((rs != null) | (st != null) | (cnn != null)) {
            rs.close();
            st.close();
            cnn.close();
        }
    }

    //4.read()method
    void read() throws Exception {
        //4.1.Query String
        String query = "select * from item";
        //4.2.ResultSet
        st = cnn.createStatement();//createStatement(): thực hiện select
        rs = st.executeQuery(query);//chỉ chạy ở đây
        //4.3.display()method: hiển thị
        String title = String.format("%-15s | %-30s | %-10s", "Code", "Name", "Price");
        System.out.println(title);
        System.out.println("---------------------------------------------------------");

        //vòng lặp
        while (rs.next()) {
            //lấy cột thứ 1
            var code = rs.getString("ICode");
            //lấy cột thứ 2
            var name = rs.getString(2);
            //lấy cột thứ 3
            var price = rs.getInt(3);
            String s = String.format("%-15s | %-30s | %-10d", code, name, price);
            System.out.println(s);
        }
        //4.4.Close Resource
        closeResource();
    }

    //5.create()method: thêm mới-ghép chuỗi để thực hiện insert
    void create(String code, String name, int price) throws Exception {
        //5.1.Query String
        String query = "insert into item values ('" + code + "','" + name + "'," + price + ")";
        //5.2.ResultSet
        st = cnn.createStatement();
        int cnt = st.executeUpdate(query);//executeUpdate(): trả về số dòng bị ảnh hưởng
        //nếu số dòng =0-> báo 'nothing'-> ngược lại hiển thị kết quả
        if(cnt==0){
            System.err.println("Nothing!");
        }else{
            //5.3.display()method
            read();
        }
        
        //5.4.Close Resource
        closeResource();
    }

    //6.update()method: cập nhật
    void update(String code, String name, int price) throws Exception {
        //6.1.Query String
        String query="update item set ItemName ='"+name+"', Rate="+price+" where ICode ='"+code+"';";
        //6.2.ResultSet
        st = cnn.createStatement();
        int cnt = st.executeUpdate(query);
        
        if(cnt==0){
            System.err.println("Nothing!");
        }else{
            //6.3.display()method
            read(); 
        }
        //6.4.Close Resource
        closeResource();
    }

    //7.delete()method: xóa dòng
    void delete(String code) throws Exception {
        //7.1.Query String
        String query="delete from item where ICode ='"+code+"';";
        //7.2.ResultSet
        st = cnn.createStatement();
        int cnt = st.executeUpdate(query);
        
        if(cnt==0){
            System.err.println("Nothing!");
        }else{
            //7.3.display()method
            read(); 
        }
        //7.4.Close Resource
        closeResource();

    }

    //8.main()mehthod
    public static void main(String[] args) throws Exception {
//        new Ex03_Statement().read();
//        new Ex03_Statement().create("1","WER-SD",230);
//        new Ex03_Statement().update("1","WER-S",430);
          new Ex03_Statement().delete("1");
    }
}
