
package tutorial01_array_list;
import java.util.Scanner;
public class DoiTuong {
    //1.properties()
    public String code,name;
    Scanner sc=new Scanner(System.in);
    //2.constructor
    public DoiTuong(){
        System.out.println("enter code: ");
        code=sc.nextLine();
        System.out.println("enter name: ");
        name=sc.nextLine();
    }
    public String output(){
        return String.format("Code: %s\nName: %s",code,name);
    }
}
