package advance.java.imran.IStream.introduction;

public class Person {
    String name;
    int age;
    double sallary;

    public Person(String name, int age, double sallary) {
        this.name = name;
        this.age = age;
        this.sallary = sallary;
    }

    public double getSallary() {
        return sallary;
    }

    public void setSallary(double sallary) {
        this.sallary = sallary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
