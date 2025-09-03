package tutorial06_Error;
import java.util.Scanner;
/**
 *
 *Controller: add, delete, update
 */
public class Quanli {
    //khai báo biến max-số lượng đối tượng tối đa có thể quản lý
    final int max;
    //khai báo biến next- chỉ số vị trí phần tử hiện tại
    int next = 0;
    //khai báo mảng đối tượng
    Doituong[] doituong;
    Scanner sc = new Scanner(System.in);
    
    //2. set values for all fields by default contructor
    public Quanli(){
        //gọi hàm getValue()để nhập giá trị max
        max = getValue(); // nhap max neu de yeu cau
        next = 0;
        doituong = new Doituong[max];
    }
    
    private int getValue(){
        int n = 0;
        do {            
            System.err.println("this is maximum of elements: ");
            n = Integer.parseInt(sc.nextLine());
        } while (n < 1 || n > 10);
        return n;
    }
   
    public void addNew(){
      if (next >= max){
          System.err.println("they out of " + max);
      }else{
          doituong[next] = new Doituong();
        doituong[next].input();
        next++;
      }
    }
    
    public void display(){
        if(next == 0){
            System.err.println("nothing");
        }else{
            for(int i = 0; i < next; i++){
            System.out.println(doituong[i]);
            }
        }
    }
}
