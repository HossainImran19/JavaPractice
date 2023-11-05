package advance.java.imran.c.method.reference.a.types.references.c.constr;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public static void main(String[] args) {
        Function<String, Person> func1 = name -> new Person(name);
        BiFunction<String, Integer, Person> func2 = (name, age) -> new Person(name, age);

        // we can write these func1 and func2 like that....
        Function<String, Person> func3 = Person::new;
        BiFunction<String, Integer, Person> func4 = Person::new;
    }
}
