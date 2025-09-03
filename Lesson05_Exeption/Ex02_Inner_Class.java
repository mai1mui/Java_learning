
package session05_exeption;
/*class bên trong 1 class khác*/
//1.Outer class
class Outer{
    //1.1.Properties
    static      int staticVal=10;
    public      int publicVal=20;
    private     int privateVal=30;
    protected   int protectedVal=50;
                int defaultVal=50;
    //1.2.inner class
    class Inner{
        void display(){
        System.out.println("Static: "+staticVal);
        System.out.println("public: "+publicVal);
        System.out.println("private: "+privateVal);
        System.out.println("protected: "+protectedVal);
        System.out.println("default: "+defaultVal);
        
    }
    }
}
//2.Main class
public class Ex02_Inner_Class {
    public static void main(String[] args) {
        var inner=new Outer().new Inner();
        inner.display();
    }
}
