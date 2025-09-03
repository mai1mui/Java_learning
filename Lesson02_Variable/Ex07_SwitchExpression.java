package session02;

import java.util.EnumSet;

public class Ex07_SwitchExpression {
    // Enum
    enum Day { Mon, Tue, Wed, Thu, Fri, Sat, Sun }
    void translate(Day day) {
        switch (day) {
            case Mon ->System.out.println("Thu Hai");

            case Tue->System.out.println("Thu Ba");

            case Wed->System.out.println("Thu Tu");
   
            case Thu->System.out.println("Thu Nam");

            case Fri->System.out.println("Thu Sau");
   
            case Sat->System.out.println("Thu Bay");
            case Sun->System.out.println("Chu Nhat");
             
            default->System.out.println("Error");
        }
    }
    void display(){
        EnumSet.allOf(Day.class)
               .forEach(day->translate(day));
    }

    //3.Main method
    public static void main(String[] args) {
        new Ex07_SwitchExpression().display();
    }
}
