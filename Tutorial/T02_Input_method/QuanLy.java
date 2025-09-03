
package tutorial02_input_method;
public class QuanLy {
    DoiTuong doituong;
    public void addNew(){
        doituong=new DoiTuong();
        doituong.input();
    }
    public void display (){
        System.out.println(doituong);
    }
}
