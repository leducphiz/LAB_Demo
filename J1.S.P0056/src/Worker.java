
public class Worker {
//    id, name,age, salary, work location

    String code, name, location;
    int age;
    double salary;

    public Worker() {
    }

    public Worker(String code, String name, int age, double salary, String location) {
        this.code = code;
        this.name = name;
        this.location = location;
        this.age = age;
        this.salary = salary;
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
    
    

}
