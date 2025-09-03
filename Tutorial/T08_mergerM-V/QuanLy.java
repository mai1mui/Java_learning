package tutorial08_merger1_2;

import java.util.Scanner;

public class QuanLy {
    // Class DoiTuong gộp trong đây luôn
    public static class DoiTuong {
        public String code, name;

        public void setValues(String code, String name) {
            this.code = code;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("+Code: %s\n+Name: %s", code, name);
        }
    }

    private DoiTuong doituong;
    private Scanner sc = new Scanner(System.in);

    public void addNew() {
        System.out.print("Enter code: ");
        String code = sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        doituong = new DoiTuong();
        doituong.setValues(code, name);
    }

    public void display() {
        if (doituong != null) {
            System.out.println(doituong);
        } else {
            System.out.println("No data to display.");
        }
    }
}
