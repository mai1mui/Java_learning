package session02;
import java.util.Scanner;

public class Ex08_Menu {
    void menu() {
        Scanner sc = new Scanner(System.in);
        String option;

        while (true) {
            System.out.println("\t------------------------------------------");
            System.out.println("\t1. Add new");
            System.out.println("\t2. Display all");
            System.out.println("\t3. Quit");
            System.out.println("\t------------------------------------------");

            System.out.print("Please enter your option (1 | 2 | 3): ");
            option = sc.nextLine();

            switch (option) {
                case "add"->System.out.println("Add new");
                case "show"->System.out.println(" Display all");
                case "exit"->System.out.println("Exit!");      
                default->System.out.println("Invalid option. Please try again.");
            }
            //continue
            System.out.println("Continue? Y/N");
            

        }
    }

    public static void main(String[] args) {
        new Ex08_Menu().menu();
    }
}
