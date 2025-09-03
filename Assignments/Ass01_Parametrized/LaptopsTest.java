package assignment_laptops_parametrized;

import java.util.Scanner;

public class LaptopsTest {

    public Laptops[] laptops = new Laptops[50];
    Scanner sc = new Scanner(System.in);
    int cnt = 0;

    //Nhập laptop mới
    public void addNew() {
        //1.khai báo biến
        String code, name;
        int price;
        //2.nhập giá trị cho biến
        System.out.print("Enter code: ");
        code = sc.nextLine();
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter price: ");
        price = Integer.parseInt(sc.nextLine());
        //3.khởi tạo đối tượng
        laptops[cnt] = new Laptops(code, name, price);
        cnt++;
    }

    //hiển thị
    public void display() {
        if (cnt == 0) {
            System.err.println("nothing");
        } else {
            for (int i = 0; i < cnt; i++) {
                System.out.println(laptops[i]);
            }
        }
    }

    //tìm kiếm
    public void search() {
        //nhập giá trị cần tìm
        String s;
        System.out.println("enter code to find: ");
        s = sc.nextLine();
        boolean find = false;
        //so sánh giá trị s với giá trị trong mảng
        for (int i = 0; i < cnt; i++) {
            /*dùng equalsIgnoreCase():so sánh 2 chuỗi k phân biệt hoa thường */
            if (laptops[i].code.equalsIgnoreCase(s)) {
                System.out.println(laptops[i]);
                find = true;
            } 
        }
        if (!find) {
                System.out.println("Not found!");
            }
    }  

}
