/*Mô tả: 1 ứng dụng Notepad quản lý thông tin đơn giản, có khả năng:
- nhập dữ liệu người dùng(code,name)
- lưu trữ vào TreeMap
- hiển thị dữ liệu ra màn hình
- lưu dữ liệu ra file
- mở file bằng trình duyệt mặc định(Notepad)
Mục đích:
- sử dụng regex(biểu thức chính quy) để kiểm tra dữ liệu đầu vào
- sử dụng TreeMap để lưu dữ liệu theo key
- tổ chức chương trình theo mô hình phân lớp logic rõ ràng:
    + Helper: hỗ trợ kiểm tra chuỗi
    + DoiTuong: lưu trữ đối tượng đơn giản(code,name)
    + QuanLy: xử lý quản lý và file
    + ThucThi: giao diện dòng lệnh cho người dùng
*/
package tutorial05_Notepad;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;
//1.Heplper class: kiểm tra chuỗi có đúng định dạng không?
class Helper {
    static boolean check(String regex, String input) {
        return Pattern.matches(regex, input);//Pattern.matches():kiểm tra khớp toàn bộ chuỗi chứ k chỉ 1 phần
    }
}
//2.DoiTuong class
class DoiTuong {

    //2.1.properties
    String code, name;
    Scanner sc = new Scanner(System.in);

    //2.2.input()method
    /*Yêu cầu: code: A123, name >= 6 kí tự*/
    void input() {
        String reCode, reName;
        reCode = "^[A]\\d{3}$";
        reName = "^\\w{6,}$";
        //code
        do {
            try {
                System.out.println("Enter Code: ");
                code = sc.nextLine();
                if (!Helper.check(reCode, code)) {
                    throw new Exception("Code must be in form [Axxx]!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (!Helper.check(reCode, code));
        //name
        do {
            try {
                System.out.println("Enter Name: ");
                name = sc.nextLine();
                if (!Helper.check(reName, name)) {
                    throw new Exception("Name is aleast from 6 characters!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (!Helper.check(reName, name));
    }

    //2.3.override toString()
    @Override
    public String toString() {
        return "Code: " + code + ", Name: " + name;
    }
}
//3.QuanLy class

class QuanLy {

    //3.1.properties
    TreeMap<String, DoiTuong> dbbank;
    /*TreeMap là 1 cấu trúc dữ liệu:
    - lưu theo cặp key-value(ở đây code-DoiTuong)
    - tự động sắp xếp theo thứ tự tăng dần của key(code)
    */

    //3.2.constructor
    public QuanLy() {
        dbbank = new TreeMap<>();
    }

    //3.3.addNew(DoiTuong doituong)method: đặc biệt, có tham số
    void addNew(DoiTuong doituong) {
        doituong = new DoiTuong();
        doituong.input();//gọi input()method để nhập thông tin
        dbbank.put(doituong.code, doituong);//thêm thông tin vào dbbank
    }

    //3.4.display()method
    void display() {
        if (dbbank.isEmpty()) {
            System.err.println("Nothing to display!");
        } else {
            dbbank.forEach((key, doituong) -> {
                System.out.println(doituong);
            });
        }
    }

    //3.5.saveFile()method
    void saveFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        //Mở file để ghi
        FileWriter fw = new FileWriter(file, true); // true để ghi nối tiếp vào file, k ghi đè
        //Ghi file hiệu suất cao hơn
        BufferedWriter bw = new BufferedWriter(fw);
       
        for (var doituong : dbbank.values()) {
            bw.write(doituong.toString());
            bw.newLine();
        }
        
        bw.flush();//Đảm bảo đẩy hết dữ liệu trong bộ đệm ra file
        bw.close();//Đóng tài nguyên file
    }

    //3.6.openFile()method
    void openFile(File file) throws IOException {
         Desktop desktop= Desktop.getDesktop();
         desktop.open(file);//desktop.open(): để mở file bằng chương trình mặc định(thường là Notepad)
    }
}

//4.ThucThi
public class ThucThi {

    public void menu() {
        //khai báo biến
        String choice;
        String name;
        File file =null;
        QuanLy quanly=new QuanLy();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n===== Management Menu =====");
            System.out.println("1.Add new ");
            System.out.println("2.Display ");
            System.out.println("3.Save file ");
            System.out.println("4.Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextLine();
            //switch-case
            switch (choice) {
                case "1" ->quanly.addNew(new DoiTuong());
                case "2" ->quanly.display();
                case "3" ->{
                    System.out.println("Enter file name: ");
                    name=sc.nextLine();
                    file=new File("src/tutorial05_Notepad/"+name+".txt");
                    try {
                        quanly.saveFile(file);
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
                case "4" -> {
                    System.out.println("Program exit...");
                    try {
                        quanly.openFile(file);
                    } catch (IOException e) {
                        System.exit(0);
                    }
                }
                default ->
                    System.err.println("Wrong!");
            }
            //continue?
            System.out.println("Continue (Y/N)?");
            String progress = sc.nextLine();
            if (!progress.equalsIgnoreCase("Y")) {
                System.exit(0);
            }
        } while (!choice.equalsIgnoreCase("exit"));
    }
    public static void main(String[] args) {
        new ThucThi().menu();
    }
}

