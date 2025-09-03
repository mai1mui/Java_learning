/*HashSet(): not allow duplicate- giá trị không được trùng*/
package session01_utility;
import java.util.Collection;
import java.util.HashSet;
public class Ex03_set {
    //1.properties()
    Collection days;
    //2.constructor
    public Ex03_set(){
        days= new HashSet();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        
        days.add("Wednesday");//duplicate
        days.add("null");//allow null
        days.add("null");//more null
    }
    //3.display() method
    void display(){
        if(!days.isEmpty()){
            days.forEach((dd)->{
            System.out.println("\t "+dd);
        });
        }else{
            System.err.println("Nothing!");
        }
    }
    //4.delete() method
    void delete(String element){
        days.remove(element);
        display();//hiển thị lại
    }
    void delete(){
        days.clear();
        display();
    }
    //4.main method
    public static void main(String[] args) {
        String day="Friday";
        var ex02=new Ex03_set();
        new Ex03_set().display();
        
        System.out.println("1.First day: ");
        ex02.display();
        
        System.out.println("2.Second display: ");
        ex02.delete(day);
        
        System.out.println("3.Second display after delete: ");
        ex02.delete();
    }
}
