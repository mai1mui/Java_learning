package session05_theEnd;

import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;
//1.class book

class Book {

    String code, title;
    Scanner sc = new Scanner(System.in);

    public Book() {
        System.out.println("enter code: ");
        code = sc.nextLine();
        System.out.println("enter title: ");
        title = sc.nextLine();
    }

    @Override
    public String toString() {
        return code + " - " + title;
    }
}
//2.main class

public class Ex04_Enumeration {

    Vector<Book> list = new Vector<>();

    void addNew(Book book) {
        list.add(book);
    }

    void display() {
        Enumeration enums = list.elements();
        while (enums.hasMoreElements()) {
            System.out.println(enums.nextElement());
        }
    }

    public static void main(String[] args) {
        var ex04 = new Ex04_Enumeration();
        for (int i = 1; i < 3; i++) {
            System.out.println("Book" + i);
            ex04.addNew(new Book());
        }
        System.out.println("All book information: ");
        ex04.display();
    }
}
