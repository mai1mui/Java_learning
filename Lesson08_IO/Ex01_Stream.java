/*Mô tả: làm quen với các luồng nhập/xuất chuẩn gồm: 
- System.in (luồng nhập chuẩn) với Scanner để nhập chuỗi từ bàn phím,
- System.out (luồng xuất chuẩn) hiển thị kết quả,
- System.err (luồng xuất lỗi)
*/
import java.util.Scanner;
public class Ex01_Stream {

    public static void main(String[] args) {
        //1.Stanndard in Stream
        Scanner sc = new Scanner(System.in);
        String output = null;
        //cấu trúc vòng lặp repeat:do{....} while();
        repeat:
        do {
            //2.stanndard out Stream
            System.out.println("enter a string 'end' to stop: ");
            output = sc.nextLine();
            //kiểm tra lỗi rỗng hoặc null
            if ((output == null)||(output.isBlank())) {
                //3.Stanndard err stream
                System.err.println("string cannot left blank: ");
                continue repeat;
            }
            //hiển thị kết quả
            System.out.println("Display: " + output);
        } while (!output.equalsIgnoreCase("end"));//kết thúc vòng lặp khi user nhập end
    }
}