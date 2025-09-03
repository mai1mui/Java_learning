/*Mô tả: lưu danh sách đối tượng DoiTuong xuống file bằng 3 cách khác nhau với 3 loại stream:
1. useBufferedWriter() → Ghi text thường.
2. useDataOutputStream() → Ghi dạng nhị phân từng ký tự.
3. useObjectOutputStream() → Ghi đối tượng (serialize).
*/

package tutorial03_IO;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//1. clas DoiTuong
    class DoiTuong{
        String code, name;

        public DoiTuong(String code, String name) {
            this.code = code;
            this.name = name;
        }

        @Override
        public String toString() {
            return "DoiTuong{" + "code=" + code + ", name=" + name + '}';
        }
    }
//2. class Main 
public class Ex02_Save_Only {
  //2.1. Khai bao List
    List<DoiTuong> list;
    String path = "src/tutorial03_IO/";
    
    //2.2. Constructor
    public Ex02_Save_Only(){
        list = new ArrayList<>();
        list.add(new DoiTuong("std01", "A Văn Lê"));
        list.add(new DoiTuong("std02", "B Văn La"));
    }
    
    //2.3. Cách 1: BufferedWriter()method: ghi văn bản(text)  
    void useBufferedWriter() throws IOException{
        File file = new File(path + "zBufferedWriter.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for(var doituong : list){
            bw.write(doituong.toString());
            bw.newLine();//xuống dòng
        }
        bw.flush();
        bw.close();
        System.out.println("Save using BufferedWriter successfully!");
    }
    //2.4. Cách 2: DataOutputStream()method: ghi nhị phân ký tự
   void useDataOutputStream() throws IOException{
    File file = new File(path + "zDataOutputStream.dat");
    FileOutputStream fos = new FileOutputStream(file);
    DataOutputStream dos = new DataOutputStream(fos);
    for(var doituong : list){
        dos.writeChars(doituong.toString());//ghi từng đối tượng
        dos.write(10);
    }
    dos.flush();
    dos.close();
    System.out.println("Save using DataOutputStream successfully!");
    }
    //2.5. Cách 3: ObjectOutputStream()method: ghi đối tượng (serialization)
   void useObjectOutputStream() throws IOException{
    File file = new File(path + "zObjectOutputStream.bin");
    FileOutputStream fos = new FileOutputStream(file);
    ObjectOutputStream os = new ObjectOutputStream(fos);
    for(var doituong : list){
        os.writeObject(doituong.toString());
        os.write(10);
    }
    os.flush();
    os.close();
    System.out.println("Save using ObjectOutputStream successfully!");
}
    //2.6. main()method
    public static void main(String[] args) throws IOException {
        var ex02 = new Ex02_Save_Only();
        ex02.useBufferedWriter();
        ex02.useDataOutputStream();
        ex02.useObjectOutputStream();
    }
}

