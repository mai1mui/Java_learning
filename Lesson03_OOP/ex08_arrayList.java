package session03_OOP;
import java.util.ArrayList;
public class ex08_arrayList {
    public ex08_arrayList(){
        //khai bao
        ArrayList num = new ArrayList();
        int sum = 0;

        //khoi tao 5 so
        for(int i = 0; i < 5; i++){
            num.add(i + 1);
        }

        //tinh tong va hien thi 
        for(int i = 0; i < num.size(); i++){
            sum = sum + (int)num.get(i);
        }
        System.out.println("tong 2 so la" +sum);
    }
    
    public static void main(String[] args) {
        new ex08_arrayList();
    }
    
}
