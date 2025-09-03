
package tutorial02_hash_map;
import java.util.Scanner;
public class DoiTuong {
    //1.properties()
    private String code,name;
    Scanner sc=new Scanner(System.in);
    //2.input() method
    public void input(){
        System.out.println("enter code: ");
        code=sc.nextLine();
        System.out.println("enter name: ");
        name=sc.nextLine();
    }
    //vì biến code, name đang private, nên cần getter() để lấy giá trị cho lớp QuanLy()
        //cách làm: click chuột trái-> insert code-> getter()-> chọn code(String)
    public String getCode() {
        return code;
    }
    
    //format input
    public String output(){
        return String.format("Code: %s\nName: %s",code,name);
    }
}
