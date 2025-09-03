
package tutorial06_Error;
import java.util.Scanner;
/**
 *
 *Model: Book, Staff, Software, Vehicle
 */
public class Doituong {
    //Properties
   public String code,name;
    Scanner sc = new Scanner(System.in);
    //type1: Default constructor
    public Doituong(){
        System.out.println("enter code: ");
        code = sc.nextLine();
        System.out.println("Enter name: ");
        name = sc.nextLine();
    }
    //Override toString();

    @Override
    public String toString() {
        return "code: " + code + ", name: " + name;
    }

    void input() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
