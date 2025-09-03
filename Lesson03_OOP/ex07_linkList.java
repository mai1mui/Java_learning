package session03_OOP;
import java.util.LinkedList;

/**
 *
 * @author phuch
 */
public class ex07_linkList {
    //1. khoi tao link list
    static LinkedList list = new LinkedList();
    
    static void addNew(){
        for (int i = 0; i < 5; i++){
            list.add("person" + (i + 1));
        }
        display();
    }
    
    static void display(){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    
    static void addMore(int n){
        list.add(n);
        System.out.println("add"+ n);
        display();
    }
    
    static void deleted(int n){
        list.remove(n);
        System.out.println("deleted"+ n);
        display();
    }
    
    public static void main(String[] args) {
        addNew();
        addMore(0);
        deleted(1);
    }
}
