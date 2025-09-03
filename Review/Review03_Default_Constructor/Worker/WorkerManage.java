/*Yêu cầu: tạo lớp WorkerManage trong package khác tên fptaptech
a. khai báo biến:
- maxWorker(int): số lượng công nhân tối đa
- nextWorker(int): số lượng công nhân hiện tại
- Worker[]arr: mảng các đối tượng
b. menu() method
c. saveWorker() method
dùng try-catch bắt ném lỗi:
- name, address: k rỗng
- year_of_birth: lớn hơn 1965, nhỏ hơn 2005
d. showAll() method
 */
package fptaptech;

import academy.Worker;
import java.util.Scanner;

public class WorkerManage {

    //1.properties()
    public int maxWorker;
    public int nextWorker = 0;
    //khai báo mảng
    public Worker[] arr;
    Scanner sc=new Scanner(System.in);
    //2.menu() method
    //2.1.nhập số lượng max
    public WorkerManage() {
        do {
            try {
                System.out.println("Enter maximum number of worker: ");
                maxWorker = Integer.parseInt(sc.nextLine());
                if (maxWorker < 0) {
                    throw new Exception("Please enter a positive number!");
                }
                //khởi tạo mảng
                this.arr = new Worker[maxWorker];
                break; // Sau khi tạo mảng xong thì thoát vòng lặp
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    //2.2.menu() method
    public void menu() {
        //khai báo biến
        String choice;
        do {
            System.out.println("\n===== Worker Management Menu =====");
            System.out.println("1.Add new worker");
            System.out.println("2.Worker List");
            System.out.println("3.Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextLine();
            choice = choice.toLowerCase();
            //switch-case
            switch (choice) {
                case "1" ->
                    saveWorker();
                case "2" ->
                    showAll();
                case "3" -> {
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

    //3.saveWorker() method
    public void saveWorker() {
        //3.1.khai báo biến
        int id;
        String name, address;
        int year_of_birth;
        //3.2.nhập giá trị cho biến

        if (nextWorker >= maxWorker) {
            System.out.println("They out of " + maxWorker);
            return;//dừng lại
        }
        //3.2.1.id
        do {
            try {
                System.out.println("Enter ID: ");
                String input = sc.nextLine();
                if (input.isBlank()) {
                    throw new Exception("ID is required!");
                }
                //chuyển kiểu dữ liệu size từ string sang int
                id = Integer.parseInt(input);
                if (id < 0) {
                    throw new Exception("ID must be greater than 0!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //3.2.2.name
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
        //3.2.3.address
        do {
            try {
                System.out.println("Enter address: ");
                address = sc.nextLine();
                if (address.isBlank()) {
                    throw new Exception("Address is required!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //3.2.4.year_of_birth
        do {
            try {
                System.out.println("Enter year_of_birth: ");
                String input = sc.nextLine();
                if (input.isBlank()) {
                    throw new Exception("Year_of_birth is required!");
                }
                //chuyển kiểu dữ liệu year_of_birth từ string sang int
                year_of_birth = Integer.parseInt(input);
                if (year_of_birth < 1965 || year_of_birth > 2005) {
                    throw new Exception("Year_of_birth has value 1965 - 2005!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //3.3.khởi tạo đối tượng
        arr[nextWorker]= new Worker(id,name,address,year_of_birth);
        nextWorker++;
    }

    //4.showAll() method
    public void showAll() {
        if (nextWorker == 0) {
            System.out.println("No worker to display");
        } else {
            System.out.println("===Worket List===");
            for (int i = 0; i < nextWorker; i++) {
                System.out.println("\nID: " + arr[i].id);
                System.out.println("\nName: " + arr[i].name);
                System.out.println("\nAddress: " + arr[i].address);
                System.out.println("\nYear_of_birth: " + arr[i].year_of_birth);
            }
        }

    }
    //5.main method
    public static void main(String[] args) {
        new WorkerManage().menu();
    }
}
