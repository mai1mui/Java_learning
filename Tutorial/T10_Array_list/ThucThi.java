
package tutorial01_array_list;

import java.util.Scanner;

public class ThucThi {
    void menu(){
        QuanLy quanly = new QuanLy();
     Scanner sc = new Scanner(System.in);
 
        String option; 
        System.out.println("-------------------");
        System.out.println("\t1. Add new");
        System.out.println("\t2. Display all");
        System.out.println("\t3. Quit");
        System.out.println("-------------------");

        do{
            System.out.println("enter you option: ");
            option = sc.nextLine();
            option = option.toLowerCase();

            switch(option){
                case "1" -> quanly.addNew();
                case "2" ->  quanly.display();
                case "3" -> System.out.println("exit");
                
                case "add" ->  quanly.addNew();
                case "display" ->  quanly.display();
                case "exit" -> {
                    System.out.println("exit");
                    System.exit(0);
                }            
               
                default -> System.err.println("wrong");
            }
            //continue?
            System.out.print("Continue (Y/N)? ");
            String propress = sc.nextLine();
            if(!propress.equalsIgnoreCase("Y")){
                System.exit(0);
            }
            
        }while(!option.equalsIgnoreCase("exit"));
        
    
    }
    public static void main(String[] args) {
        new ThucThi().menu();
    }
}
