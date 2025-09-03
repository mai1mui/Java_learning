/*- HashMap: 1 cấu trúc dữ liệu dùng để lưu trữ cặp dữ liệu key-value
ở đây:  key là String
        value là DoiTuong
- HashMap<String, DoiTuong> list = new HashMap();
đây là thuộc tính (biến thành viên) của class QuanLy
list: 1 đối tượng của HashMap dùng để lưu trữ nhiều đối tượng kiểu DoiTuong với key là String

*/
package tutorial02_hash_map;

import java.util.HashMap;


public class QuanLy {
    HashMap<String,DoiTuong> list=new HashMap();
    
    public void addNew(){
        DoiTuong doituong= new DoiTuong();
        //gọi phương thức input()
        doituong.input();
        list.put(doituong.getCode(),doituong);//Vì code là private trong class DoiTuong, bạn cần có getter (hàm getCode()) để lấy nó ra.
    }
    
    public void display(){
        System.out.println("1.TH1: Using get(Object key): ");
        for(var key:list.keySet()){
            System.out.println(list.get(key).output());
        }
        System.out.println("2.TH2: Using values: ");
        for(var doituong:list.values()){
            System.out.println(doituong.output());
        }
    }
}
