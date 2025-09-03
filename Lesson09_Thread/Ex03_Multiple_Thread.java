/*Mô tả: minh họa 2 luồng thực thi đồng thời
Mục đích:
- tạo nhiều luồng chạy song song bằng cách kế thừa lớp thread
- mỗi luồng thực hiện 1 tác vụ riêng biệt(in thông tin) trong vòng lặp, có thời gian nghỉ 10 giây mỗi lần
- mô phỏng 2 tiến trình alfm việc độc lập cùng lúc

class Me extends Thread { ... }   // Luồng thứ nhất
class You extends Thread { ... } // Luồng thứ hai
public class Ex03_Multiple_Thread {
    public static void main(String[] args) {
        new Me().start();        // Khởi chạy luồng Me
        new You().start();       // Khởi chạy luồng You
    }
}

*/

package session03_thread;

//1. class Me: luồng thứ 1 kế thừa lớp thread và ghi đè run()method
class Me extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //in ra tên thread
            System.out.println(String.format("Me [Name: %s]", Thread.currentThread().getName()));
            try {
                Thread.sleep(10000);//ngủ 10 giây- để mô tả 1 tác vụ tốn thời gian
            } catch (InterruptedException e) {
                /*InterruptedException là một ngoại lệ (exception) trong Java xảy ra khi một luồng (thread) đang ngủ,
                chờ đợi hoặc bị chặn thì bị "gián đoạn" bởi luồng khác.*/
                System.err.println(e.toString());
            }
        }
    }
}
//2. class You: luồng thứ 2

class You extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //in ra ID thread
            System.out.println(String.format("=> call you [Name: %s]", Thread.currentThread().getId()));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
        }
    }
}
//3. Main class

public class Ex03_Multiple_Thread {

    public static void main(String[] args) {
        new Me().start();//khởi chạy luồng 1
        new You().start();//khởi chạy luồng 2
        /*- 2 luồng khởi tạo và chạy song song với nhau bằng .start()
          - cả 2 run() sẽ chạy đồng thời thay vì lần lượt
        */
    }
}