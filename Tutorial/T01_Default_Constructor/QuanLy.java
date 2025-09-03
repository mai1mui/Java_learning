
package tutorial01_default_constructor;
public class QuanLy {
    DoiTuong doituong;
    public void addNew(){
        doituong=new DoiTuong();
        
    }
    public void display (){
        System.out.println(doituong.toString());
        //cách khác:
        System.out.println(doituong);
    }
}
