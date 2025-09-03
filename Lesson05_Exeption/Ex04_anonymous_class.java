
package session05_exeption;
/**/
//1.interface
interface Polygan{
    //void trong class mặc nhiên là abstract
    void display();
}
//2.abstract class
abstract class Rectangle{
    abstract void show();
}
//3.anonymous class
class Anonymous{
    void search(){
        var rectangle = new Rectangle(){
            @Override
            void show(){
                System.out.println("Rectangle is inside the anonymous class");
            }
        };//end Rectangle()
        rectangle.show();
    }//end search()
    void addNew(){
        var polygan = new Polygan(){
            @Override
            public void display(){
                System.out.println("Polygon is inside the anonymous class");
            }
        };//end Polygon()
    }
}//end Anonymous
//4.main class
public class Ex04_anonymous_class {
    public static void main(String[] args) {
        var ex04=new Anonymous();
        ex04.addNew();
        ex04.search();
    }
}
