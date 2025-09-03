package session04_StringBuilder;
import java.util.ArrayList;
public class Ex01_StringBuilder {
    String email = "lavana@abc.com";
    String phone = "0909 123 456";

    void showMessage() {
        ArrayList<String> mess = new ArrayList<>();
        mess.add("Your Information:");
        mess.add("-----------------");
        mess.add(String.format("Email: %s", email));
        mess.add(String.format("Phone: %s", phone));
        
        for (String line : mess) {
            System.out.println(line);
        }
    }

    void displayMessage() {
        StringBuilder mess = new StringBuilder();
        mess.append("Your Information:\n");
        mess.append("-----------------\n");
        mess.append(String.format("Email: %s\n", email));
        mess.append(String.format("Phone: %s\n", phone));
        
        System.out.println(mess.toString());
    }

    public static void main(String[] args) {
        Ex01_StringBuilder ex = new Ex01_StringBuilder();

        System.out.println("----- showMessage() output -----");
        ex.showMessage();

        System.out.println("\n----- displayMessage() output -----");
        ex.displayMessage();
    }
}
