
package session02;
public class Ex03_Enum {
    //1.constant
    String hang;
    final String hang2;
    public Ex03_Enum(){
        hang="nga";
        hang2="mai";
        //hang2="dao"; hang da duoc gan gia tri "mai", nen khong the gan lai gia tri
    }
    // 2. Enum
    enum Day { Mon, Tue, Wed, Thu, Fri, Sat, Sun }
    void translate(Day day) {
        switch (day) {
            case Mon:
                System.out.println("Thu Hai");
                break;
            case Tue:
                System.out.println("Thu Ba");
                break;
            case Wed:
                System.out.println("Thu Tu");
                break;
            case Thu:
                System.out.println("Thu Nam");
                break;
            case Fri:
                System.out.println("Thu Sau");
                break;
            case Sat:
                System.out.println("Thu Bay");
                break;
            case Sun:
                System.out.println("Chu Nhat");
                break;
            default:
                System.out.println("Error");
        }
    }

    //3.Main method
    public static void main(String[] args) {
        var test =new Ex03_Enum();
        //1.test with constant
            //test.hang2="truc";-error
            System.out.println("Final variable hang: "+test.hang);
        //2.test with Enum
        for (Day day: Day.values()){
            test.translate(day);
        }
    }
}
