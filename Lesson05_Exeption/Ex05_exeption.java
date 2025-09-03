
package session05_exeption;
public class Ex05_exeption {
    int[] num={1,3,5};
    void simple(){
        System.out.println(num[2]);
        //error:System.out.println(num[3]); lỗi, do mảng có 3 phần tử 0-1-2, nếu cần in num[3] thì tận 4 phần tử 0-1-2-3, java.lang chỉ hỗ trợ 3 phần tử
    }
    void advanced(){
        //cách gõ try...catch: gõ trycatch-> tab
        try {
            System.out.println("the last"+num[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();//chỉ dùng cho dev, k dùng cho user
            //th1:
            System.err.println("1."+e.toString());
            //th2:
            System.out.println("2."+e.getMessage());
            //th3:
            System.out.println("3."+e.getCause());
            //th4:
            System.out.println("4.ngu như bòa!");
        }
    }
    public static void main(String[] args) {
        var ex05=new Ex05_exeption();
        ex05.simple();
        ex05.advanced();
    }
}
