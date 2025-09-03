package r01_JP2_Triangle;

public class Triangle extends Shape {

    //1.properties
    int a, b, c;

    //2.parameterized constructor
    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    //3.override exportData()method

    @Override
    public void exportData() {
        System.out.println("Side a: " + a + "\nSide b: " + b + "\nSide c: " + c);
    }
}
