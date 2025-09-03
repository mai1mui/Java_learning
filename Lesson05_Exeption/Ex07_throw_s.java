/*
method A (throws exception) => method B (try...catch)
 */
package session05_exeption;

import java.util.Scanner;

public class Ex07_throw_s {
    int n,m;
    Scanner sc=new Scanner(System.in);
    void caculate() throws Exception{
        System.out.println("enter first n: ");
        n=sc.nextInt();
        System.out.println("enter second n: ");
        m=sc.nextInt();
        
        if(m==0){
            throw new Exception("khong the chia cho zero!");
        }
        else{String out =String.format("%d/%d=%d", n,m,n/m);
            System.out.println(out);}
        
    }
    public static void main(String[] args) {
        try {
            new Ex07_throw_s().caculate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
