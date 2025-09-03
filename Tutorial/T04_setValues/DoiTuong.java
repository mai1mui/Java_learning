
package tutorial04_setValues;
public class DoiTuong {
    //1.properties
    public String code, name;
    
    //2.type4: setValues
    
    public void setValues (String code, String name){
        this.code=code;
        this.name=name;
    }
    //3.override toString()
    @Override
    public String toString(){
        return String.format("+code: %s\n + Name=%s", code, name);
    }
}
