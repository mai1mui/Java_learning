package session05_exeption;

public class Ex10_quanly {

    //1.DoiTuong class
    static class DoiTuong {

        //1.1.properties
        String code, name;

        //1.2.parameterized constructor
        public DoiTuong(String code, String name) {
            this.code = code;
            this.name = name;

        }

        //1.3.overide toString()
        public String toString() {
            return String.format("Code: %s\tName: %s", code, name);
        }
    }

    //2. main class 
    public static void main(String[] args) {
        //2.1.initial data
        int item = 0;
        DoiTuong[] doituong = {
            new DoiTuong("1", "A"),
            new DoiTuong("2", "B"),
            new DoiTuong("3", "C")
        };
        //2.2.remove doituong
        String delCode = "2";//giả sử user nhập code muốn xóa là 2
        int del = 0;
        DoiTuong[] delDT = new DoiTuong[doituong.length];
        for (int i = 0; i < doituong.length; i++) {
            if (doituong[i].code.equals(delCode)) {
                item++;
            } else {
                delDT[del] = doituong[i];
                del++;
            }
        }
        //2.3.display
        for (int i = 0; i < doituong.length - item; i++) {
            System.out.println(delDT[i]);
        }
    }
}
