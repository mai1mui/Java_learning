
package session06_date_time;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Scanner;
public class Ex03_MonthDay_class {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Nhập ngày và tháng sinh
        System.out.print("Enter birth day(1-31): ");
        int day = scanner.nextInt();

        System.out.print("Enter month day (1-12): ");
        int month = scanner.nextInt();

        try {
            // Tạo đối tượng MonthDay từ ngày và tháng người dùng nhập
            MonthDay birthday = MonthDay.of(month, day);//đối tượng chứa ngày-thàng, k chứa năm
            MonthDay today = MonthDay.from(LocalDate.now());//lấy ngày-tháng hôm nay

            // So sánh với ngày hiện tại
            if (birthday.equals(today)) {
                System.out.println("🎉 Happy birth day!");
            } else {
                System.out.println("Not birthday today.");
            }
        } catch (Exception e) {
            System.out.println("Day or month is invalid.");
        }

        scanner.close();
    }
}
