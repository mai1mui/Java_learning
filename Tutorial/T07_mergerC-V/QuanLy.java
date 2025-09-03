package tutorial07_merger2_3;

import java.util.Scanner;

public class QuanLy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoiTuong doituong = new DoiTuong();

        System.out.print("Enter code: ");
        String code = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        doituong.setValues(code, name);

        System.out.println("\n== Information ==");
        System.out.println(doituong);

    }
}
