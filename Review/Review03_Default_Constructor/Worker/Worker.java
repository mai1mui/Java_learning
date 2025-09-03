/*Yêu cầu: tạo lớp Worker trong package tên academy chứa thông tin công nhân
Biến instance:
- ID(int): mã định danh công nhân
- name, address(string)
- year_of_birth(int): năm sinh
dùng đefault constructor khởi tạo biến instance giá trị mặc định: khi bạn không nhập bất kì giá trị nào, sẽ hiển thị giá trị mặc định
dùng parameter constructor khởi tạo biến tham số được truyền vào
 */
package academy;
public class Worker {
    //1.properties(thuộc tính)
   public int id;
   public String name,address;
   public int year_of_birth;
    //2.default constructor: giá trị mặc định
   public Worker(){
       //khởi tạo biến
       this.id=0;
       this.name="Unknown";
       this.address="N/A";
       this.year_of_birth=0;
   }
    //3.parameter constructor
   public Worker(int id, String name, String address, int year_of_birth){
       //khởi tạo biến:dùng this. để phân biệt biến instance với biến tham số
       this.id=id;
       this.name=name;
       this.address=address;
       this.year_of_birth=year_of_birth;
   }
}
