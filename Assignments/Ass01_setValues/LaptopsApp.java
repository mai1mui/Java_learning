package assign_laptops_setValues;

public class LaptopsApp {

    public void menu() {
        var laptopstest = new LaptopsTest();
        laptopstest.addNew();
        laptopstest.display();
        laptopstest.search();
    }

    public static void main(String[] args) {
        new LaptopsApp().menu();
    }
}
