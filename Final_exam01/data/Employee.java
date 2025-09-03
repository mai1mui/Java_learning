package data;

import java.util.Scanner;

public class Employee {
    //1.properties
    public String id, name;
    public int workedDays, baseSalary;
    //2.input() method và bắt lỗi try-catch
    public void input() {
        Scanner sc = new Scanner(System.in);
        //id
        do {
            try {
                System.out.print("Enter ID: ");
                id = sc.nextLine();
                if (id.isBlank()) {
                    throw new Exception("ID is required!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        //name
        do {
            try {
                System.out.print("Enter name: ");
                name = sc.nextLine();
                if (name.isBlank()) {
                    throw new Exception("Name is required!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //workedDays
        do {
            try {
                System.out.print("Enter worked days: ");
                workedDays = Integer.parseInt(sc.nextLine());
                if (workedDays < 0 || workedDays > 31) {
                    throw new Exception("Worked days is between 0 and 31!");

                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (true);

        //baseSalary
        do {
            try {
                System.out.print("Enter base salary: ");
                baseSalary = Integer.parseInt(sc.nextLine());
                if (baseSalary < 0) {
                throw new Exception("Base salary must be >= 0!");

                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            
        } while (true);
    }

    //3.tính lương getSalary() method
    public float getSalary() {
        return (workedDays * baseSalary) / 24;
    }

    //4.toString() method
    @Override
    public String toString() {
        return String.format("+ID: %s\n+Name: %s\n+Worked Days: %d\n+Base Salary: %d\n+Net Salary: %.3f\n",id, name,workedDays, baseSalary,getSalary() ); 
    }
}
