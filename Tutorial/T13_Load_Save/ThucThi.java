/*Mô tả: mô phỏng chương trình quản lý tài khoản đăng nhập vào file account.txt gồm:
- đăng nhập(login)
- thêm mới addNew() method
- lưu và đọc file
- dùng abstract class, list, BufferedReader, BufferedWriter, Scanner,...*/
package tutorial04_load_save;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1. CHA(abstract class): lớp trừu tượng
abstract class CHA {
    abstract String output();
}
/*Mục đích: 
- Phương thức output() là phương thức trừu tượng (không có thân hàm), buộc lớp con phải override lại.
- đảm bảo chuẩn chung cho các lớp con đều có output()method 
*/
//2. DoiTuong class

class DoiTuong extends CHA {

    //2.1 Properties
    String user, password;

    //2.2 Parameterized Constructor
    public DoiTuong(String user, String password) {
        this.user = user;
        this.password = password;
    }
    @Override
    public String output() {
        return user + "#" + password;
    }

}
//3. QuanLy class: xử lý toàn bộ logic

final class QuanLy {

    //3.1. Properties
    List<DoiTuong> list;//list: lưu ds tài khoản
    File file;
    Scanner sc;//đọc data nhập từ bàn phím

    //3.2. Constructor
    public QuanLy() {
        list = new ArrayList<>();
        file = new File("src/tutorial04_load_save/account.txt");
        sc = new Scanner(System.in);
        try {
            if (file.exists()) load(); // chỉ load nếu file đã tồn tại
        } catch (IOException ex) {
            System.err.println(ex.toString()); 
        }
    }

    //3.3. loadFile()method
    void loadFile() throws IOException {
        if (!file.exists()) return;

        FileReader fr = new FileReader(file);//đọc từng dòng, mỗi dòng là 1 tài khoản
        BufferedReader br = new BufferedReader(fr);
        String data;
        while ((data = br.readLine()) != null) {
            if (data.trim().isEmpty()) continue; // Bỏ qua dòng rỗng

            String[] tmp = data.split("#");//split(): tách chuỗi từ file

            if (tmp.length < 2) {
                System.err.println("Invalid: " + data);
                continue; // Bỏ qua dòng sai định dạng
            }

            list.add(new DoiTuong(tmp[0], tmp[1]));
        }
        br.close();
    }

    //3.4. load()method
    void load() throws IOException{
        //nếu list trống -> load File
        if(list.isEmpty()){ 
            loadFile();
        }else{ //ngược lại -> xóa list-> load File
            list.removeAll(list);
            loadFile();
        }
    }
    //3.5. input()method
    DoiTuong input(){ 
        String user, pass;
        
        System.out.println("Enter user name: ");
        user = sc.nextLine();
        System.out.println("Enter Password: ");
        pass = sc.nextLine();
        
        var doituong = new DoiTuong(user, pass);
        return doituong;
    }
    //3.6. search()method
    boolean search(DoiTuong doituong)throws IOException{ 
        loadFile();
        for(var d: list){ 
            //so sánh data tài khoản với các đối tượng trong list
            if((d.user.equals(doituong.user)) && (d.password.equals(doituong.password))){ 
                return true;//nếu trùng khớp-> trả về true
            }
        }
        return false;
    }
    //3.7. login()method
    void login() throws IOException{ 
        boolean isOk = false; 
        do{ 
            //gọi input()method để nhập tài khoản
            DoiTuong doituong = this.input();
            //dùng search() để kiểm tra thông tin
            isOk = search(doituong);
            if (!isOk) {
                System.err.println("Login failed! Try again.");
            }
        }while(!isOk);
        System.out.println("Login success!");
    }
    //3.8 saveFile()method
    void saveFile() throws IOException{ 
        boolean isOk = false;
        do{ 
            //gọi input()method để nhập tài khoản
            DoiTuong doituong = this.input();
            //dùng search() để kiểm tra thông tin
            isOk = search(doituong);
            if(isOk){ 
                System.out.println("Account exists");
            }else{ 
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(doituong.output());
                bw.flush();
                bw.close();
                System.out.println("Adding account successfully!");
                break;
            }
        }while(!isOk);
    }
    //3.9. addNew()method
    void addNew(){ 
        try {
            saveFile();
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}
//4.Lớp Thực Thi
    //4.1. Phương thức Menu()
   public class ThucThi {
    void menu() throws IOException{ 
        QuanLy quanly = new QuanLy();
        Scanner sc = new Scanner(System.in);
 
        String option; 
        System.out.println("-------------------");
        System.out.println("\t1.Login");
        System.out.println("\t2.Add new account ");
        System.out.println("\t3.Exit. ");
        System.out.println("-------------------");

        do{
            System.out.println("enter your choice ");
            option = sc.nextLine();

            switch(option){
               
                case "1" ->  quanly.login();
                case "2" ->  quanly.addNew();
                case "3" -> {
                    System.out.println("exit");
                    System.exit(0);
                }            
               
                default -> System.err.println("wrong");
            }
            //continue?
            System.out.print("Continue (Y/N)? ");
            String propress = sc.nextLine();
            if(!propress.equalsIgnoreCase("Y")){
                System.exit(0);
            }
            
        }while(!option.equalsIgnoreCase("exit"));
        
    }
    //4.2. Phương thức Main()
       public static void main(String[] args) throws IOException {
          var thucthi = new ThucThi();
          thucthi.menu();
       }
}