/*Mô tả:minh họa cách tạo và sử dụng generic method- tức là 1 phương thức có thể hoạt động với nhiều kiểu dữ liệu khác nhau
như integer, character, string, employee, ...mà k cần viết lại hàm cho từng kiểu

*/
package session01_utility;

public class Ex07_generic_method {
    //1.display()method
    static <T> void display(T[] values){
        /*  static <T>: xác định đây là 1 phương thức generic với 1 kiểu tham số T
            T[] values: mảng chứa các phần tử thuộc kiểu T(có thể là Integer[], Character[], String[],...
        */
        for(T value:values){
            System.out.println(value);
        }
    }
    //main() method
    public static void main(String[] args) {
        //tạo mảng integer
        Integer[]intVals={1,2,3,4};
        //tạo mảng character
        Character[] chVals={'A', 'B','C'};
        System.out.println("\nGeneric mehtod with Integer: ");
        display(intVals);
        System.out.println("\nGeneric mehtod with Character: ");
        display(chVals);
    }
}
