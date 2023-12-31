package advance.java.imran.IStream.introduction;

public class Person {
    enum Gender {
        MALE, FEMALE
    }
    private String name;
    private int age;
    private Gender gender;
    private Double sallary;

    public Person(String name, int age, double sallary) {
        this.name = name;
        this.age = age;
        this.sallary = sallary;
    }

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Double getSallary() {
        return sallary;
    }

    public void setSallary(Double sallary) {
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
