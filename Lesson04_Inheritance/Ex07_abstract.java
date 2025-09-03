
package session04_inheritance;

/*abstract class: không cho phép tạo instant
phương thức abstract: k khóa body
 */
//1.abstract class
abstract class CHA{
    abstract void testMethod();
}
//2.main class
public class Ex07_abstract extends CHA {
    public void testMethod(){
        System.out.println("Overside abstract method.");
        
    }
    public static void main(String[] args) {
        new Ex07_abstract().testMethod();
    }
}
