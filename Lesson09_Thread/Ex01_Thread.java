/*Mô tả: minh họa cách tạo và chạy 1 luồng (thread) bằng cách kế thừa lớp Thread.
Đây là 1 phần quan trọng trong lập trình đa luồng(multithreading)- cho phép 1 chương trình thực hiện nhiều công việc cùng lúc
*/
package session03_thread;
public class Ex01_Thread extends Thread {
    /*Lớp Ex01_Thread kế thừa lớp Thread có sẵn trong java
      Đối tượng của Ex01_Thread là 1 Thread*/
    @Override
    public void run() {
        /*Đây là method dc gọi khi thread bắt đầu chạy
          khi gọi start(), java sẽ tự động gọi run() trong 1 luồng riêng biệt
        (không phải main)*/
        //logic chạy song song sẽ nằm trong đây
        var id = Thread.currentThread().getId();
        /*Lấy ra thông tin về chính thread đang chạy run()
        getId(): trả về mã định danh của thread(dạng số)*/
        var name = Thread.currentThread().getName();//getName(): trả về tên của thread, thường mặc định là Thread-0 nếu chưa đặt tên
        System.out.println("This is Class that extends Thread!");
        System.out.println("Thread name is " + name);
        System.out.println("And Thread ID: " + id);
    }
    public static void main(String[] args) {
        var ex01 = new Ex01_Thread();//ex01 gọi là 1 instance
        ex01.start();
        /*khi start() đc gọi sẽ:
        - kích hoạt 1 thread mới
        - thread này chạy tự động run() method
        - chạy đồng thời với thread chính(main thread)*/
    }
}