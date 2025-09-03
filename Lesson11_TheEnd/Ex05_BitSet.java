package session05_theEnd;

import java.util.BitSet;

public class Ex05_BitSet {

    public static void main(String[] args) {
        BitSet even = new BitSet();
        BitSet odd = new BitSet();

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                even.set(i);
            } else {
                odd.set(i);
            }
        }

        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd);
        even.set(10);
        even.set(12);
        System.out.println("Display even again: " + even);
    }
}
