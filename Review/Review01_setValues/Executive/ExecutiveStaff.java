/*Yêu cầu: tạo lớp ExecutiveStaff kế thừa từ Staff gồm:
- 2 biến nguyên salary, bonus
-  phương thức setValues():
    + nhập từ bàn phím : id, name, salary, bonus
    + dùng try-catch bắt lỗi: 
        . salary: từ 500-1000
        . bonus: từ 0-100
 */
package Executive;
//ExecutiveStaff kế thừa từ Staff
import java.util.Scanner;
public class ExecutiveStaff extends Staff {

    //1.properties(thuộc tính)
    public int salary, bonus;
    Scanner sc=new Scanner(System.in);
    //2.gọi setValues() từ lớp Staff để gán id, name và setValuesSalaryBonus() để gán giá trị salary, bonus
    public void setValues(){
        //2.1.id
        do {
            try {
                System.out.println("Enter ID: ");
                id = sc.nextLine();
                if (id.isBlank()) {
                    throw new Exception("ID is required!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //2.2.name
        do {
            try {
                System.out.println("Enter Name: ");
                name = sc.nextLine();
                if (name.isBlank()) {
                    throw new Exception("Name is required!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }
    // Gán salary và bonus, có kiểm tra bằng try-catch
    public void setValuesSalaryBonus() {
        //2.3.salary
        do {
            try {
                System.out.println("Enter Salary(500-1000): ");
                salary = Integer.parseInt(sc.nextLine());
                if (salary < 500 || salary > 1000) {
                    throw new Exception("Salary must be between 500 and 1000!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        //2.4.bonus
        do {
            try {
                System.out.println("Enter Bonus(0-100): ");
                bonus = Integer.parseInt(sc.nextLine());
                if (bonus < 0 || bonus > 100) {
                    throw new Exception("Bonus must be between 0 and 100!");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }
    //3. tạo đối tượng và set giá trị
        ExecutiveStaff staff = new ExecutiveStaff();
        staff.setValues(id, name, salary, bonus);
        es[nextStaff++] = staff;
    //4.override toString()
    @Override
    public String toString(){
        return String.format("+Salary: %s\n+Bonus:%s",salary, bonus);
    }
}
