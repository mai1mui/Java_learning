 /*Yêu cầu: tạo class StaffTest trong package test gồm:
1. Thuộc tính:
- maxStaff: số lượng tối đa nhân viên (int)
- nextStaff: số nhân viên hiện có(int)
- ExecutiveStaff[]es : mảng chứa các nhân viên (dạng đối tượng)
2.Phương thức
    2.1.createStaff()
    - ExecutiveStaff: tạo nhân viên mới
    - gọi phương thức input()
    - thêm vào mảng
    2.2.viewStaff()
    - in ra nhân viên có salary >800
    2.3.dùng switch-case + vòng lặp tạo menu
    a. Add staff
    b. Display staffs
    c. Exit
 */
package test;

import Executive.ExecutiveStaff;
import java.util.Scanner;

public class StaffTest {

    //1.properties(thuộc tính)
    public int maxStaff;
    public int nextStaff = 0;
    Scanner sc = new Scanner(System.in);

    //mảng chứa nhân viên 
    public ExecutiveStaff[] es;

    //nhập số lượng nhấn viên tối đa maxStaff
    public StaffTest() {
        do {
            try {
                System.out.println("Enter maximum number of staff: ");
                maxStaff = Integer.parseInt(sc.nextLine());
                if (maxStaff < 0) {
                    throw new Exception("Please enter a positive number!");
                }

                //khởi tạo mảng
                es = new ExecutiveStaff[maxStaff];
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    //2.phương thức thêm nhân viên createStaff()
    public void createStaff() {
        if (nextStaff >= maxStaff) {
            System.err.println("They out of " + maxStaff);
            return;
        } 

    //3.viewStaff() method: salary >800
    public void viewStaff() {
        System.out.println("Staffs with salary >800: ");
        //dùng boolean kiểm tra có ít nhất 1 data thỏa điều kiện: nếu tìm thấy-> in thông tin, nếu k thấy-> in Nothing!
        boolean find = false;
        for (int i = 0; i < nextStaff; i++) {
            if (es[i].salary > 800) {
                //nếu tìm thấy, đánh dấu find thành true
                find = true;
                System.out.println("\nID: " + es[i].id);
                System.out.println("\nName: " + es[i].name);
                System.out.println("\nSalary: " + es[i].salary);
                System.out.println("\nBonus: " + es[i].bonus);
            }
        }
        if (!find) {
            System.err.println("Nothing!");
        }
    }

    //4.menu() method
    public void menu() {
        //khai báo biến
        String choice;
        do {
            System.out.println("\n===== Staff Management Menu =====");
            System.out.println("1.Add staff");
            System.out.println("2.Display staffs");
            System.out.println("3.Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextLine();
            choice = choice.toLowerCase();
            //switch-case
            switch (choice) {
                case "1" ->
                    createStaff();
                case "2" ->
                    viewStaff();
                case "3" -> {
                    System.out.println("Exit.");
                    System.exit(0);
                }

                case "add" ->
                    createStaff();
                case "display" ->
                    viewStaff();
                case "exit" -> {
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
        new StaffTest().menu();
    }
}
/*Note:*/
