
package tutorial03_parameterized_constructor;
public class ThucThi {
    public void menu(){
       var quanly=new QuanLy();
       quanly.addNew();
       quanly.display();
    }
    public static void main(String[] args) {
        new ThucThi().menu();
    }
 
}
