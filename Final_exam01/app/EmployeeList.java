package app;

import data.Employee;
import java.util.Scanner;

public class EmployeeList {

    //1.properties
    public int max;
    public int next = 0;
    public int wday;
    Scanner sc = new Scanner(System.in);
    //2.mảng chứa đối tượng
    public Employee[] arr;

    //nhập số lượng đối tượng tối đa (max)
    public EmployeeList() {
        do {
            try {
                System.out.println("Enter maximum number of employee: ");
                max = Integer.parseInt(sc.nextLine());
                if (max < 0) {
                    throw new Exception("Please enter a positive number!");
                }
                //khởi tạo mảng
                arr = new Employee[max];
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (max < 0);
    }

    //3.addEmployee() method
    public void addEmployee() {
        if (next >= max) {
            System.err.println("They out of " + max);
        } else {
            //khởi tạo đối tượng
            arr[next] = new Employee();
            //gọi input() method
            arr[next].input();
            next++;
        }
    }

    //4. In tất cả nhân viên
    public void findAll() {
        if (next == 0) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("All Employees");
            for (int i = 0; i < next; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    //5. Tìm theo số ngày làm việc > wday
    public void findByDay() {
        do {
            try {
                System.out.print("Enter a specific day: ");
                wday = Integer.parseInt(sc.nextLine());
                if (wday < 0 || wday > 31) {
                    throw new Exception("Day is between 0 and 31!");

                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (true);
        boolean find = false;
        System.out.println("List of employees with worked days greater than a specific day");
        for (int i = 0; i < next; i++) {
            if (wday <= arr[i].workedDays) {
                System.out.println(arr[i]);
                //nếu tìm thấy, đánh dấu find thành true
                find = true;
            }
        }
        if (!find) {
            System.out.println("No employee has worked more than " + wday + " days.");
        }
    }

    //6.menu() method
    public void menu() {
        //khai báo biến
        String choice;
        do {
            System.out.println("\n===== Employees Management Menu =====");
            System.out.println("1.Add new Employee");
            System.out.println("2.Find all");
            System.out.println("3.Find by worked days");
            System.out.println("4.Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextLine();
            choice = choice.toLowerCase();
            //switch-case
            switch (choice) {
                case "1" ->
                    addEmployee();
                case "2" ->
                    findAll();
                case "3" ->
                    findByDay();
                case "4" -> {
                    System.out.println("Exit.");
                    System.exit(0);
                }
                default ->
                    System.err.println("Wrong!");
            }
            //continue?
            System.out.println("Continue (Y/N)?");
            String progress = sc.nextLine();
            if (!progress.equalsIgnoreCase("Y")) {
                System.exit(0);
            }
        } while (!choice.equalsIgnoreCase("exit"));
    }

    public static void main(String[] args) {
        new EmployeeList().menu();
    }
}
