package session02;

public class Ex05_Casting {

    public static void main(String[] args) {
        int a = 10;
        float b = 20;
        Object boxing = a;
        int unboxing = (int) boxing;
        /*----------*/
        String imlicit = String.format("Implicit: %d + %f=%f", a, b, a + b);
        String explicit = String.format("Implicit: %d + %f=%d", a, b, (int) (a + b));
        System.out.println(imlicit);
        System.out.println(explicit);
        System.out.println("Boxing: "+boxing);
        System.out.println("UnBoxing: " +unboxing);
    }

}
