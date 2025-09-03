
package tutorial04_setValues;
import java.util.Scanner;
public class QuanLy {
    DoiTuong doituong;
    Scanner sc = new Scanner(System.in);
    public void addNew(){
        //1.khai báo biến
        String code, name;
        //2.nhập giá trị cho biến
        System.out.println("enter code: ");
        code=sc.nextLine();
        System.out.println("enter name: ");
        name=sc.nextLine();
        //3.khởi tạo đối tượng
        doituong = new DoiTuong();
        doituong.setValues(code, name);
        
    }
    public void display (){
        System.out.println(doituong);
    }
}
