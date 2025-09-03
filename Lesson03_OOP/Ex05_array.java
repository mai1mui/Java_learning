package session03_OOP;

public class Ex05_array {

    public Ex05_array() {
        //1.khai báo trước, khởi tạo sau
        int[] num = new int[3];
        num[0] = 10;//literial
        num[1] = new Integer(100);//constructor-deprecated
        num[2] = Integer.valueOf(1000);
        //2.khai báo và khởi tạo
        int cArray[]={1,3,5};//viết theo môn C
        int[] jArray={2,4,6};//viết theo môn java
        
        //3.display
            //3.1.simple
            System.out.println("1.simple loop: ");
            for (int i = 0; i < num.length; i++) {
                System.out.println(num[i]);
            }
            System.out.println("-----------");
            System.out.println("2.simple loop: ");
            for (int i = 0; i < cArray.length; i++) {
                System.out.println(num[i]);
            }
            System.out.println("-----------");
            System.out.println("2.simple loop: ");
            for (int i = 0; i < jArray.length; i++) {
                System.out.println(num[i]);
            }
            //3.2.for-each
            System.out.println("1.for-each loop: ");
            for (int n : num) {
                System.out.println(n);
            }
            System.out.println("-----------");
            System.out.println("2.for-each loop: ");
            for (int c : cArray) {
                System.out.println(c);
            }
            System.out.println("-----------");
            System.out.println("2.for-each loop: ");
            for (int j : jArray) {
                System.out.println(j);
            }
    }

    public static void main(String[] args) {
        new Ex05_array();
    }
}
