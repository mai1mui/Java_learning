
package session04_inheritance;
public class Ex01_static_fields {
    static String design ="Design list: ";
    String office ="Office list: ";
    
    public Ex01_static_fields(String design, String office){
        this.design += "||" +design;
        this.office += "||" +office;
        System.out.println("-----------");
    }
    public String toString(){
        return String.format("+%s\n+%s ",design,office);
        
    }
    public static void main(String[] args) {
        var first = new Ex01_static_fields("Photoshop","Word");
        System.out.println(first);
        var second = new Ex01_static_fields("illustrator","Excel");
        System.out.println(second);
        var third = new Ex01_static_fields("CorelIDRAM","Powerponit");
        System.out.println(third);
    }
}
