package tutorial05_Array;

import java.util.Scanner;

/**
 *1
 * 
 * View: BookApp (main)
 */
public class Thucthi {
    public void menu(){
     Quanly quanly = new Quanly();
     Scanner sc = new Scanner(System.in);
 
        String option; 
        System.out.println("-------------------");
        System.out.println("\t1. Add new");
        System.out.println("\t2. Display all");
        System.out.println("\t3. Quit");
        System.out.println("-------------------");

        do{
            System.out.println("enter u option (add | show | exit)");
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
        new Thucthi().menu();
    }
}
