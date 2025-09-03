package session04_inheritance;
public class Ex02_static_method {
  void testNonstatic(){
      String name=new Object(){}.getClass().getEnclosingMethod().getName();
      System.out.println("Method name: " + name);
      
  }
  static void testStatic(){
      String name=new Object(){}.getClass().getEnclosingMethod().getName();
      System.out.println("Static Method name: "+ name);
  }
    public static void main(String[] args) {
        new Ex02_static_method().testNonstatic();
        testStatic();
    }
}
