/*Mô tả: để ghi và đọc dữ liệu nhị phân (primitive types) bằng DataOutputStream và DataInputStream trong Java
Đặc biệt là các kiểu dữ liệu nguyên thủy(primitive types) như int, double, char,...
???tại sao không ghi/đọc dưới dạng văn bản(text) mà làm việc trực tiếp với byte
- tiết kiệm bộ nhớ
- tăng hiệu suất
??Ưu điểm của cách này
- tốc độ nhanh
- data gọn nhẹ
- phù hợp lưu trữ số, điểm số, dữ liệu nhạy cảm không cần đọc thủ công
*/
package session02_IO;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Ex04_data_input_outputStream {
    //1.tạo đối tượng file trong thư mục hiện hành
    String path="src/session02_IO/zEx04_file.dat";
    //đối tượng file
    File file= new File(path);
    //2.writeFile() method: ghi dữ liệu vào file
    void writeFile(){
        DataOutputStream dos =null;//ghi dữ liệu có định dạng kiểu (typed format)
        try {
            //mở file để ghi nối tiếp thay vì ghi đè (append mode)
            FileOutputStream fos= new FileOutputStream(file,true);
            dos=new DataOutputStream(fos);
            dos.writeInt(500);//hàm ghi số nguyên
            dos.writeDouble(500.50);//hàm ghi số thực
            dos.write(10);//hàm ghi byte
            dos.writeChar('A');//hàm ghi kí tự
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
    //3.readFile()method: đọc dữ liệu từ file
    void readFile() {
        try {
            FileInputStream fis=new FileInputStream(file);
            DataInputStream dis =new DataInputStream(fis);
            //note: đọc đúng thứ tự hàm đã ghi, nếu sai thứ tự sẽ ra data rác
            String s = String.format("%d - %.2f - %d - %c",
                    dis.readInt(),//đọc hàm ghi số nguyên
                    dis.readDouble(), //đọc hàm ghi số thực
                    dis.read(), //đọc hàm ghi byte
                    dis.readChar());//đọc hàm ghi kí tự
            
            System.out.println(s);
        } catch (IOException e) {
            System.err.println(e.toString());
        }
        
    }
    //6.main()method
    public static void main(String[] args) throws IOException{
        var ex04=new Ex04_data_input_outputStream();
            ex04.writeFile();
            ex04.readFile();
    }
}
