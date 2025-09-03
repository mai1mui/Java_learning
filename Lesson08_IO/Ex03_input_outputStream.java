/*Mô tả: thao tác với file trong java- tạo mới 1 file nếu chưa tồn tại
Sử dụng lớp File trong gói java.io
- Cách đọc và ghi file trong java bằng luồng byte(InputStream) và (OutputStream)
*/
package session02_IO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Ex03_input_outputStream {
    //1.tạo đối tượng file trong thư mục hiện hành
    String path="src/session02_IO";
    //đối tượng file
    File file= new File(path+"zEx02_file.txt");
    //2.copyFile() method
    void copyFile() throws IOException{
        //Sử dụng FileInputStream để đọc file: fis mở file đọc từng file gốc
        FileInputStream fis=new FileInputStream(file);
        //Sử dụng FileOutputStream để ghi file: fos tạo(hoặc ghi đè) file đích có cùng tên với file gốc
        FileOutputStream fos=new FileOutputStream(path+"zEx02_file.txt");
        int ch;
       
        while((ch=fis.read())!=-1){//đọc từng byte kiểu int tiếp tục cho đến khi hết file (-1)
            fos.write(ch);//ghi byte đọc được sang file đích
        }
        System.out.println("Copy file successfully!");
    }
    //6.main()method
    public static void main(String[] args) throws IOException{
        new Ex03_input_outputStream().copyFile();
        
    }
}
