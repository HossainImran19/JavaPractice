package advance.java.imran.CMethodReference.ATypesReferences.b.instance;

public class Person {
    private String name;
    private int age;
    private String mail;

    public Person(String name, int age, String mail) {
        this.name = name;
        this.age = age;
        this.mail = mail;
    }

    public void sendEmail() {
        System.out.println("sending email to : " + mail);
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
