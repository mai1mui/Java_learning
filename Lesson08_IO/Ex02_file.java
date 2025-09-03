/*Mô tả: thao tác với file trong java- tạo mới 1 file nếu chưa tồn tại
Sử dụng lớp File trong gói java.io*/
package session02_IO;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Ex02_file {
    //1.tạo đối tượng file trong thư mục hiện hành
    String path="src/session02_IO/zEx02_file.txt";
    //đối tượng file
    File file= new File(path);
    //2.createFile() method
    void createFile() throws IOException{
        //kiểm tra file có tồn tại chưa?
        if(!file.exists()){
            //nếu chưa-> gọi createFile() để tạo mới
            file.createNewFile();
            System.out.println("creating new file...");
        }else{
            //nếu file đã tồn tại-> báo lỗi
            System.err.println("The file already exits!");
        }
    }
    //3.deleteFile()method
    void deleteFile() {
        //kiểm tra file có tồn tại không?
        if(!file.exists()){
            //nếu không-> báo lỗi
            System.err.println("The file is not found!");
        }else{
            //nếu file đã tồn tại-> gọi deleteFile() để xóa
            file.delete();
            System.out.println("Delete successfully!");
        }
    }
    //4.writeFile()method
    void writeFile() throws IOException{
        String data;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data to saving into file: ");
        data=sc.nextLine();
        
        FileWriter fw=new FileWriter(file);
        //gọi phương thức writeFile()
        fw.write(data);
        System.out.println("Save data successfully!");
        //đóng
        fw.close();
                
    }
    //5.readFile()method
    void readFile() throws IOException{
        char[] ch=new char[100];
        
        FileReader fr=new FileReader(file);
        fr.read(ch);
        fr.close();
        System.out.println("File content: ");
        System.out.println(new String(ch).trim()); //ép mảng char thành chuỗi, xóa khoảng trắng dư
        
    }
    //6.main()method
    public static void main(String[] args) throws IOException{
        var ex02=new Ex02_file();
//        ex02.createFile();
//        ex02.deleteFile();
//        ex02.writeFile();
        ex02.readFile();
    }
}
