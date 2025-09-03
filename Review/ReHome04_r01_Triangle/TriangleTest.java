package r01_JP2_Triangle;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TriangleTest {

    //1.properties
    public int a, b, c;
    ArrayList<Triangle> list;
    Scanner sc = new Scanner(System.in);

    //initial list in default constructor 
    public TriangleTest() {
        list = new ArrayList<>();
    }

    //2.addNew()method
    //2.1.input()method
    public Triangle input() {

        //2.1.1.side a
        do {
            try {
                System.out.println("Enter side a: ");
                String aI = sc.nextLine();
                if (aI.isBlank()) {
                    throw new Exception("Side a is required!");
                }
                a = Integer.parseInt(aI);
                if (a <= 0) {
                    throw new Exception("Side a must be greater than 0!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        //2.1.2.side b
        do {
            try {
                System.out.println("Enter side b: ");
                String bI = sc.nextLine();
                if (bI.isBlank()) {
                    throw new Exception("Side b is required!");
                }
                b = Integer.parseInt(bI);
                if (b <= 0) {
                    throw new Exception("Side b must be greater than 0!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //2.1.3.side c
        do {
            try {
                System.out.println("Enter side c: ");
                String cI = sc.nextLine();
                if (cI.isBlank()) {
                    throw new Exception("Side c is required!");
                }
                c = Integer.parseInt(cI);
                if (c <= 0) {
                    throw new Exception("Side c must be greater than 0!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        if ((a + b <= c) || (a + c <= b) || (c + b <= a)) {
            System.out.println("This is not a triangle");
            return null;
        } else {
            var triangle = new Triangle(a, b, c);
            return triangle;
        }

    }

    //2.2.addNew()method
    public void addNew() {
        Triangle triangle = input();
        list.add(triangle);
        System.out.println("Added successfully.");
    }

    //3.saveFile()method
    public void saveFile() {
        //4.1.đường dẫn
        String file = "src/r01_JP2_Triangle/Triangle.txt";
        //4.2.try-with-resource để đóng file khi ghi xong
        try {
            FileWriter fw = new FileWriter(file, true);
            for (Triangle tri : list) {
                fw.write("This is a triangle with: ");
                fw.write("\nSide a: " + tri.a);
                fw.write("\nSide a: " + tri.b);
                fw.write("\nSide a: " + tri.c);
                fw.write("\n-------------------\n");
            }
            System.out.println("Saved successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    //4.display()method
    public void display() {
        if (list.isEmpty()) {
            System.out.println("Nothing to display.");
        } else {
            System.out.println("This is a triangle with: ");
            for (Triangle tri : list) {
                tri.exportData();
                if (tri.a == tri.b && tri.b == tri.c) {
                    System.out.println("This is an equilateral triangle");
                } else if (tri.a == tri.b || tri.a == tri.c || tri.b == tri.c) {
                    System.out.println("This is an isosceles triangle");
                } else if (tri.a * tri.a + tri.b * tri.b == tri.c * tri.c || tri.a * tri.a + tri.c * tri.c == tri.b * tri.b || tri.b * tri.b + tri.c * tri.c == tri.a * tri.a) {
                    System.out.println("This is a right triangle");
                } else {
                    System.out.println("This is a normal triangle");
                }
            }

        }

    }

    //5.menu(){}
    public void menu() {
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("-----MENU-----");
            System.out.println("1.Add new triangle");
            System.out.println("2.Display");
            System.out.println("3.Save file");
            System.out.println("4.Exit");

            System.out.println("Enter your choice(1|2|3|4): ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addNew();
                    break;
                case "2":
                    display();
                    break;
                case "3":
                    saveFile();
                    break;
                case "4":
                    System.out.println("Exit programming...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong!");
                    break;
            }
            //Continue?
            System.out.println("Continue(Y/N)?");
            String option = sc.nextLine();
            if (!option.equalsIgnoreCase("Y")) {
                System.exit(0);
            }
        } while (true);
    }

    //6.main class
    public static void main(String[] args) {
        new TriangleTest().menu();
    }
}
