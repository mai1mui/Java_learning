
package session02;

public class Ex04_Static {
    int nonStaticVal =0;
    static int staticVal=0;
    public Ex04_Static(){
        nonStaticVal +=5;
        staticVal +=5;
        /*----------*/
        String s=String.format("Non_static: %d - Static: %d", nonStaticVal, staticVal);
        System.out.println(s);
    }
    public static void main(String[] args) {
        new Ex04_Static();
        new Ex04_Static();
        new Ex04_Static();
    }
}
