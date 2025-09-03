/*Mô tả: minh họa các sử dụng BufferedReader và BufferedWriter trong Java để ghi và đọc dữ liệu dạng văn bản (text) từ file
*/
package session02_IO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Ex06_buffered_reader_writer {
   //1.tạo đối tượng file trong thư mục hiện hành
    String path="src/session02_IO/zEx06.txt";
    File file=new File(path);
    //2.saveFile() method
    void saveFile(){
        DoiTuong doituong=new DoiTuong("Ts01","Le Thi B");
        BufferedWriter bw=null;
        
        try {
            //ghi vào file ở chế độ nối tiếp(append mode) k ghi đè
            FileWriter fw=new FileWriter(file,true);
            bw=new BufferedWriter(fw);/*BufferedWriter: bộ đệm ghi giúp tăng hiệu suất bằng cách gom dữ liệu lại trước khi ghi */
            bw.write(doituong.toString());//ghi 1 dòng văn bản (ở đây là chuỗi từ toString() của DoiTuong)
            if(bw!=null){
                bw.flush();//đẩy dữ liệu còn lại từ bộ đệm ra file
                bw.close();//đóng writer  , tránh rò rỉ tài nguyên
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
    //3.readFile() method
    void readFile(){
        try {
            FileReader fr=new FileReader(file);//FileReader: đọc file kí tự từ ổ đĩa
            BufferedReader br=new BufferedReader(fr);//BufferedReader: đọc theo dòng(line) để tăng hiệu suất
            System.out.println(br.readLine());//readLine(): đọc 1 dòng từ file(trả về null nếu hết file)
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
    //2.4.main() method
    public static void main(String[] args) {
        var ex06 = new Ex06_buffered_reader_writer();
        ex06.saveFile();
        ex06.readFile();
    }
}
