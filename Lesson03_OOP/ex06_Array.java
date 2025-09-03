package session03_OOP;

public class ex06_Array {
     public static void main(String[] args) {
        int[][] num = {
            {1,2,3,4},
            {4,5,6,8}
        };
         System.out.println("list of number: ");
         for(int row = 0; row < num.length; row++){
             for(int col = 0; col < num[row].length; col++){
                 System.out.println("" + num[row][col]);
             }
         }
         System.out.println("for each: ");
         for(int[] col:num){
             for(int element : col){
                 System.out.println("" + element);
             }
             System.out.println("");
         }
    }
}
