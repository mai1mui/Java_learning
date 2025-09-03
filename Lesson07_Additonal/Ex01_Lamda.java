package session07_Additonal;

/*(argument list) -> {body code}
 */
@FunctionalInterface
interface Calculator {

    int cal(int n, int m);
}

interface ShowMessage {

    void show(String s);

}

public class Ex01_Lamda {

    static int runMethod(int x, int y, Calculator calculator) {
        return calculator.cal(x, y);

    }

    public static void main(String[] args) {
        //1.declare fields
        ShowMessage first, second;
        Calculator add, sub, multi, div;
        //2.Lamda
        //2.1.Without Parentthesis
        first = message -> {
            System.out.println("First: " + message);
        };
        first.show("2.1.Withou                                                                   t Parentthesis");

        //2.2.With Parentthesis
        System.out.println("==================");
        second = message -> {
            System.out.println("Second: " + message);
        };
        second.show("2.2.With Parentthesis");

        //2.3.Without Data Type
        add = (m, n) -> m + n;
        System.out.println("10+20=" + runMethod(10, 20, add));

        //2.4.With Data Type
        sub = (int m, int n) -> m - n;
        System.out.println("30-20=" + runMethod(30, 20, sub));
        
        //2.5.Without return
        multi = (m,n) -> m * n;
        System.out.println("4*8=" + runMethod(4, 8, multi));
        
        //2.5.With return
        div = (m,n) ->{return m / n;};
        System.out.println("40/5=" + runMethod(40, 5, div));
    }
}
