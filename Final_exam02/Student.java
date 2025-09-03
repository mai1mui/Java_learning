
package University;
public class Student {
    //1.properties
    public int stuID, year_of_birth;
    public String stuName, stdAddress;
    //2.Constructor có tham số
    public Student(int stuID, String stuName, String stdAddress, int year_of_birth) {
        this.stuID = stuID;
        this.stuName = stuName;
        this.stdAddress = stdAddress;
        this.year_of_birth = year_of_birth;
    }
    // 3. Getters
    public int getStuID() {
        return stuID;
    }

    public String getStuName() {
        return stuName;
    }
    public String getStuAddress() {
        return stdAddress;
    }

    public int getYearOfBirth() {
        return year_of_birth;
    }
    //4.toString()method
    @Override
    public String toString() {
        return "Student ID: " + stuID + "\nName: " + stuName + "\nAddress: " + stdAddress + "\nYear of Birth: " + year_of_birth;
    }
}
