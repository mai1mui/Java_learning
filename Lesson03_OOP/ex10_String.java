package session03_OOP;

/**
 *
 * @author phuch
 */
public class ex10_String {
    public static void main(String[] args) {
        char[] ch = {'a', 'b', 'c'};
    
        for(int i = 0; i< ch.length; i++){
            String s = String.format("ch[%d] = %c", i, ch[i]);
            System.out.println(s);
        }
        
        String chArr = new String(ch);
        System.out.println("tao chuoi tu mang ki tu " + chArr);
    }
}
