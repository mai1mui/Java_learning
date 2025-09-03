package session03_OOP;

public class Ex02_PhongGV {

    public String water_public = "sapuwa";
    private String scanner_private = "sony scanner";
    protected String printer_protected = "lg oled";
    //default access-modifier (specifier)
    String tv = "samsung oled";

    public Ex02_PhongGV() {
        System.out.println(this.getClass().getName());

    }
}
