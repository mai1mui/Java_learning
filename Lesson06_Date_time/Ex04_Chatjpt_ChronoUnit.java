
package session06_date_time;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ex04_Chatjpt_ChronoUnit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Định dạng ngày người dùng sẽ nhập
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");

        try {
            // Nhập ngày thứ nhất
            System.out.print("Enter first day (ex: 01-01-2020): ");
            String input1 = scanner.nextLine();
            LocalDate date1 = LocalDate.parse(input1, formatter);

            // Nhập ngày thứ hai
            System.out.print("Enter second day (ex: 11-06-2025): ");
            String input2 = scanner.nextLine();
            LocalDate date2 = LocalDate.parse(input2, formatter);

            // Đảm bảo date1 luôn là ngày nhỏ hơn để tránh số âm
            if (date1.isAfter(date2)) {
                LocalDate temp = date1;
                date1 = date2;
                date2 = temp;
            }

            // Tính số năm, tháng, ngày bằng Period
            Period period = Period.between(date1, date2);
            long totalDays = ChronoUnit.DAYS.between(date1, date2);
            long totalMonths = ChronoUnit.MONTHS.between(date1, date2);
            long totalYears = ChronoUnit.YEARS.between(date1, date2);

            System.out.println("\nThe distance between two days:");
            System.out.printf("- %d year, %d month, %d day\n",
                    period.getYears(), period.getMonths(), period.getDays());
            System.out.printf("- Total days: %d\n", totalDays);
            System.out.printf("- Total months: %d\n", totalMonths);
            System.out.printf("- Total years: %d\n", totalYears);

        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter in dd-MM-yyyy format.");
        }

        scanner.close();
    }
}
