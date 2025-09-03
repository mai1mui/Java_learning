
package session05_theEnd;
import java.util.Stack;
public class Ex06_Stack {

    public static void main(String[] args) {
        Stack even = new Stack();
        Stack odd = new Stack();

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                even.push(i);
            } else {
                odd.push(i);
            }
        }

        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd);
        even.push(10);
        even.push(12);
        System.out.println("Display even again: " + even);
    }
}
