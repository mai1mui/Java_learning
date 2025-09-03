package OOP;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Ex01_QuanLy {

    //1.khai báo + khởi tạo danh sách các đối tượng
    List<Ex01_DoiTuong> list = new ArrayList<>();
    File file;

    /*
    List<DoiTuong> : list là interface, DoiTuong là kiểu dữ liệu mà danh sách sẽ chứa
    ArrayList: là 1 lớp cụ thể trong util.List
    new ArrayList<>(): khởi tạo 1 danh sách rỗng(ban đầu chưa có phần tử)
    <>: gọi là diamound operator giúp suy ra kiểu DoiTuong từ bên trái
    List<DoiTuong>doituong = new ArrayList<>(); ->"Tạo một danh sách có tên là doituong để lưu trữ các đối tượng kiểu DoiTuong, và khởi tạo nó bằng ArrayList."
     */
    //2.add()method
    public void add() {
        Ex01_DoiTuong doituong = new Ex01_DoiTuong();//gọi đối tượng
        //gọi phương thức đối tượng
        doituong.input();
        list.add(doituong);
    }

    //3.show()method
    public void show() {
        for (Ex01_DoiTuong doituong : list) {
            //gọi phương thức đối tượng
            doituong.display();
        }
    }

    //4.writeFile()method theo kiểu FileWrite()
    public void writeFile() {
        //khai báo đường dẫn file
        file = new File("src/OOP/zEx01.txt");
        //dùng try-with-resources để đóng file
        try (FileWriter fw = new FileWriter(file, true);) {
            System.out.println("Information");
            //ghi văn bản vào file
            for (Ex01_DoiTuong doituong : list) {
                fw.write(doituong.displayString());
                fw.write("\n------------------\n");
            }
            System.out.println("Saved successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
