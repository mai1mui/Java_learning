
package session01_utility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
public class Ex01_5ways_access {
    //1.properties()
    List days;
    //2.constructor
    public Ex01_5ways_access(){
        days= new ArrayList();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
    }
    //3.display() method
    public void display(){
        //3.1.Using for  loop(vòng lặp)
        System.out.println("1.Using for loop: ");
        for(int i=0;i<days.size();i++){
            System.out.println("\t. "+days.get(i)); 
        }
        //3.2.Using for each
        System.out.println("\n2.Using for each: ");
        for(var dd:days){
            System.out.println("\t. "+dd); 
        }
        //3.3.Using Iterator
        System.out.println("\n3.Using Iterator: ");
        Iterator iterator=days.iterator();
        while(iterator.hasNext()){
            System.out.println("\t "+iterator.next());
        }
        //3.4.Using ListIterator
        System.out.println("\n4.Using ListIterator: ");
        ListIterator listIterator=days.listIterator();
        while(listIterator.hasNext()){
            Object dd=listIterator.next();
            System.out.println("\t "+dd);
        }
        //3.5.Using lamda
        System.out.println("\n5.Using lamda:");
        days.forEach((dd)->{
            System.out.println("\t "+dd);
        });
    }
    //4.main method
    public static void main(String[] args) {
        new Ex01_5ways_access().display();
    }
}
