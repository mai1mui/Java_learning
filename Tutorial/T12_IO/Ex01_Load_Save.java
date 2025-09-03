/*Mô tả: cách lưu trữ và đọc dữ liệu văn bản có cấu trúc đơn giản vào/ra file, đồng thời xử lý dữ liệu với List để hiển thị lại
Mục đích: 
- Lưu dữ liệu chuỗi định dạng có phân tách (#) vào file (saveFile)
- Đọc dữ liệu từ file, tách ra và lưu vào danh sách (List) (loadFile)
- Hiển thị dữ liệu đã đọc ra màn hình (display)
*/
package tutorial03_IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex01_Load_Save {
   //1.Khai báo List
    List<String> list;
    /*  Biến list dùng để lưu tạm thời các dữ liệu sau khi tách từ file.
        Là mảng động, có thể chứa bất kỳ số lượng phần tử.
    */
    //2. Constructor 
    public Ex01_Load_Save(){ 
        list = new ArrayList<>();
        /*  Khi khởi tạo đối tượng Ex01_Load_Save, danh sách list được tạo rỗng.
            Bảo đảm rằng list luôn sẵn sàng để chứa dữ liệu mới.
        */
    }
    //3. Phương thức loadFile(): đọc file vào danh sách
 void loadFile(File file) {
    try {
        //Mở và đọc file dạng văn bản, theo dòng
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String data;

        while ((data = br.readLine()) != null) {
            String[] tmp = data.split("#");//split("#"): Tách dòng theo ký tự # thành 2 phần
            list.add(tmp[0]);//Thêm từng phần vào danh sách list
            list.add(tmp[1]);
        }
    } catch (IOException e) {
        System.err.println(e.getMessage());
    }
}
    //4. Phương thức saveFile(): ghi chuỗi vào file
    void saveFile(File file, String s) {
    try {
        //Mở file để ghi nối tiếp không ghi đè
        FileWriter fw = new FileWriter(file, true); // true để ghi tiếp vào file
        //Ghi file hiệu suất cao hơn
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(s + "\n");//Ghi chuỗi s vào file
        
        bw.flush();//Đảm bảo đẩy hết dữ liệu trong bộ đệm ra file
        bw.close();//Đóng tài nguyên file
        
    } catch (IOException e) {
        System.err.println(e.toString());
    }
}
    //5. Phương thức display()
    void display(){ 
        for(String s: list){ //Duyệt qua danh sách list và in từng phần tử ra màn hình.
            System.out.println(s);
        }
    }
    //6. Phương thức main ()
    public static void main(String[] args) {
        var ex01 = new Ex01_Load_Save();
        File file = new File("src/tutorial03_IO/zEx01.txt");
        String s = "fpt#246";

        ex01.saveFile(file, s);
        ex01.loadFile(file);
        ex01.display();
    }
}/* Trình tự hoạt động:
    1. Tạo file zEx01.txt.
    2. Ghi dòng "fpt#246" vào file.
    3. Đọc toàn bộ nội dung file, tách dữ liệu và lưu vào list.
    4. In danh sách ra màn hình.
*/
