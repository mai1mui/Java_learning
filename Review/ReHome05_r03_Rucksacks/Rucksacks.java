
package r03_JP2_Rucksacks;

import java.util.Scanner;

public class Rucksacks {
    //1.properties
    int RucksackID,Qty;
    float Price;
    String RucksackName;
    //2.void acceptRucksack()method
    public void acceptRucksack(){
        Scanner sc=new Scanner(System.in);
        
        //2.1.RucksackID
        do{
            try {
                System.out.println("Enter id:");
                String RucksackIDStr=sc.nextLine();
                if(RucksackIDStr.isBlank()){
                    throw new Exception("ID is required!");
                }
                RucksackID=Integer.parseInt(RucksackIDStr);
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        while(true);
        //2.2.RucksackName
        do{
            try {
                System.out.println("Enter name:");
                RucksackName=sc.nextLine();
                if(RucksackName.isBlank()){
                    throw new Exception("Name is required!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        while(true);
        //2.3.Price
        do{
            try {
                System.out.println("Enter price:");
                Price=Float.parseFloat(sc.nextLine());
                if(Price<=0){
                    throw new Exception("Price must be greater than 0!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        while(true);
        //2.4.Qty
        do{
            try {
                System.out.println("Enter quantity:");
                Qty=Integer.parseInt(sc.nextLine());
                if(Qty<=0){
                    throw new Exception("Quantity must be greater than 0!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        while(true);
    }
    //3.toString()
    @Override
    public String toString(){
        return String.format("ID: "+RucksackID+"\nName: "+RucksackName+"\nPrice: "+Price+"\nQuantity: "+Qty);
    }
}
