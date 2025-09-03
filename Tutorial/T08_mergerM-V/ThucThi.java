package tutorial08_merger1_2;
public class ThucThi {
    public void menu() {
        QuanLy quanly = new QuanLy();
        quanly.addNew();
        quanly.display();
    }

    public static void main(String[] args) {
        new ThucThi().menu();
    }
}
