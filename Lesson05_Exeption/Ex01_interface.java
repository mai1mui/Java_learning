package session05_exeption;

/*
 */
//1.interface
interface IOne {
    String one = "Implicit(ngầm định): tất cả fields luôn public, static, final";
    void display();
}
interface ITwo {
    String two = "Implicit(ngầm định): all method are abstract";
    void show();
}
interface IThree {
    //1.1.static method
    public static void StaticMethod() {
        System.out.println("This is static method");
    }

    //1.2.private static method
    private static void PrivateStaticMethod() {
        System.out.println("This is private static method");
    }

    //1.3.private method
    private static void PrivateMethod() {
        System.out.println("This is private method");
    }

    //1.4.default method
    default void DefaultMethod() {
        StaticMethod();
        PrivateStaticMethod();
        PrivateMethod();
    }
}
//2.main class

public class Ex01_interface implements IOne, ITwo, IThree {

    public Ex01_interface() {
        IThree.StaticMethod();
        //PrivateStaticMethod();
        //PrivateMethod();
        this.DefaultMethod();
    }

    @Override
    public void display() {
        System.out.println(one);
    }

    @Override
    public void show() {
        System.out.println(two);
    }

    public static void main(String[] args) {
        Ex01_interface obj = new Ex01_interface();
        obj.display();
        obj.show();
    }
}
