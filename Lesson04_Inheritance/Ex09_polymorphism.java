/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session04_inheritance;

/*1.Compile time: override
2.Runtime: overload
 */
//1.supper class
class Shape{
    void printInfo(){
        System.out.println("Here in Parent class info");
    }
}
//2.Main class
public class Ex09_polymorphism extends Shape{
    //2.1.override
    public void printInfo(){
        super.printInfo();
        System.out.println("Here is override method!");
    }
    //2.2.overload
    public void draw(int x, int y){
        String s=String.format("Line with begin-point: %d, end-point: %d",x,y);
        System.out.println(s);
        
    }
    public void draw(int x, int y, int z){
        String s=String.format("Rectangle with: x=%d,y=%d,z=%d ",x,y,z);
        System.out.println(s);
        
    }
    public static void main(String[] args) {
        var ex09= new Ex09_polymorphism();
        ex09.printInfo();
        ex09.draw(100, 200);
        ex09.draw(10, 20, 30);
    }
}
