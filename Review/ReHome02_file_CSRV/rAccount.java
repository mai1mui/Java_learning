/*
Cấu trúc:
//1.abstract class(trừu tượng): đảm bảo chung cho các lớp con có cùng output()method 
abstract class abs{
}
//2.DoiTuong class
class DoiTuong extends abs{
    //2.1.properties
    //2.2.parameterized constructor
    //2.3.output()method
}
//3.QuanLy class:xử lý toàn bộ logic
final class QuanLy{
    //3.1.properties
    //3.2.constructor
    //3.3.loadFile()method
    //3.4.load()method
    //3.5.input()method
    //3.6.search()method
    //3.7.login()method
    //3.8.saveFile()method
    //3.9.addNew()method
}
//4.ThucThi class
public class rAccount {
    //4.1.menu()method
    //4.2.main class
}

 */
package rfile_CSRV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//1.abstract class(trừu tượng): đảm bảo chung cho các lớp con có cùng output()method

abstract class abs {

    abstract String output();
}
//2.DoiTuong class

class DoiTuong extends abs {

    //2.1.properties
    String user, password;

    //2.2.parameterized constructor
    public DoiTuong(String user, String password) {
        this.user = user;
        this.password = password;
    }

    //2.3.output()method
    @Override
    public String output() {
        return user + "#" + password;
    }
}
//3.QuanLy class:xử lý toàn bộ logic

final class QuanLy {

    //3.1.properties
    List<DoiTuong> list;
    File file;
    Scanner sc = new Scanner(System.in);

    //3.2.constructor
    public QuanLy() {
        list = new ArrayList<>();
        file = new File("src/rfile_CSRV/Account.txt");
        try {
            if (file.exists()) {
                load();//chỉ load file nễu file tồn tại
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }

    //3.3.loadFile()method
    void loadFile() throws IOException {
        if (!file.exists()) {
            return;
        }
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String data;
        while ((data = br.readLine()) != null) {
            if (data.trim().isEmpty()) {
                continue;//bỏ qua dòng rống
            }
            //split(): tách chuỗi từ file
            String[] tmp = data.split("#");

            if (tmp.length < 2) {
                System.err.println("Invalid:" + data);
                continue;//bỏ qua dòng sai định dạng
            }

            list.add(new DoiTuong(tmp[0], tmp[1]));
        }
        br.close();
    }

    //3.4.load()method
    void load() throws IOException {
        //nếu list trồng-> load file
        if (list.isEmpty()) {
            loadFile();
        } else {
            //ngược lại: xóa list-> load file
            list.removeAll(list);
            loadFile();
        }
    }

    //3.5.input()method
    DoiTuong input() {
        String user, password;
        System.out.println("Enter user: ");
        user = sc.nextLine();
        System.out.println("Enter password: ");
        password=sc.nextLine();
        
        var doituong=new DoiTuong(user, password);
        return doituong;
    }

    //3.6.search()method
    boolean search(DoiTuong doituong) throws IOException {
        loadFile();
        for(var d:list){
            //so sánh data account.txt với các đối tượng trong list
            if((d.user.equals(doituong.user))&&(d.password.equals(doituong.password))){
                //nếu khớp-> trả về true
                return true;
            }
        }
        return false;
    }

    //3.7.login()method
    void login() throws IOException {
            boolean isOk=false;
            do{
                //input()method để nhập doituong
                DoiTuong doituong=this.input();
                //search()method để so sánh data
                isOk=search(doituong);
                if(!isOk){
                    System.out.println("Login failed!");
                }
            }
            while(!isOk);
            System.out.println("Login success.");
    }

    //3.8.saveFile()method
    void saveFile() throws IOException {
            boolean isOk=false;
            do{
                //input()method để nhập data
                DoiTuong doituong=this.input();
                //dùng search()method để so sánh data
                isOk=search(doituong);
                if(isOk){
                    System.out.println("Account exists.");
                }else{
                    FileWriter fw=new FileWriter(file,true);
                    BufferedWriter bw=new BufferedWriter(fw);
                    bw.write(doituong.output());
                    bw.flush();
                    bw.close();
                    System.out.println("Adding account successfully.");
                    break;
                }
            }
            while(!isOk);  
    }
    //3.9.addNew()method
    void addNew(){
        try {
            saveFile();
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}
//4.ThucThi class

public class rAccount {

    //4.1.menu()method
    public void menu() throws IOException{
        var quanly=new QuanLy();
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("-----MENU-----");
            System.out.println("1.Login");
            System.out.println("2.Add new account");
            System.out.println("3.Exit");

            System.out.println("Enter your choice(1|2|3): ");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    quanly.login();
                    break;
                case "2":
                    quanly.addNew();
                    break;
                case "3":
                    System.out.println("Exit programming...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong!");
            }
            //Continue?
            System.out.println("Continue(Y/N)?");
            String option = sc.nextLine();
            if (!option.equalsIgnoreCase("Y")) {
                System.exit(0);
            }
        } while (true);
    }

    //4.2.main class
    public static void main(String[] args) throws IOException {
        new rAccount().menu();
    }
}
