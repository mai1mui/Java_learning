
package session02;

public class Ex02_variable {
   //1.class variable
    String global ="Class variable is global";
   //2.method variable
    public Ex02_variable(){
        String local ="Method variable is local";
        String s=String.format("Class: %s-Method :%s", global, local);
        System.out.println(s);
    }
    void show(){
        System.out.println("only class: "+global);
    }
    public static void main (String[] args){
        new Ex02_variable().show();
    }
}
