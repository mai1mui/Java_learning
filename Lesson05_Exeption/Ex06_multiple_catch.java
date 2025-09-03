
package session05_exeption;
import java.util.Scanner;
public class Ex06_multiple_catch {
    int n,m;
    Scanner sc=new Scanner(System.in);
    void caculate(){
        System.out.println("enter first n: ");
        n=sc.nextInt();
        System.out.println("enter second n: ");
        m=sc.nextInt();
        try {
            String out =String.format("%d/%d=%d", n,m,n/m);
            System.out.println(out);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("error!");
        }finally{
            System.out.println("Saving....");
        }
    }
    public static void main(String[] args) {
        new Ex06_multiple_catch();
    }
}
