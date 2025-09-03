
package assignment_laptops_parametrized;
public class Laptops {
    //1.properties(thuộc tính)
    public String code, name;
    public int price;
    
    //2.type3: parameterized constructor
    public Laptops(String code, String name, int price){
        this.code=code;
        this.name=name;
        this.price=price;
    }
    //3.override toString()
    @Override
    public String toString(){
        return String.format("+Code: %s\n+Name: %s\n+Price: %s", code, name,price);
    }
}
