
package session04_inheritance;
import java.util.Scanner;

/*
 */
//1.abstract BoMe class
abstract class BoMe{
    int money =2000;
    abstract void input();
}
//2.Main class
public class Ex10_inputMethod_in_doituong extends BoMe{
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
        return String.format("+Code: %s\n+Name: %s\n+Money: %s", code, name,money);
    }
    public static void main(String[] args) {
        var doituong = new Ex10_inputMethod_in_doituong();
        doituong.input();
        System.out.println(doituong);
    }
}
