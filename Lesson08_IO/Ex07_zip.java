
package session02_IO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
public class Ex07_zip {
    //1.tạo đối tượng file trong thư mục hiện hành
    String path="src/session02_IO/zEx07.zip";
    File file=new File(path);
    //2.readFile()method
    void readFile(){
        try {
            FileInputStream fis=new FileInputStream(file);
            ZipInputStream zis=new ZipInputStream(fis);
            ZipEntry entry = new ZipEntry(file.getName());
            
            //đọc từng entry trong file zip
            while((entry=zis.getNextEntry())!=null){
                System.out.println("+ "+entry.getName());
            }
            zis.close();//đóng lại sau khi xong
        } catch (IOException e) {
            System.err.println(e.toString());
        }
}
    //3.main()method
    public static void main(String[] args) {
        new Ex07_zip().readFile();
    }
}
