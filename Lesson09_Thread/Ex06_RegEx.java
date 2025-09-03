/*Mô tả: sử dụng Regex(biểu thức chính quy) để kiểm tra định dạng chuỗi
 */
package session03_thread;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex06_RegEx {

    //1.check()method
    static boolean check(String s) {
        String regex;
        Pattern pattern;
        Matcher matcher;

        regex = "^[T]\\d{1}[.]\\d{4}[.][MAE][01]$";
        /*Giải thích: 
            ^: mở bắt lỗi
            [T]: kí tự đầu tiên là T
            \\d{1}: theo sau là 1 chữ số (0-9)
            [.]: kí tự chấm .(phải escape bằng \\)
            \\d{4}: tiếp theo là 4 chữ số
            [MAE]: 1 trong 3 chữ cái M,A,E
            [01]: kết thúc =0 hoặc 1
            $: kết thúc chuỗi
         */
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(s);

        return matcher.matches();//giá trị trả về là true/false
    }

    //2.main()method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isOK = false;
        //vòng lặp
        do {
            System.out.println("Enter class name: ");
            String s = sc.nextLine();
            if (check(s)) {//gọi check(s)method để kiểm tra định dạng
                //nếu đúng-> thông báo và đổi giá trị isOK thành true
                System.out.println("Class is correct. Congratulation!");
                isOK = true;
            } else {
                //nếu sai-> báo lỗi
                System.err.println("Try again!");
            }
        } while (!isOK);
    }
}
