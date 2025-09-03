package session02;
public class Ex01_variable {
    //1.khoi tao
    void testInit() {
        //1.1.khoi tao kieu doi tuong
        String rollNo = new String("Student001");
        float usd = Float.valueOf(20F);//deprecated new Float (20F)
        //1.2.khoi tao kieu gan gia tri(literal inital)
        String name = "Le Van A";
        long rate = 25_000_000;
        //1.3.display
        String s = String.format("Student %s has rollNo number: %s", name, rollNo);
        String n = String.format("%.0f doi duoc %.0f", usd, usd * rate);
        System.out.println(s);
        System.out.println(n);
    }
    //2.kieu du lieu
    void testType() {
            //2.1.boxing
            int intVal = 10;
            Object intObj = intVal;
            /*----------*/
            float floatVal =15;
            Object floatObj=floatVal;
            /*----------*/
            boolean boolVal=true;
            Object boolObj=boolVal;
            //2.2.unBoxing
            int num = (int)intObj;
            //2.3.string
            String stringVal="Yo soy String (Tay Ban Nha)";
            //2.4.instanceOf(keyword de check)
            if(num instanceof Integer){
                System.out.println("+kieu bien num la interger");
            }
            //2.5.display
            System.out.println("+can kiem tra du lieu:");
            System.out.println("-kieu du lieu intVal:" + intObj.getClass().getSimpleName());
            System.out.println("-kieu du lieu intVal:" + floatObj.getClass().getSimpleName());
            System.out.println("-kieu du lieu intVal:" + boolObj.getClass().getSimpleName());
            System.out.println("-kieu du lieu intVal:" + stringVal.getClass().getSimpleName());
        }
    //3.phuong thuc main
    public static void main(String[] args) {
            var ex01 = new Ex01_variable();
            ex01.testInit();
            ex01.testType();

        }
}
