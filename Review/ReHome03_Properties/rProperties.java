
package rProperties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class rProperties {
    public static void main(String[] args) throws IOException{
        FileReader reader=new FileReader("src/rProperties/zProperties.properties");
        Properties prop=new Properties();
        prop.load(reader);
        
        System.out.println(prop.getProperty("User"));
        System.out.println(prop.getProperty("Password"));
    }
}
