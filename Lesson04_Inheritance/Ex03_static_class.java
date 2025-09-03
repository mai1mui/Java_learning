
package session04_inheritance;
/*1 static class chỉ được khai báo bên trong 1 class khác*/
//1.Outer Class
class Outer{
//1.1.Properties
    static      int staticVal=10;
    public      int publicVal=20;
    private     int privateVal=30;
    protected   int protectedVal=50;
                int defaultVal=50;
//1.2.Static
static class nestedClass{
    void display(){
        System.out.println("Static: "+staticVal);//ngoài static , còn lại lỗi
        //error: System.out.println("public: "+publicVal);
        //error: System.out.println("private: "+privateVal);
        //error: System.out.println("protected: "+protectedVal);
        //error: System.out.println("default: "+defaultVal);
        
    }
}
}                                                                                                                                                                                                                                                                                                                                                                                                                               
//2.Main Class
public class Ex03_static_class {
    public static void main(String[] args) {
        new Outer.nestedClass().display();
    }
}
