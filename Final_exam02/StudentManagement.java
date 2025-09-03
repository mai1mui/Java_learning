package University;

import java.io.IOException;
import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) throws IOException {
        StudentDAO dao = new StudentDAO();
        String option;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Create Student");
            System.out.println("2. Find All");
            System.out.println("3. Write to file");
            System.out.println("4. Exit");
            System.out.println("-------------------");

            System.out.println("enter your choice ");
            option = sc.nextLine();

            switch (option) {
                case "1":
                    Student s = dao.input();
                    dao.addStudent(s);
                    break;
                case "2":
                    dao.findAll();
                    break;
                case "3":
                    dao.writeFile();
                    break;
                case "4":
                    System.out.println("exit");
                    System.exit(0);
                    break;
                default:
                    System.err.println("wrong");
            }
            //continue?
            System.out.print("Continue (Y/N)? ");
            String propress = sc.nextLine();
            if (!propress.equalsIgnoreCase("Y")) {
                System.exit(0);
            }

        } while (true);

    }
}
