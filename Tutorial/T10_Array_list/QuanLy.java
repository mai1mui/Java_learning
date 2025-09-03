package tutorial01_array_list;

import java.util.ArrayList;

public class QuanLy {

    //1.properties()
    ArrayList<DoiTuong> list = new ArrayList<>();

    //2.addNew() method
    void addNew() {
        //dùng array-list
        DoiTuong doituong = new DoiTuong();
        list.add(doituong);
    }

    void display() {
        list.forEach((doituong) -> {
            System.out.println(doituong.output());
        });
    }
}
