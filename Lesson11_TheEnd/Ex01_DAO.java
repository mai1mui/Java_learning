/*
Mô tả: DAO (Data Access Object )là một lớp hoặc interface dùng để thực hiện các thao tác truy xuất dữ liệu như:
    - Kết nối cơ sở dữ liệu.
    - Thêm, sửa, xóa, tìm kiếm dữ liệu (CRUD).
    - Đóng kết nối.
Mục đích	
    - Tách biệt logic truy xuất dữ liệu và nghiệp vụ : Business logic không cần biết chi tiết SQL hoặc DB.
    - Dễ bảo trì và thay đổi: Thay đổi DB (MySQL → PostgreSQL) chỉ cần sửa DAO.
    - Tái sử dụng: DAO có thể được tái sử dụng ở nhiều nơi (controller, service...).
    - Dễ kiểm thử: Có thể mock DAO để viết unit test cho business logic.

*/
package session05_theEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
+ DAO- là 1 mẫu thiết kế (design pattern) dùng để tách biệt logic truy xuất dữ liệu
ra khỏi logic nghiệp vụ (bussiness logic)
+ Before:
    Bussiness Layer -> Service Layer -> Database
+ DAO:
    Bussiness Lasyer -> Service Layer -> DAO -> Database
 */
//1.class DoiTuong
class DoiTuong{
    //khai báo biến code, name
    String code, name;
    //insert code-> constructor
    public DoiTuong(String code, String name) {
        this.code = code;
        this.name = name;
    }
    //insert code-> toString()
    @Override
    public String toString() {
        return code + " - " + name;
    }
    
}
//2.interface tên DoiTuongDAO
interface DoiTuongDAO{
    List<DoiTuong>list=new ArrayList<>();
    void insert(DoiTuong doituong);
}
//3.class DoiTuongDAOImpl
class DoiTuongDAOImpl implements DoiTuongDAO{
    List<DoiTuong>list;
    public DoiTuongDAOImpl(){
        list=new ArrayList<>();
    }
    public void insert(DoiTuong doituong){
        list.add(doituong);
        System.out.println("Insert successfully!");
    }
    public List<DoiTuong>select(){
        return list;
    }
}
//4.main class
public class Ex01_DAO {
    DoiTuongDAOImpl dao=new DoiTuongDAOImpl();
    Scanner sc= new Scanner(System.in);
    
    DoiTuong input(){
        String code,name;
        System.out.println("enter code: ");
        code=sc.nextLine();
        System.out.println("enter name: ");
        name=sc.nextLine();
        
        return new DoiTuong(code, name);
    }
    
    void addNew(){
        DoiTuong doituong = input();
        dao.insert(doituong);
    }
    void display(){
        for(DoiTuong doituong: dao.select()){
            System.out.println(doituong);
        }
    }
    void exit(){
        System.out.println("Program exit....");
        System.exit(0);
    }
    void menu(){
        String option;

        do {
            System.out.println("-------------------");
            System.out.println("\t1. Add new");
            System.out.println("\t2. Display");
            System.out.println("\t3. Exit");
            System.out.println("-------------------");
            System.out.print("Enter your choice: ");
            option = sc.nextLine();

            switch (option) {
                case "1" -> addNew();
                case "2" -> display();
                case "3" -> exit();
                default -> System.err.println("Wrong!");
            }

            // Continue?
            System.out.print("Continue (y/n)? ");
            String progress = sc.nextLine();
            if (!progress.equalsIgnoreCase("y")) {
                System.exit(0);
            }

        } while (true);
    }
    public static void main(String[] args) {
        new Ex01_DAO().menu();
    }
}
