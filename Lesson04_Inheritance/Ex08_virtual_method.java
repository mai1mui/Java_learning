
package session04_inheritance;

/*virtual_method: phương thức ảo
-ưu tiên dùng field trong lớp con thay vì lớp cha
-virtual_method: implicit(ngầm hiểu) trong java

 */
//1.abstract class
//baseclass: lớp cha
abstract class BaseClass{
    //1.1.field
    int money=2000;
    //1.2.abstract method
    abstract void study();
    //1.3.virtual method
    void kinhdoanh(){
        money+=500;
        System.out.println("Total: "+money);
    }
}
//2.Main class
public class Ex08_virtual_method extends BaseClass{
    int money = 1000;
    //Viết lại phương thức study()
    @Override
    public void study(){
        System.out.println("Graduation!");
        //gọi lớp cha
        super.kinhdoanh();//gọi phương thức kinh doanh từ BaseClass
        this.kinhdoanh();//gọi phương thức kinh doanh từ Main class
    }
    
    //gọi phương thức kinh doanh
    @Override
    public void kinhdoanh(){
        System.out.println("Tiền riêng:"+money);
        System.out.println("Nothing!");
    }
    public static void main(String[] args) {
        new Ex08_virtual_method().study();
    }
}
