package assignment_laptops_input_method;

import java.util.Scanner;

public class Laptops {

    //1.properties(thuộc tính)
    public String code, name;
    public int price;
    Scanner sc = new Scanner(System.in);

    //2.input method
    public void input() {
        //2.1.code
        do {
            try {
                System.out.println("Enter code: ");
                code = sc.nextLine();
                if (code.isBlank()) {
                    throw new Exception("Code is required!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());

            }
        } while (true);
        //2.2.name
        do {
            try {
                System.out.println("Enter name: ");
                name = sc.nextLine();
                if (name.isBlank()) {
                    throw new Exception("Name is required!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //2.3.price
        do {
            try {
                System.out.println("Enter price: ");
                price = sc.nextInt();
                if (price < 0) {
                    throw new Exception("Price must be greater than 0!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    //3.override toString()
    @Override
    public String toString() {
        return String.format("+Code: %s\n+Name: %s\n+Price: %s", code, name, price);
    }
}
