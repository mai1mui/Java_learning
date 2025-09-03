package OOP;

import java.util.Scanner;
public class Ex01_ThucThi {
    //1.properties
    Ex01_QuanLy quanly = new Ex01_QuanLy();//gọi quanly()method
    //2.menu()method
    public void menu() {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println("\n-----MENU-----");
            System.out.println("1.Add");
            System.out.println("2.Show");
            System.out.println("3.Write file");
            System.out.println("4.Exit");
            System.out.println("----------------");
            System.out.println("enter your choice: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    quanly.add();
                    break;
                case "2":
                    quanly.show();
                    break;
                case "3":
                    quanly.writeFile();
                    break;
                case "4":
                    System.out.println("Program exit....");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Wrong!");
            }
            //continue?
            System.out.println("Continue(Y/N)?");
            String progress=sc.nextLine();
            if(!progress.equalsIgnoreCase("Y")){
                System.exit(0);
            }
        } while (true);
    }
    //3.main()method
    public static void main(String[] args) {
        new Ex01_ThucThi().menu();
    }
}
