
import java.time.LocalDate;
import java.util.Date;

public class SalaryHistory extends Worker implements Comparable<SalaryHistory> {

    String status;
    String date;

    public SalaryHistory() {
    }

    public SalaryHistory(String code, String name, int age, double salary, String status, String date, String location) {
        super(code, name, age, salary, location);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(SalaryHistory o) {
        return this.getCode().compareTo(o.getCode());
    }

}
