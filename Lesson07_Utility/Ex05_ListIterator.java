/*Mô tả: minh họa cách sử dụng ListIterator để duyệt một danh sách (List) các phần tử trong Java.
Mục đích chính là giới thiệu cách dùng ListIterator để duyệt tiến (next) qua các phần tử của List,
đồng thời gợi ý về kiểm tra dữ liệu trước khi duyệt.
 */
package session01_utility;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
/**
 */
public class Ex05_ListIterator {
    //1.properties()
    List days;
    //iterator: 1 biến thuộc kiểu ListIterator dùng để duyệt danh sách days
    ListIterator iterator;//sử dụng Iterator iterator; cũng được
    //2.constructor
    public Ex05_ListIterator(){
        //tạo 1 đối tượng LinkedList mới
        days= new LinkedList();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
    }
    //3.display() method
    void display(){
        //khởi tạo iterator để duyệt danh sách days
        iterator= days.listIterator();
        while(iterator.hasNext()){
            System.out.println("\t. "+ iterator.next());
        }
        //nếu muốn báo lỗi
        /*if(iterator.hasNext()){
            while(iterator.hasNext()){
            System.out.println("\t. "+ iterator.next());
        }
        }else{
            System.out.println("Nothing to display!");
        }*/
    }
    public static void main(String[] args) {
        new Ex05_ListIterator().display();
    }
}
