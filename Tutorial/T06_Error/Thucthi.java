package tutorial06_Error;

import java.util.Scanner;

/**
 *
 * View: BookApp (main)
 */
public class Thucthi {
     public void menu(){
     Quanli quanli = new Quanli();
        Scanner sc = new Scanner(System.in);
 
        String option; 
        System.out.println("-------------------");
        System.out.println("\t1. Add new");
        System.out.println("\t2. Display all");
        System.out.println("\t3. Quit");
        System.out.println("-------------------");

        /*do...while: chạy 1 lần trước khi xét điều kiện*/
        do{
            System.out.println("enter u option (add | show | exit)");
            option = sc.nextLine();
            option = option.toLowerCase();

            switch(option){
                case "1" -> quanli.addNew();
                case "2" ->  quanli.display();
                case "3" -> System.out.println("exit");
                
                case "add" ->  quanli.addNew();
                case "display" ->  quanli.display();
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
            /*equalsIgnoreCase():so sánh 2 chuỗi k phân biệt hoa thường */
                System.exit(0);
            }
            
        }while(!option.equalsIgnoreCase("exit"));
        
    }
    public static void main(String[] args) {
        new Thucthi().menu();
    }
}
