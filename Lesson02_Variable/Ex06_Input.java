
package session02;

import java.util.Scanner;

public class Ex06_Input {
    int id;
    String name;
    Scanner sc=new Scanner(System.in);
    //truc tiep
    void direct(){
        System.out.println("Vui long nhap ID: ");
        id=sc.nextInt();
        sc.nextLine();//clear buffer
        System.out.println("Vui long nhap ten: ");
        name=sc.nextLine();
        /*----------*/
        String s=String.format("ID: %d - Name: %s", id, name);
        System.out.println(s);
    }
    //gian tiep
    void inDirect(){
        System.out.println("Vui long nhap ID: ");
        id=Integer.parseInt(sc.nextLine());
        System.out.println("Vui long nhap ten: ");
        name=sc.nextLine();
        /*----------*/
        String s=String.format("ID: %d - Name: %s", id, name);
        System.out.println(s);
    }
    //display
    public static void main(String[] args) {
        new Ex06_Input().direct();
        new Ex06_Input().inDirect();
    }
    
}
