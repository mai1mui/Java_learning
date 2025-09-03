/*
Mục đích: 
- Biết cách đọc file .properties trong Java.
- Hiểu cách sử dụng lớp Properties trong thư viện chuẩn để quản lý các cặp key-value (thường dùng để lưu cấu hình, thông báo, message...).
- Thao tác với đọc file, dùng FileReader, Properties.load().

*/
package session05_theEnd;
import java.io.FileReader;//đọc nội dung văn bản từ file
import java.io.IOException;//xử lý lỗi khi đọc file
import java.util.Properties;//class chứa cặp key-value

public class Ex03_Properties {
    public static void main(String[] args) throws IOException{
        //truy xuất vài file zEx02_vi_VN.properties
//        FileReader reader=new FileReader("src/session05_theEnd/zEx02_vi_VN.properties");
//        Properties prop = new Properties();//khởi tạo đối tượng rỗng
//        prop.load(reader);//load dữ liệu từ file vào đối tượng-đọc nội dung file và lưu vào prop
//        
//        System.out.println(prop.getProperty("greetings"));
//        System.out.println(prop.getProperty("farewell"));
//        System.out.println(prop.getProperty("inquiry"));
        
        //truy xuất vài file zEx02_en_USA.properties
        FileReader reader = new FileReader("src/session05_theEnd/zEx02_en_USA.properties");
        Properties prop = new Properties();
        prop.load(reader);
        
        System.out.println(prop.getProperty("greetings"));
        System.out.println(prop.getProperty("farewell"));
        System.out.println(prop.getProperty("inquiry"));
    }
}
