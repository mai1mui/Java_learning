package assignment_laptops_input_method;
import java.util.Scanner;
public class LaptopsTest {

    public Laptops[] laptops = new Laptops[50];
    Scanner sc = new Scanner(System.in);
    int cnt = 0;

    //Nhập laptop mới
    public void addNew() {
        //3.khởi tạo đối tượng
        laptops[cnt] = new Laptops();
        laptops[cnt].input();
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
         String s;
         boolean find = false;
        do{
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
            break;
        }
        if (!find) {
                System.out.println("Not found!");
        }
        }
        while(!find);
        
    }  

}
