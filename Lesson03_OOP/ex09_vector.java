package session03_OOP;

import java.util.Vector;
import java.util.Iterator;

public class ex09_vector {
    public ex09_vector() {
        // khai báo
        Vector<Integer> num = new Vector<>();

        // khởi tạo 5 số
        for (int i = 0; i < 5; i++) {
            num.add(i + 1);  // Vector sẽ chứa: 1, 2, 3, 4, 5
        }

        // duyệt bằng Iterator
        Iterator<Integer> element = num.iterator();
        
        while (element.hasNext()) {
            System.out.println(element.next());  // ✅ Gọi đúng hàm next()
        }
    }
    
    public static void main(String[] args) {
        new ex09_vector(); // chạy constructor
    }
}
