package assign_laptops_setValues;

public class Laptops {

    //1.properties
    public String code, name;
    public int price;

    //2.setValues
    public void setValues(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    //3.override toString()
    @Override
    public String toString() {
        return String.format("+Code: %s\n+Name: %s\n+Price: %d", code, name, price);
    }
}
