package session03_OOP.Ex02_Office;

/**
 *
 * @author Harori
 */
public class StudentServicesOffice {

    protected String sotaysinhvien = "Quyền và Nghĩa vụ của Sinh viên.";

    public StudentServicesOffice() {
        // Cách 2: In trực tiếp tên lớp cha
        System.out.println("Tên lớp cha (trực tiếp): " + StudentServicesOffice.class.getName());

        // Cách 3: Dùng getSuperclass() (Reflection)
        Class<?> parentClass = this.getClass().getSuperclass();
        System.out.println("Tên lớp cha (Reflection): " + parentClass.getName());

        // Tên lớp con
        System.out.println("Tên lớp con: " + this.getClass().getName());
    }
}
