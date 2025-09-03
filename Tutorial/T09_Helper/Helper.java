
package tutorial09_helper;
import java.util.Scanner;
public class Helper {
    //1.getString() method
    public static String getString(){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(!s.isBlank()){
            s=s.trim();
        }
        return s;
    }
    //2.check() method
    public static boolean check(String s){
        Boolean isOK = false;
        if(!s.isBlank()){
            return true;
        }
        return isOK;
    }
}
