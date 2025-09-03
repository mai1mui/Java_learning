package session03_OOP;

import session03_OOP_ex02_vanphong.phongctsv;
import session03_OOP_ex02_vanphong.phonghop;

public class Ex02_PhongHoc extends phongctsv {

    public String water = "";
    private String laptop = "msi";
    protected String banghe = "go";
    //default access-modifier (specifier)
    String tv = "no tivi";

    //1.truy xuất cùng lớp
    void sameclass() {
        System.out.println("+Public:" + this.water);
        System.out.println("+Private:" + this.laptop);
        System.out.println("+Protected:" + this.banghe);
        System.out.println("+Default:" + this.tv);
    }

    //2.truy xuất khác lớp
    void samePackage() {
        Ex02_PhongGV gv = new Ex02_PhongGV();
        System.out.println("+Public:" + gv.water_public);
        //System.out.println("+Private:" +gv.scanner_private);//error:scanner_private has private access
        System.out.println("+Protected:" + gv.printer_protected);
        System.out.println("+Default:" + gv.tv);
    }

    //3.truy xuất khác gói
    void outsidePackage() {
        phonghop ph = new phonghop();
        System.out.println("+Public:" + ph.water_public);
        //System.out.println("+Private:" +ph.scanner_private);//error:scanner_private has private access
        //System.out.println("+Protected:" +ph.TV_protected);//error
        //System.out.println("+Default:" +ph.tv);//error

        //read from super class, base class
        System.out.println(sotaysv);
    }

    //4.display
    public static void main(String[] args) {
        new Ex02_PhongHoc().sameclass();
        new Ex02_PhongHoc().samePackage();
        new Ex02_PhongHoc().outsidePackage();
    }
}
