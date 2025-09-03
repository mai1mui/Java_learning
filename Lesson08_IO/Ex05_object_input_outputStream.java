/*Mô tả: minh họa cách sử dụng ObjectOutputStream và ObjectInputStream để ghi và đọc đối tượng vào/ra file
Đây là ví dụ cụ thể cho Serialization và Deserialization – một chủ đề rất quan trọng trong Java khi làm việc với lưu trữ dữ liệu phức tạp.
.bin - 1 file nhị phân
Mục đích:
- ghi (serialize) một đối tượng DoiTuong vào file nhị phân .bin.
- đọc (deserialize) đối tượng đó trở lại từ file.
- ứng dụng: lưu dssv. ghi nhớ trạng thái chương trình, gửi object qua mạng,...
*/
package session02_IO;
//1.Đối tượng
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//tạo lớp DoiTuong
class DoiTuong implements Serializable{
    /*implements Serializable: cho phép tuần tự hóa (serialize) đối tượng: biến object thành chuỗi byte để ghi vào file*/
    String code,name;
    //insert Parameterized constructor
    public DoiTuong(String code, String name) {
        this.code = code;
        this.name = name;
    }
    //insert toString() method
    @Override
    public String toString() {
        return "DoiTuong{" + "code=" + code + ", name=" + name + '}';
    } 
}
//2.main()class
public class Ex05_object_input_outputStream {
    //2.1.tạo đối tượng file trong thư mục hiện hành
    String path="src/session02_IO/zEx05.bin";
    File file=new File(path);
    //2.2.saveFile() method: ghi đối tượng vào file
    void saveFile(){
        DoiTuong doituong = new DoiTuong("student: ", "Le Van A");
        ObjectOutputStream os= null;
        try {
            FileOutputStream fos = new FileOutputStream(file,true);
            os=new ObjectOutputStream(fos);
            os.writeObject(doituong);//ghi toàn bộ đối tượng doituong xuống file dưới dạng nhị phân
            
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
    //2.3.readFile() method: đọc đối tượng từ file
    void readFile(){
        try {
            //FileInputStream: đọc dữ liệu vào file
            FileInputStream fis=new FileInputStream(file);
            //ObjectInputStream: đọc dữ liệu nhị phân và khôi phục thành object
            ObjectInputStream is=new ObjectInputStream(fis);
            DoiTuong doituong=(DoiTuong) is.readObject();
            
        } catch (IOException e) {
            System.err.println(e.toString());
        }catch  (ClassNotFoundException e) {
            /*ClassNotFoundException e: ngoại lệ khi k tìm thấy class DoiTuong trong quá trình giải mã object*/
            System.err.println(e.toString());
        }
    }
    //2.4.main() method
    public static void main(String[] args) {
        var ex05 = new Ex05_object_input_outputStream();
        ex05.saveFile();
        ex05.readFile();
    }
}
