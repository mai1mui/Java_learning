package assign_laptops_setValues;

import java.util.Scanner;

public class LaptopsTest {

    public Laptops[] laptops = new Laptops[50];
    Scanner sc = new Scanner(System.in);
    int cnt = 0;

    //1.thêm mới
    public void addNew() {
        //1.khai báo biến
        String code, name;
        int price;
        //2.nhập giá trị cho biến
        //2.1.code k để trống
        do {
            try {
                //phần muốn bắt lối
                System.out.print("Enter code: ");
                code = sc.nextLine();
                if (code.isBlank()) {
                    throw new Exception("Code is required!");
                }
                break;// hợp lệ thì thoát khỏi vòng lặp
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //2.2.name k để trống
        do {
            try {
                //phần muốn bắt lỗi
                System.out.print("Enter name: ");
                name = sc.nextLine();
                if (name.isBlank()) {
                    throw new Exception("Name is required!");
                }
                break;// hợp lệ thì thoát khỏi vòng lặp
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //2.3.price lớn hơn 0
        do {
            try {
                System.out.print("Enter price: ");
                price = Integer.parseInt(sc.nextLine());
                if (price < 0) {
                    throw new Exception("Price must be greater than 0!");
                }
                break;// hợp lệ thì thoát khỏi vòng lặp
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        //3.khởi tạo đối tượng
        laptops[cnt] = new Laptops();
        laptops[cnt].setValues(code, name, price);
        cnt++;

    }

    //2.tìm kiếm
    public void search() {
        String s;
        boolean find = false;
        do {
            //nhập giá trị cần tìm

            System.out.println("Enter code to find: ");
            s = sc.nextLine();
            find = false;
            //so sánh giá trị s với giá trị trong mảng
            for (int i = 0; i < cnt; i++) {
                /*dùng equalsIgnoreCase():so sánh 2 chuỗi k phân biệt hoa thường */
                if (laptops[i].code.equalsIgnoreCase(s)) {
                    System.out.println(laptops[i]);
                    find = true;
                }
                break; // dừng khi đã tìm thấy
            }
            if (!find) {
                System.out.println("Not found!");
            }
        } while (!find);
    }

    //3.hiển thị
    public void display() {

        for (int i = 0; i < cnt; i++) {
            System.out.println(laptops[i]);
        }

    }

}
