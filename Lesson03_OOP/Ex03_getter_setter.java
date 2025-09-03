package session03_OOP;
//1.class student

class Student {

    private int mark = 39;

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
//2.class Ex03_getter_setter 

public class Ex03_getter_setter {

    public static void main(String[] args) {
        var activity = new Student();
        System.out.println("Thi lần 1: " + activity.getMark());
        activity.setMark(90);
        System.out.println("Thi lần 2: " + activity.getMark());
    }
}
