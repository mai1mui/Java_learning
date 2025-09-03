
package session01_utility;
import java.util.Map;
import java.util.TreeMap;
public class Ex04_map {
    //1.properties
    Map days;
    //2.constructor
    public Ex04_map(){
        days=new TreeMap();
        //Syntax: days.put(key-values,values);
        days.put(7,"Sunday");
        days.put(2,"Tuesday");
        days.put(6,"Friday");
    }
    //3.display() method
    void display(){
        System.out.println("All of keys: "+days.keySet());
        System.out.println("All of values: "+days.values());
    }
    //4.main() method
    public static void main(String[] args) {
        new Ex04_map().display();
    }
}
