package OOP;

import java.util.Scanner;

public class Ex01_DoiTuong {

    //1.properties
    String name;
    int id, age;
    Scanner sc = new Scanner(System.in);

    //2.input()method
    public void input() {
        //name
        do {
            try {
                System.out.println("enter name: ");
                name = sc.nextLine();
                if (name.isBlank()) {
                    throw new Exception("Name is required!");
                }
                break;//nếu k lỗi thì ngưng vòng lặp
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //age
        do {
            try {
                System.out.println("enter age: ");
                String input = sc.nextLine();
                if (input.isBlank()) {
                    throw new Exception("Age is required!");
                }

                age = Integer.parseInt(input);
                if (age < 0) {
                    throw new Exception("Age must be greater than 0!");
                }
                break;
            } catch (NumberFormatException e){
                System.err.println("Age must be a number!");
            }catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (true);
    }

    //3.display()method
    public void display() {
        
        System.out.println("Name: " + name + "\nAge: " + age);
    }

    public String displayString() {
        return "Name: "+name + "\nAge: " + age;
    }
    /*
    case1:
        sử dụng toString()method có giá trị trả về (return)
    case2: 
        sử dụng void display()method để hiển thị trên màn hình nhưng k có giá trị trả về nên k thể lưu file
        cần tạo thêm displayString()method có giá trị trả về
    */
}
