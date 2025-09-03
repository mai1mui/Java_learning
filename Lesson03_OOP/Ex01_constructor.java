
package session03_OOP;
import java.util.Scanner;
/*1.constructor:
-trùng tên lớp
-không dùng kiểu trả về
2.phan loai
-default constructor: hàm dừng mặc định-mặc định không cần khai báo
-parameterized constructor: hàm dùng có tham số*/
public class Ex01_constructor {
    //1.properties
    String code,name;
    //2.default constructor
    public Ex01_constructor(){
        code="no any code";
        name="no any name";
    }
    //3.parameterized constructor
    public Ex01_constructor(String code, String name){
        this.code=code;
        this.name=name;
    }
    //4.overide toString() method
    public String toString(){
        return String.format("Code: %s - Name: %s",code,name);
    }
    //5.main() method
    public static void main(String[] args) {
        //5.1.khai báo
        Ex01_constructor person1, person2;
        String code,name;
        Scanner sc=new Scanner(System.in);
        //5.2.Nhập code, name
        System.out.println("enter code");
        code=sc.nextLine();
        System.out.println("enter name");
        name=sc.nextLine();
        //5.3.khởi tạo
        person1=new Ex01_constructor();//default constructor
        person2=new Ex01_constructor(code,name);
        //5.4.display
        System.out.println(person1.toString());
        System.out.println(person2);
    }
    
    
}
