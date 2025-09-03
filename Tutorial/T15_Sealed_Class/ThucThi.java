package tutorial06_Sealed_Class;

import java.sql.*;
import java.util.Scanner;
import session04_JDBC.zEx01_SQL;

// 1. Sealed class CHA
sealed class CHA permits DoiTuong {
    Scanner sc = new Scanner(System.in);

    // Username
    protected String getName() {
        String name;
        do {
            System.out.print("Enter username: ");
            name = sc.nextLine();
            if (name.isBlank()) {
                System.err.println("User name is required!");
            }
        } while (name.isBlank());
        return name;
    }

    // Password
    protected String getPass() {
        String pass;
        do {
            System.out.print("Enter password: ");
            pass = sc.nextLine();
            if (pass.isBlank()) {
                System.err.println("Password is required!");
            }
        } while (pass.isBlank());
        return pass;
    }
}

// 2. DoiTuong class
final class DoiTuong extends CHA {
    String name, pass;

    public void input() {
        name = getName();
        pass = getPass();
    }
}

// 3. QuanLy
class QuanLy {
    // 3.1 Properties
    Connection cnn;
    String user = "sa";
    String password = "127897";
    String database = "stronghold";

    PreparedStatement st;
    ResultSet rs;

    // 3.2 Constructor
    public QuanLy() {
        cnn = new zEx01_SQL().doConnect(user, password, database);
    }

    // 3.3 load() method
    boolean load(String name, String pass) {
        String query = "select * from [user] where Username=? and Password=?";
        try {
            st = cnn.prepareStatement(query);
            st.setString(1, name);
            st.setString(2, pass);
            rs = st.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println(e.toString());
            return false;
        }
    }

    // 3.4 insert() method: đăng ký mới
    void insert(String name, String pass) {
        String query = "insert into [user] values (?, ?)";
        try {
            st = cnn.prepareStatement(query);
            st.setString(1, name);
            st.setString(2, pass);
            int cnt = st.executeUpdate();
            if (cnt == 0) {
                System.err.println("Register failed!");
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }

    // 3.5 login() method
    void login() {
        DoiTuong doituong;
        do {
            doituong = new DoiTuong();
            doituong.input();
        } while (!load(doituong.name, doituong.pass));
        System.out.println("Login successful!");
    }

    // 3.6 addNew() method
    void addNew() {
        DoiTuong doituong;
        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            doituong = new DoiTuong();
            doituong.input();

            if (load(doituong.name, doituong.pass)) {
                System.err.println("Account already exists!");
            } else {
                insert(doituong.name, doituong.pass);
                System.out.println("Registration successful!");
            }

            System.out.print("Do you want to continue?? (y/n): ");
            choice = sc.nextLine();
        } while (choice.equalsIgnoreCase("y"));
    }
}

// 4. ThucThi
public class ThucThi {
    void menu() {
        QuanLy quanly = new QuanLy();
        Scanner sc = new Scanner(System.in);
        String option;

        do {
            System.out.println("-------------------");
            System.out.println("\t1. Login");
            System.out.println("\t2. Add new account");
            System.out.println("\t3. Exit");
            System.out.println("-------------------");
            System.out.print("Enter your choice: ");
            option = sc.nextLine();

            switch (option) {
                case "1" -> quanly.login();
                case "2" -> quanly.addNew();
                case "3" -> {
                    System.out.println("Exit");
                    System.exit(0);
                }
                default -> System.err.println("Wrong!");
            }

            // Continue?
            System.out.print("Continue (y/n)? ");
            String progress = sc.nextLine();
            if (!progress.equalsIgnoreCase("y")) {
                System.exit(0);
            }

        } while (true);
    }

    // 4.2. Main method
    public static void main(String[] args) {
        var thucthi = new ThucThi();
        thucthi.menu();
    }
}
