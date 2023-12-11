package advance.java.imran.CMethodReference.ATypesReferences.b.instance;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class PersonProcessor {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Imran", 12, "imranhossain@gmil.com"),
                new Person("Hossain", 13, "hossain@gmil.com")
        );

        forEach(people, person -> person.sendEmail());
    }
    public static void forEach(List<Person> people,
                               Consumer<Person> func) {
        for (Person person : people) {
            func.accept(person);
        }
    }
}
