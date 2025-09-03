package tutorial09_helper;

import java.util.Scanner;

/*yếu cầu: thừa kế từ lớp CHA
 */
public class DoiTuong extends CHA {

    //1.properties
    String code, name;
    int max, next;//thêm final để khai báo dạng hằng
    DoiTuong[] doituong;

    //2.constructor
    public DoiTuong() {
        max = 2;
        next = 0;
        doituong = new DoiTuong[max];
    }

    //3.Overide input() method
    public String input(String str) {
        Boolean isOK = true;
        String s = null;
        while (isOK) {
            isOK = false;
            System.out.println("enter "+str+": ");
            s = Helper.getString();
            if (!Helper.check(s)) {
                System.err.println(str + "is required!");
                isOK = true;
            }
        }
        return s;
    }

    //4.addnew() method
    public void addNew() {
        doituong[next] = new DoiTuong();
        doituong[next].code=input("code");
        doituong[next].name=input("name");
        next++;
    }
    //5.display() method
    void display(){
        for(int i=0; i<next;i++){
            System.out.println(doituong[i]);
        }
    }
    //6.Overide toString()
    public String toString(){
        return String.format("Code: %s\tName: %s", code,name);
    }
    //7.menu() method
    public void menu(){
     Scanner sc = new Scanner(System.in);
 
        String option; 
        System.out.println("-------------------");
        System.out.println("\t1. Add new");
        System.out.println("\t2. Display all");
        System.out.println("\t3. Quit");
        System.out.println("-------------------");

        do{
            System.out.println("enter u option (add | show | exit)");
            option = sc.nextLine();
            option = option.toLowerCase();

            switch(option){
                case "1" -> addNew();
                case "2" -> display();
                case "3" -> System.out.println("exit");
                
                case "add" ->  addNew();
                case "display" ->  display();
                case "exit" -> {
                    System.out.println("exit");
                    System.exit(0);
                }            
               
                default -> System.err.println("wrong!");
            }
            //continue?
            System.out.print("Continue (Y/N)? ");
            String propress = sc.nextLine();
            if(!propress.equalsIgnoreCase("Y")){
                System.exit(0);
            }
            
        }while(!option.equalsIgnoreCase("exit"));
        
    }
    
    public static void main(String[] args) {
        new DoiTuong().menu();
    }
}
