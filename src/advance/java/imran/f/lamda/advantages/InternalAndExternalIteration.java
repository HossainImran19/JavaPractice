package advance.java.imran.f.lamda.advantages;

import java.util.Iterator;
import java.util.List;

class PersonIteration {
    private String name;
    private int age;
    private String emailAddress;

    public PersonIteration(String name, int age, String emailAddress) {
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

class PersonIterationProcessor {
    public void sendEmailForVote(List<PersonIteration> personIterationList) {
        for (PersonIteration person : personIterationList) {
            if (person.getAge() >= 18) {
                sendEmail(person);
            }
        }

        // This is an example of External iteration.
        // The loop is a single threaded. It can be converted in multithreaded.
        // There is also a bit of overhead that can be reduced.
        Iterator<PersonIteration> iter = personIterationList.iterator();
        while (iter.hasNext()) {
            PersonIteration person = iter.next();
            if (person.getAge() >= 18)
                sendEmail(person);
        }

        // This is an example of Internal Iteration.
        // Here List or Collection class itself determines
        // how its elements data can be accessed and used.
        // We can specifically say to the Collection whether the Data will be processed sequentially or parallel way.
        // For example if the above example has to be processed in a parallel way
        // then it should be written as below:
        personIterationList.parallelStream().forEach(person -> {
            if (person.getAge() >= 18)
                sendEmail(person);
        });
    }

    private void sendEmail(PersonIteration person) {
        System.out.println("Sending email to: " + person.getName());
    }


}
public class InternalAndExternalIteration {

}
