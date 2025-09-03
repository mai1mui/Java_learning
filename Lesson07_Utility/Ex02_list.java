/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session01_utility;
import java.util.ArrayList;
import java.util.Collection;
public class Ex02_list {
    //1.properties()
    Collection days;
    //2.constructor
    public Ex02_list(){
        days= new ArrayList();
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
        var ex02=new Ex02_list();
        new Ex02_list().display();
        
        System.out.println("1.First day: ");
        ex02.display();
        
        System.out.println("2.Second display: ");
        ex02.delete(day);
        
        System.out.println("3.Second display after delete: ");
        ex02.delete();
    }
}
