
package assignment_laptops_input_method;
public class LaptopsApp {
    public void menu(){
        //tạo đối tượng lớp xử lý
       var laptopsTest=new LaptopsTest();
       //gọi các phương thức
       laptopsTest.addNew();
       laptopsTest.display();
       laptopsTest.search();
    }
    public static void main(String[] args) {
        new LaptopsApp().menu();
    }
}
