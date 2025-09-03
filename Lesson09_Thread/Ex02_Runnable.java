/*Mô tả: 1 cách thứ 2 để tạo luồng(thread) là thông qua giao diện Runnable
Đây là phương pháp dc ưu tiên hơn kế thừa lớp thread vì nó linh hoạt, hỗ trợ kế thừa đa lớp 
Mục đích:
- khởi tạo 1 đối tượng thread từ Runnable
- In ra tên thread rồi chạy run() thông qua start()
*/

package session03_thread;

public class Ex02_Runnable implements Runnable{
    /*implements Runnable: lớp Ex02_Runnable k kế thừa thread
      implements Runnable cài đặt giao diện Runnable yêu cầu định nghĩa hàm run()*/
    @Override
    public void run() { 
        System.out.println("This is class implements Runnable");
    }
    
    public static void main(String[] args) {
        var ex02 = new Ex02_Runnable();//tạo 1 đối tượng của lớp thực thi Runnable
        Thread thread = new Thread(ex02, "Ex02_Runnable");
        /*- tạo 1 luồng mới tên thread
          - gắn Runnable này cho luồng
          - đặt tên cho luồng là Ex02_Runnable*/
        System.out.println("Thread name: " + thread.getName());//getName(): lấy tên của thread mới tạo là Ex02_Runnable
        thread.start();//gọi run()method bên trong Runnable
    }
}
/*  Luồng hoạt động:
1. tạo đối tượng Runnable
2. tạo đối tượng thread, truyền Runnable vào
3. in tên thread
4. gọi start() => chạy Runnable().run() trong luồng mới
    So sánh với kế thừa Thread và giao diện Runnable
    Đặc điểm                |   extends Thread      |   implements Runnable
Cách dùng                   |kế thừa lớp Thread     |cài đặt Runnable, truyền vào Thread
Kế thừa lớp khác            |NO                     |YES
Tính linh hoạt              |thấp                   |cao
Tách biệt nhiệm vụ và xử lý |thấp                   |rõ ràng
*/