
package session05_theEnd;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Ex07_Dictionary {
    public static void main(String[] args) {
        Dictionary<String,String>dict=new Hashtable<>();
        Scanner sc=new Scanner(System.in);
        
        dict.put("hello", "Bonjour");
        dict.put("one", "une");
        dict.put("two", "deux");
        dict.put("three", "trois");
        
        Hashtable trans= new Hashtable();
        trans.putAll((Map)dict);
        
        String search;
        do{
            System.out.println("Enter a word to translate: ");
            search=sc.nextLine();
            
            if(trans.containsKey(search)){
                String s=String.format("%s:%s",search,trans.get(search));
                System.out.println(s);
            }else{
                System.out.println("Nothing!");
            }
        }
        while(!search.equalsIgnoreCase("end"));
    }
}
