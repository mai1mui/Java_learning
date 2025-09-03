package tutorial05_Array;

import java.util.Scanner;

public class Quanly {
    final int max;
    int next = 0;
    Doituong[] doituong;
    Scanner sc=new Scanner(System.in);
    //2. set values for all fields by default contructor
    public Quanly(){
        max = 2; // nhap max neu de yeu cau
        next = 0;
        doituong = new Doituong[max];
    } 
    public void addNew(){
      doituong[next] = new Doituong();
      //1.khai bao bien
      String code,name;
      //2.nhap gia tri cho bien
      System.out.println("enter code: ");
      code=sc.nextLine();
      System.out.println("enter name: ");
      name=sc.nextLine();
      //3.khoi tao doi tuong
      doituong[next].satValues(code,name);
      
    }
    
    public void display(){
        for(int i = 0; i < next; i++){
            System.out.println(doituong[i]);
        }
    }
}
