package session03_OOP;

public class Ex04_initializer {

    //1.khởi tạo
    String name = "Le Van A";
    int age = 20;
    String rollNo, batch, course;

    {
        rollNo = "Student001";
        batch = "T2.2410.E0";
        course = "ACCP-7091";
    }

    @Override
    public String toString() {

        return String.format("$s- %d- %s-%s-%s", name, age, rollNo, batch, course);

    }

    public static void main(String[] args) {
        System.out.println(new Ex04_initializer());
    }
    //2.khởi tạo bằng initializer
}
