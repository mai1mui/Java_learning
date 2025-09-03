/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session05_theEnd;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author mai
 */
public class Ex02_Internalization {
    //1.Resources
    Locale viLoc, usLoc;
    ResourceBundle currBundle, viBd, usBd;
    //2.Initial Resources
    public Ex02_Internalization(){
        viLoc = Locale.of("vi","VN");//new Locale("vi","VN")
        usLoc= Locale.of("en","USA");
        
        viBd =ResourceBundle.getBundle("session05_theEnd/zEx02_vi_VN",viLoc);
        usBd =ResourceBundle.getBundle("session05_theEnd/zEx02_en_USA",usLoc);
    }
    //3.display
    void display(){
        System.out.println("1.Greetings: "+currBundle.getString("greetings"));
        System.out.println("2.Farewell: "+currBundle.getString("farewell"));
        System.out.println("3.Inquiry: "+currBundle.getString("inquiry"));
    }
    
    //4.menu()
    void menu(){
        //chạy lần lượt từng dòng
//        currBundle = viBd;
        currBundle = usBd;
        display();
    }
    public static void main(String[] args) {
        new Ex02_Internalization().menu();
    }
}
