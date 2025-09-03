/*yêu cầu:
 tạo 1 lớp trừu tượng (abstract) tên là Staff trong package Executive gồm:
- 2 biến chuỗi(String) tên là id và name
- 1 phương thức tên là setValues()
*/
package Executive;
public abstract class Staff {
    //1.Properties(thuộc tính)
    public String id, name;
    public int salary,bonus;
    //2.setValues() method 
    // setValues để truyền dữ liệu
    public void setValues(String id, String name, int salary, int bonus) {
        super.setValues(id, name);
        this.salary = salary;
        this.bonus = bonus;
    }
    //3.override toString()
    @Override
    public String toString(){
        return String.format("+ID: %s\n+Name:%s",id, name);
    }
}
