/*
Mô tả: CRUD trong DB thông qua PrepareStatement
tổng quan cấu trúc:
    public class Ex04_Prepare_Statement {
       //1. Khai báo biến
       //2. Kết nối DB
       //3. Đóng kết nối
       //4. select()method
       //5. insert()method
       //6. update()method
       //7. delete()method
       //8. main()method
   }

*/
package session04_JDBC;
import java.sql.*;
public class Ex04_Prepare_Statement {
    //1.Database information: khai báo thuộc tính

    Connection cnn;
    String user = "sa";
    String password = "127897";
    String database = "stronghold";

    //Statement st;
    PreparedStatement st;//tránh SQL injection
    ResultSet rs;//biến để chứa kết quả select

    //2. Constructor to connect
    public Ex04_Prepare_Statement() {
        cnn = zEx01_SQL.doConnect(user, password, database);
    }

    //3. closeResources() method
    void closeResources() throws SQLException {
        if ((rs != null) || (st != null) || (cnn != null)) {
            rs.close();
            st.close();
            cnn.close();
        }
    }

    //4. select() method: hiển thị
    void select() throws SQLException {
        //4.1. Query String
        String query = "select* from Item";
        //4.2. ResultSet
        st = cnn.prepareStatement(query);
        rs = st.executeQuery();
        //4.3. Display
        String title = String.format("%-15s %-30s %-10s", "Code", "Name", "Price");
        System.out.println(title);
        System.out.println("-----------------------------------------");

        while (rs.next()) {
            var code = rs.getString("ICode");
            var name = rs.getString(2); //rs.getString("ItemName")
            var price = rs.getInt(3);
            String s = String.format("%-15s %-30s %-10d", code, name, price);
            System.out.println(s);
        }

    }

    //5. insert() method: thêm mới
    void insert(String code, String name, int price) throws SQLException {
        //5.1.Query String
        //String query = "insert into Item values ('" + code + "', '" + name + "', '" + price + "')";
        String query = "insert into Item values (?,?,?)";//dùng ?: chuẩn PreparedStatement, tránh SQL injection.
        //5.2. ResultSet
        st = cnn.prepareStatement(query);
        st.setString(1, code); //(order,var)
        st.setInt(3, price);
        st.setString(2, name);

        int cnt = st.executeUpdate();
        if (cnt == 0) {
            System.err.println("Nothing to insert");
        } else {
            //5.3. Display
            select();
        }
        //5.4. Close Resource
        closeResources();
    }

    //6. update() method: cập nhật 
    void update(String code, String newName, int newPrice) throws SQLException {
        //6.1. Query String
        /*String query = "update Item set ItemName = '" + newName + "', Rate = " + newPrice
                + " where ICode = '" + code + "'";*/
        String query = "update Item set ItemName = ? , Rate = ? where ICode = ?";
        //6.2. Execute update
        st = cnn.prepareStatement(query);
        st.setString(1, newName);
        st.setString(3, code);
        st.setInt(2, newPrice);
        int cnt = st.executeUpdate();
        if (cnt == 0) {
            System.err.println("No record found to update with code: " + code);
        } else {
            //6.3. Display updated data
            System.out.println("Updated successfully!");
            select();
        }
        //6.4. Close Resource
        closeResources();
    }

    //7. delete() method
    void delete(String code) throws SQLException {
        //7.1. Query String
        String query = "delete from Item where ICode = ?";
        //7.2. Execute delete
        st = cnn.prepareStatement(query);
        st.setString(1, code);
        int cnt = st.executeUpdate();
        if (cnt == 0) {
            System.err.println("No record found to delete with code: " + code);
        } else {
            //7.3. Display remaining data
            System.out.println("Deleted successfully!");
            select();
        }
        //7.4. Close Resource
        closeResources();
    }

    //8. main() method
    public static void main(String[] args) throws SQLException {
        var ex04 = new Ex04_Prepare_Statement();

        ex04.select();
        System.out.println("-----------------------------------");
//        ex04.insert("RKSK_test2", "testinsert", 12331);
//        ex04.update("RKSK_test2", "updatedName", 9999);
//        ex04.delete("RKSK_test");
    }
}
