/*Mô tả: minh họa chương trình copy nội dung file bằng công nghệ NIO(New IO) sử dụng FileChannel
Mục đích: copy nội dung từ file zEx02.txt -> sang file zEx08.txt bằng cách sử dụng FileChannel.transferFrom()- 1 phương 
thức hiệu quả hơn InputStream/OutputStream truyền thống
*/
package session02_IO;
import java.io.IOException;
import java.io.RandomAccessFile;//RandomAccessFile: cho phép đọc/ghi vào bất kỳ vị trí nào của file (chế độ "rw" nghĩa là đọc và ghi).
import java.nio.channels.FileChannel;//FileChannel: là một kênh dữ liệu của NIO, hỗ trợ các thao tác file hiệu suất cao hơn so với stream cũ.

public class Ex08_nio {
    public static void main(String[] args) {
        RandomAccessFile copy, paste;
        FileChannel from, to;
        try {
            copy=new RandomAccessFile("src/session02_IO/zEx02.txt","rw");
            from= copy.getChannel();
            /*  mở file nguồn zEx02.txt với quyền đọc/ghi("rw")
                lấy FileChannel từ file đó-> để đọc dữ liệu
            */
            paste=new RandomAccessFile("src/session02_IO/zEx08.txt","rw");
            to=paste.getChannel();
            /*  mở(hoặc tạo mới) file đích (zEx08.txt)
                lấy channel để ghi dữ liệu vào
            */
            long cnt = from.size();//from.size(): lấy kích thước file nguồn(số byte) 
            to.transferFrom(from, 0, cnt);
            /*transferFrom(): là phương thức tối ưu để sao chép nội dung giữa các file
                từ from sang to, bắt đầu từ vị trí 0, sao chép cnt byte*/
            
            System.out.println("Copy successfully!");
            
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
/*  Thứ tự hoạt động
1. Mở file zEx02.txt → lấy channel.
2. Mở (hoặc tạo) file zEx08.txt → lấy channel.
3. Dùng to.transferFrom(from, 0, cnt) để sao chép nội dung nhanh chóng.
4. In "copy successfully!" nếu không lỗi.
    Ưu điểm của NIO so với FileChannel
- nhanh: giao tiếp dữ liệu cấp thấp với hệ điều hành
- dễ dùng: transferFrom() là 1 dòng thay thế toàn bộ vòng lặp read() và write()
- k cần buffer: k cần tự tạo mảng byte để copy từng phần dữ liệu
*/
