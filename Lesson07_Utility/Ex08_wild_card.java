/*Mô tả: minh họa khái niệm trong java generic: Wildcards(<?>)-cách sử dụng dấu ? (wildcards) để xử lý nhiều kiểu generic
Mục đích: cách tạo 1 phương thức chấp nhận mọi loại Collection<T> mà k cần biết T cụ thể là gì
            Điều này có ý nghĩa: có thể truyền Collection<String>, Collection<Integer>, Collection<Double>,...
    vào 1 hàm duy nhất mà k cần overload từng kiểu*/
package session01_utility;
import java.util.ArrayList;
import java.util.Collection;
public class Ex08_wild_card {
    //1.display() method
    static void display(Collection<?>collection){
        System.out.println(collection);
    }/*<?>: là unbounded wildcard, nghĩa là "bất kỳ kiểu gì cũng được".
        Collection<?> có thể nhận: 
            - Collection<String>
            - Collection<Integer>
            - Collection<Employee> v.v...
        Đây là cách giúp 1 hàm generic mà k cần biết trước kiểu dữ liệu cụ thể bên trong Collection
    */
    //2.main()method
    public static void main(String[] args) {
        //2.1.Initial
        Collection<String>string=new ArrayList<>();//syntax: tạo 1 Collection có kiểu dữ liệu string
        Collection<Integer>integer= new ArrayList<>();
        //2.2.add elements(thêm phần tử vào mỗi collection)
        for(int i=0;i<5;i++){
            string.add("Person: "+(i+1));//thêm Person:1->Person:5 vào string
            integer.add(2*(i+1));//thêm 2,4,6,8,10 vào integer
        }
        //2.3.display
        System.out.println("Wild card with String: ");
        display(string);
        System.out.println("Wild card with Integer: ");
        display(integer);
    }
}
