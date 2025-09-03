
package r03_JP2_Rucksacks;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {
    //1.properties
    ArrayList<Rucksacks>list=new ArrayList<>();
    
    //2.addRucksack()method
    public Rucksacks addRucksack(){
        Rucksacks rucksack=new Rucksacks();
        rucksack.acceptRucksack();
        list.add(rucksack);
        return rucksack;
        
    }
    //nếu dùng void, thì không cần return
//    public void addRucksack(){
//        Rucksacks rucksack=new Rucksacks();
//        rucksack.acceptRucksack();
//        list.add(rucksack);
//        
//    }
    
    //3.getRucksackList()method
    public void getRucksackList(){
        if(list.isEmpty()){
            System.out.println("Nothing to display!");
        }else{
            System.out.println("Rucksacks List");
            for(Rucksacks rs:list){
                System.out.println(rs);
                System.out.println("----------");
            }
        }
    }
    //4.deleteRucksack()method
    public void deleteRucksack(){
        Scanner sc=new Scanner(System.in);
        if(list.isEmpty()){
            System.out.println("Nothing to delete!");
            return;
        }else{
            System.out.println("Enter ID:");
            int delID=Integer.parseInt(sc.nextLine());
            
            //removeIf(Predicate) sẽ xóa tất cả ID thỏa điều kiện: rs.RucksackID==delID
            boolean removed=list.removeIf(rs->rs.RucksackID==delID);
            
            if(removed){
                System.out.println("Deleted successfully.");
            }else{
                System.out.println("ID "+delID+" not found!");
            }
        }
        
    }
    //5.menu()method
    public void menu(){
        String choice;
        Scanner sc=new Scanner(System.in);
        
        do{
            System.out.println("---MANAGEMENT RUCKSACKS---");
            System.out.println("1.Create a new rucksack");
            System.out.println("2.Publishthe entire list");
            System.out.println("3.Search and delete the rucksack");
            System.out.println("4.Exit");
            
            System.out.println("Enter your choice(1|2|3|4): ");
            choice=sc.nextLine();
            
            switch(choice){
                case"1":
                    addRucksack();
                    break;
                case"2":
                    getRucksackList();
                    break;
                case"3":
                    deleteRucksack();
                    break;
                case"4":
                    System.out.println("Exit programming...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong!");
                    break;
            }
            //Continue?
            System.out.println("Continue(Y/N)?");
            String option=sc.nextLine();
            if(!option.equalsIgnoreCase("Y")){
                System.out.println("Exit programming...");
                System.exit(0);
            }
        }
        while(true);
    }
    //6.main class
    public static void main(String[] args) {
        new StoreApp().menu();
    }
}
