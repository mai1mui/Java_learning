package session05_exeption;
//1.exeption sub class

import java.util.Scanner;

class MyException extends Exception {

    public MyException(String s) {
        super(s);
    }

}
//2.main class

public class Ex08_custom_exception {

    int n, m;
    Scanner sc = new Scanner(System.in);

    void caculate() throws MyException {
        System.out.println("enter first n: ");
        n = sc.nextInt();
        System.out.println("enter second n: ");
        m = sc.nextInt();

        if (m == 0) {
            throw new MyException("khong the chia cho zero!");
        } else {
            String out = String.format("%d/%d=%d", n, m, n / m);
            System.out.println(out);
        }

    }

    public static void main(String[] args) {
        try {
            new Ex08_custom_exception().caculate();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }
}
