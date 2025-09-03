/*Mô tả: giới thiệu cách duyệt qua một tập hợp (Set) bằng Iterator trong Java.
Đây là một ví dụ cơ bản nhưng rất quan trọng để hiểu sự khác nhau giữa Set và List,
cũng như cách Iterator hoạt động.\
    Làm quen với Set (cụ thể là HashSet)– tập hợp không lưu trữ phần tử trùng và không theo thứ tự.
    - Set: interface cha của HashSet.
    - HashSet: triển khai cụ thể của Set, không cho phép các phần tử trùng và không duy trì thứ tự

 */
package session01_utility;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 */
public class Ex06_ListIterator {
    //1.properties()
    Set days;
    Iterator iterator;//sử dụng Iterator cũng được
    //2.constructor
    public Ex06_ListIterator(){
        days= new HashSet();//HashSet tự động loại bỏ phần tử trùng, nên nếu thêm "Monday" hai lần, nó chỉ giữ lại một.
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
    }
    //3.display() method
    void display(){
        iterator= days.iterator();//days.iterator() trả về 1 Iterator giúp duyệt qua các phần tử trong Set
        while(iterator.hasNext()){//kiểm tra nếu còn phần tử
            System.out.println("\t. "+ iterator.next());//iterator.next(): lấy phần tử tiếp theo và in ra.
        }// Không thể dùng for i hoặc for-each để duyệt Iterator trực tiếp.
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
        new Ex06_ListIterator().display();
    }
}
