
package session05_exeption;
import java.util.Scanner;
public class Ex09_doituong {
    String code,name;
    Scanner sc= new Scanner(System.in);
    public void input(){
        System.out.println("enter code: ");
        code=sc.nextLine();
        System.out.println("enter name: ");
        name=sc.nextLine();
        do{
            try {
                //phần muốn bắt lỗi
                System.out.println("enter name: ");
                name=sc.nextLine();
                if(name.isBlank()){
                    throw new Exception("Name is required!");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        while(name.isBlank());
    }
    //3.override toString()
    @Override
    public String toString(){
        return String.format("+Code: %s\n+Name: %s", code, name);
    }
    public static void main(String[] args) {
        var doituong = new Ex09_doituong();
        doituong.input();
        System.out.println(doituong);
    }
}
