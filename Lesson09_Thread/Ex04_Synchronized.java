/*Mô tả: tình huống điển hình của đa luồng (multithreading) là chia sẻ tài nguyên và đồng bộ hóa (synchronization)
Mô phỏng 2 tài khoản truy cập và thao tác cùng 1 đối tượng BankAccount-> hiểu đc tác dụng của synchronized
Mục đích:
- mô phỏng 2 luồng  (Account01 và Account02) cùng truy cập một đối tượng BankAccount.
- dùng từ khóa **synchronized** để tránh xung đột khi nhiều luồng cùng truy cập và thay đổi dữ liệu

*/
package session03_thread;
//1. BankAccount class : chứa logic tài khoản ngân hàng
/*mô phỏng việc tiết kiệm tiền: mỗi vòng lặp tăng 10% số tiền*/
class BankAccount{ 
    //1.1 simple method - not synchronized
    
    void simpleSave(int capital){ 
        var id = Thread.currentThread().getId();
        for(int i = 0; i < 5; i++){ 
            capital += capital * 10/100;
            System.out.println(String.format("Balance of account-%d: %d",id, capital));//in ra ID của thread và số dư tài khoản sau mỗi lần tăng
            try {
                Thread.sleep(1000);//mỗi lần nghỉ 10s
            } catch (InterruptedException e) {
            }
        }
    }
    /*k sử dụng synchronized nên nếu có nhiều luồng gọi hàm này cùng lúc,
    kết quả có thể bị sai lệch -> đây là hiện tượng race condition*/
    //1.2 Advanced method - synchronized
    synchronized void save(int capital) {
        var id = Thread.currentThread().getId();
        for (int i = 0; i < 5; i++) {
            capital += capital * 10 / 100;
            System.out.println(String.format("[Synchronized] Balance of account-%d: %d", id, capital));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
        }
    }
}
//2. Account01 class kế thừa lớp thread nhận đối tượng BankAccount 
class Account01 extends Thread{ 
    BankAccount capital;
    
    public Account01(BankAccount capital){ 
        this.capital = capital;
    }
    
     @Override
    public void run() { 
        capital.save(0);//gọi capital.save(...) từ run().
    }
}
//3. Account02 class  kế thừa lớp thread nhận đối tượng BankAccount
class Account02 extends Thread{ 
    BankAccount capital;
    
    public Account02(BankAccount capital){ 
        this.capital = capital;
    }
    
     @Override
    public void run() { 
        capital.save(100);
    }
}
//4. Main class 
public class Ex04_Synchronized {
    public static void main(String[] args) {
        BankAccount capital = new BankAccount();
        // Account01 dùng capital.save(0);
        new Account01(capital).start();
        // Account02 dùng capital.save(100);
        new Account02(capital).start();
    }
}
/* Giải thích kết quả hiển thị:
Luồng Account01 (ID 26):
- capital = 0 → 0 + 0 * 10% = 0 (in ra 0 5 lần).
- Do synchronized, luồng này hoàn thành trước khi Account02 bắt đầu.
Luồng Account02 (ID 27):
- capital = 100 → tăng 10% mỗi lần:
- Lần 1: 100 + 10 = 110
- Lần 2: 110 + 11 = 121
- ... → Kết quả cuối: 160.
*/