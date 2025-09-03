package session06_date_time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* UTC - Coordinated Universal Time
    - UTC (Giờ Phối hợp Quốc tế) là chuẩn thời gian cơ bản được dùng để đồng bộ thời gian trên toàn cầu.
    - Không phụ thuộc múi giờ cụ thể, không có giờ mùa hè (Daylight Saving Time).
    - Là mốc tham chiếu để xác định các múi giờ khác (ví dụ: Việt Nam là UTC+7)
   ICT - Indochina Time
    - ICT (Giờ Đông Dương) là múi giờ được sử dụng ở các quốc gia Đông Dương như:
        Việt Nam,         Thái Lan,         Lào,         Campuchia
    - ICT luôn là UTC+7 (không thay đổi theo mùa).
*/
public class Ex01_new_api {
    // 1. Properties
    SimpleDateFormat simple;
    DateTimeFormatter pattern;

    // 2. Constructor
    public Ex01_new_api() {
        simple = new SimpleDateFormat("dd/MMM/yyyy");
        pattern = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
    }

    // 3. Old date and time API
    void listOldAPI() {
        // 3.1. Using Date -> day of week (0-6)
        var today = new Date();
        var dd = today.getDay();    
        var mm = today.getMonth();

        System.out.println("<1. Simple with Date>");
        String sDate = String.format("Date index of: \n+ Day (Mon-Sun): %s\n+ Month (Jan-Dec): %s",dd, mm);
        System.out.println(sDate);
        System.out.println("Today (Date): " + today);
        System.out.println("Today (formatted Date): " + simple.format(today));

        // 3.2. Using Calendar -> day of week (1-7)
        TimeZone hcmc = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
        Calendar calendar = Calendar.getInstance(hcmc);

        var day = calendar.get(Calendar.DAY_OF_WEEK);
        var month = calendar.get(Calendar.MONTH);

        System.out.println("<2. Simple with Calendar>");
        String sCalendar = String.format("Date index of: \n+ Day (Sun-Sat): %s\n+ Month (Jan-Dec): %s",day, month);
        System.out.println(sCalendar);
        System.out.println("Today (Calendar): " + calendar);
        System.out.println("Today (formatted Calendar): " + simple.format(calendar.getTime()));
    }

    // 4. New date and time API
    void listNewAPI(){
        LocalDate today=LocalDate.now();
        
        var dd = today.getDayOfWeek();    
        var mm = today.getMonth();

        System.out.println("<3. Pattern with Date>");
        String sDate = String.format("Display the name of: \n+ Day (Mon-Sun): %s\n+ Month (Jan-Dec): %s",dd, mm);
        System.out.println(sDate);
        System.out.println("Today (LocalDate): " + today);
        System.out.println("Today (format LocalDate): " + simple.format(pattern));
    }
    // 5. Main method
    public static void main(String[] args) {
        var ex01 = new Ex01_new_api();
        ex01.listOldAPI();
        ex01.listNewAPI();
    }
}
