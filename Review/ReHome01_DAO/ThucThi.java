package rDAO;
//1.DoiTuong class

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DoiTuong {

    //1.1.properties
    String code, name;

    //1.2.constructor parametterized
    public DoiTuong(String code, String name) {
        this.code = code;
        this.name = name;
    }

    //1.3.toString()
    @Override
    public String toString() {
        return String.format("Code: %s\nName: %s", code, name);
    }

}
//2.interface DoiTuongDAO

interface DoiTuongDAO {

    List<DoiTuong> list = new ArrayList<>();

    void insert(DoiTuong doituong);
}
//3.class DoiTuongDAOImpl

class DoiTuongDAOImpl implements DoiTuongDAO {

    List<DoiTuong> list;
    //DoiTuongDAOImpl()method

    public DoiTuongDAOImpl() {
        list = new ArrayList<>();
    }

    //insert()method
    @Override
    public void insert(DoiTuong doituong) {
        list.add(doituong);
        System.out.println("Insert successfully.");
    }

    public List<DoiTuong> select() {
        return list;
    }
}
//4.main class

public class ThucThi {

    //3.1.QuanLy class
    String code, name;
    DoiTuongDAOImpl dao = new DoiTuongDAOImpl();
    Scanner sc = new Scanner(System.in);

    //3.1.1.input()method
    DoiTuong input() {
        System.out.println("Enter code: ");
        code = sc.nextLine();
        System.out.println("Enter name: ");
        name = sc.nextLine();

        return new DoiTuong(code, name);

    }
    //3.1.2.addNew()method

    public void addNew() {
        DoiTuong doituong = input();
        dao.insert(doituong);
    }
    //3.1.3.display()method

    public void display() {
        for (DoiTuong doituong : dao.select()) {
            System.out.println(doituong);
        }

    }

    //3.2.menu()method
    public void menu() {
        String choice;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("---MENU---");
            System.out.println("1.Add new");
            System.out.println("2.Display");
            System.out.println("3.Exit");
            
            System.out.println("Enter your choice(1|2|3): ");
            choice=sc.nextLine();
            
            switch(choice){
                case"1":
                    addNew();
                    break;
                case"2":
                    display();
                    break;
                case"3":
                    System.out.println("Exit progarmming...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong!");
            }
            //Continue?
            System.out.println("Continue(Y/N)?");
            String option=sc.nextLine();
            if(!option.equalsIgnoreCase("Y")){
                System.exit(0);
            }
        }
        while(true);
    }

    //3.3.main
    public static void main(String[] args) {
        new ThucThi().menu();
    }
}
