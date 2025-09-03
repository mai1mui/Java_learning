package University;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO {

    //1.properties
    //danh sách các đối tượng Student.
    ArrayList<Student> studentList = new ArrayList<>();
    public Scanner sc = new Scanner(System.in);
    public File file;
    
    //2.addStudent(Student newStudent) method
    //input()method
    public Student input() {
        int stuID, year_of_birth;
        String stuName, stdAddress;
        //stuID
        do {
            try {
                System.out.print("Enter stuID: ");
                String input = sc.nextLine();
                if (input.isBlank()) {
                    throw new Exception("Student ID is required!");
                }
                stuID = Integer.parseInt(input); // chuyển đổi sau khi kiểm tra
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //stuName
        do {
            try {
                System.out.print("Enter student name: ");
                stuName = sc.nextLine();
                if (stuName.isBlank()) {
                    throw new Exception("Student name is required!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //stdAddress
        do {
            try {
                System.out.print("Enter student address: ");
                stdAddress = sc.nextLine();
                if (stdAddress.isBlank()) {
                    throw new Exception("Student address is required!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //year_of_birth
        do {
            try {
                System.out.print("Enter year_of_birth: ");
                year_of_birth = Integer.parseInt(sc.nextLine());
                if (year_of_birth < 1960 || year_of_birth > 2005) {
                    throw new Exception("Year_of_birth is between 1960 and 2005!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (true);
        return new Student(stuID, stuName, stdAddress, year_of_birth);
    }

    //addStudent(Student newStudent) method
    public void addStudent(Student newStudent) throws IOException {
        studentList.add(newStudent);
        System.out.println("Student added successfully!");
    }

    //3.findAll()method
    public void findAll() {
        if (studentList.isEmpty()) {
            System.out.println("Nothing to display!");
            return;
        }
        System.out.println("---- Student List ----");
        for (Student s : studentList) {
            System.out.println(s);
            System.out.println("------------------------");
        }
    }

    //4.writeFile()method
    public void writeFile() throws IOException {
        file = new File("src/University/student.txt");

        if (studentList.isEmpty()) {
            System.out.println("Nothing to write.");
            return;
        }
        
        // Sử dụng try-with-resources để tự động đóng file
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);) {
            for (Student s : studentList) {
                bw.write(s.toString());
                bw.newLine();
                bw.write("------------------------");
                bw.newLine();
            }
            System.out.println("Written to file successfully.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
