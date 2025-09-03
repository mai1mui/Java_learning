package session05_exeption;
/*class nằm trong 1 phương thức*/
//1.Outside class
class Outside {
    //1.1.Properties
    static int staticVal = 10;
    public int publicVal = 20;
    private int privateVal = 30;
    protected int protectedVal = 50;
    int defaultVal = 50;
    //1.2.local class is inside a method
    void display() {
        class Inside {
            String s = "here is local class";
            void show() {
                System.out.println("Static: " + staticVal);
                System.out.println("public: " + publicVal);
                System.out.println("private: " + privateVal);
                System.out.println("protected: " + protectedVal);
                System.out.println("default: " + defaultVal);
            }//end show() method
        }//end inside class
        var inside = new Inside();
        System.out.println(inside.s);
        inside.show();
    }
}//end display() method
//1.2.main class
public class Ex03_local_class {
    public static void main(String[] args) {
        new Outside().display();
    }
}
