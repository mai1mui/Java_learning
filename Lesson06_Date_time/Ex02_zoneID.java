
package session06_date_time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Ex02_zoneID {
    void listZoneID(){
        var list = new ArrayList(ZoneId.getAvailableZoneIds());
        Collections.sort(list);
        
        ZoneId zoneid=ZoneId.systemDefault();
        LocalDateTime date= LocalDateTime.now();
        System.out.println("Vietnam ZoneID: "+zoneid);
        
        System.out.println("All id zoneID: ");
        
        for(var element: list){
            zoneid= ZoneId.of((String)element);
            ZonedDateTime zone = date.atZone(zoneid);
            ZoneOffset offset=zone.getOffset();
            
            String out =String.format("%30s\t[%s]",zoneid,offset);
            System.out.println(out);
        }
       
    }
    void zoneIDSaiGon(){
        ZoneId zoneid= ZoneId.of("Asia/Saigon");
        
        LocalDateTime today=LocalDateTime.now();
        System.out.println("Vietnam ZoneID (new): "+zoneid);
        System.out.println("+Current Year: "+Year.now());
        System.out.println("Timestamp: "+Instant.now());
        
        System.out.println("Zone Date time: "+ ZonedDateTime.of(today, zoneid));
        System.out.println("Local Date: "+LocalDate.now());
        System.out.println("Local Time: "+LocalTime.now());
        System.out.println("Local Date Time: "+today);
    }
    public static void main(String[] args) {
        new Ex02_zoneID().listZoneID();
        System.out.println("=========");
        new Ex02_zoneID().zoneIDSaiGon();
    }
}
