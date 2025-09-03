package session03_OOP.Ex02_Office;

/**
 *
 * @author Harori
 */
public class MeetingRoom {

    public String water_public = "Lavie một phần tất yếu thiên nhiên";
    private String scanner_private = "Cannon 250CS";
    protected String printer_protected = "HP 123JFJ";
//  Default access modifier ( specifier )
    String tv = "OLED samsung 200";

    public MeetingRoom() {
        System.out.println(this.getClass().getName());
    }
}
