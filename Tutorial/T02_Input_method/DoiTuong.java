
package tutorial02_input_method;
import java.util.Scanner;
public class DoiTuong {
    //1.properties
    public String code, name;
    Scanner sc = new Scanner(System.in);
    //2.type2: input method
    public void input(){
        System.out.println("enter code: ");
        code=sc.nextLine();
        System.out.println("enter name: ");
        name=sc.nextLine();
        
    }
    //3.override toString()
    @Override
    public String toString(){
        return String.format("+Code: %s\n+Name: %s", code, name);
    }
    
}
