
package tutorial03_parameterized_constructor;
public class DoiTuong {
    //1.properties
    public String code, name;
    
    //2.type3: parameterized constructor
    public DoiTuong(String code, String name){
        this.code=code;
        this.name=name;
    }
    //3.override toString()
    @Override
    public String toString(){
        return String.format("+Code: %s\n+Name: %s", code, name);
    }
    }

