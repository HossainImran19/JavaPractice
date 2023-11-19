package advance.java.imran.f.lamda.advantages;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(List.of(
                new Person("Imran"),
                new Person("Mizan"),
                new Person("mihad"),
                new Person("Imran")
        ));


        // here we used anonymous class to implement the compare method
        personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });



        // here se used lamda to sort the integer list
        List<Integer> integers = new ArrayList<>(List.of(10, -1, 20, 30, 50, 0, 20, 1000, 101, 1010));

        integers.sort((i1, i2) -> i1.compareTo(i2));


    }
}

class People {
    void doSometing() {
        System.out.println("from People class");
    }
}

class Person extends People {
    @Override
    void doSometing() {

        System.out.println("from Person class");
    }

    private String name;


    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
