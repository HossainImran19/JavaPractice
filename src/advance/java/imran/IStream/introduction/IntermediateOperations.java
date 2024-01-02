package advance.java.imran.IStream.introduction;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        // ---------------- Intermediate Operations ---------------------

        //============================================
        // 1. filter()
        // here boxed() wraps each primitive int value into Integer object.
        Stream<Integer> numbers = IntStream.range(1, 50).boxed();
        Stream<Integer> evenNumbers = numbers.filter(val -> val % 2 == 0);
        evenNumbers.forEach(val -> System.out.print(val + " "));

        //============================================
        // 2. Stream<T> sorted(Comparator<? super T> comparator) method does not modify the source;
        // instead, it returns a new sorted sequence or stream.
        // Creating a list of Persons.
        List<Person> people = List.of(
                new Person("imran", 10, 233.00),
                new Person("rasel", 100, 234.00),
                new Person("rasel", 200, 234.00),
                new Person("rasel", 5, 777.00),
                new Person("mihad", 3, 88.00)
        );

        // Here we are sorting the persons based on their names.
        // If the names are equal, then we sort based on their ages.
        // If the ages are equal, then we sort based on their salary.
        List<Person> sortedPersonList
                = people.stream()
                .sorted(Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge)
                        .thenComparing(Person::getSallary)
                ).toList();

        // In the following snippet we are sorting Persons ascending order based on their names.
        // If names are equal then descending order based on their ages.
        people.stream()
                .sorted(Comparator.comparing(Person::getName)
                        .thenComparing(Comparator.comparing(Person::getAge)
                                .reversed())
                )
                .forEach(val -> System.out.println(val.getName() + " " + val.getAge()));

        //============================================
        // 3. map(Function<? super T, ? extends R> mapper)
        // is used for transforming each element of the stream one type to another.
        Stream<Person> personStream
                = Stream.of(
                new Person("Imran", 16, Person.Gender.MALE),
                new Person("Mizan", 32, Person.Gender.MALE),
                new Person("Mihad", 3, Person.Gender.MALE)
        );

        // Here by using map() method we are creating a nameStream form the personStream
        // to store the names of each person.
        personStream.filter(IntermediateOperations::isOlderThan15)
                .map(Person::getName)
                .forEach(val -> System.out.println(val + " "));

        //============================================
        // 4. flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
        // Creating developer team where each developer knows one or multiple languages.
        List<Developer> developers = new ArrayList<>();
        //developer 1.
        Developer imran = new Developer("Imran");
        imran.add("C++");
        imran.add("Java");
        imran.add("HTML");
        //developer 2.
        Developer mizan = new Developer("Mizan");
        mizan.add("Python");
        mizan.add("JavaScript");
        mizan.add("HTML");

        developers.add(imran);
        developers.add(mizan);

        // Creating a stream of Set<String> using map() to store the sets of languages known by the developers.
        Stream<Set<String>> languages = developers.stream()
                .map(Developer::getLanguages);
        // Transforming a Set<String> stream into a List<Set<String>>.
        List<Set<String>> langList = languages.toList();
        for (var language : langList)
            System.out.println(language);

        // What we actually need is a combined list of strings(languages) where all the strings are together.
        // we can do this by using flatMap();
        developers.stream()
                .map(Developer::getLanguages)
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        //============================================
        // 5. Stream<T> distinct()
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 3, 3, 4, 5, 5, 5, 6, 9);
        numbers1.stream().distinct().forEach(System.out::println);

        //============================================
        // 6. Stream<T> peek(Consumer<? super T> action) used for debugging
        List<Person> personList
                = people
                .stream()
                .peek(person -> System.out.println("before filter: " + person.getAge() + " : " + person.getName()))
                .filter(IntermediateOperations::isOlderThan15)
                .peek(person -> System.out.println("after filter: " + person.getAge() + " : " + person.getName()))
                .sorted(Comparator.comparing(Person::getName))
                .toList();

        //============================================
        // 7. Use Stream<T> limit(long maxSize) to restrict the output or production of a limited set of elements.
        IntStream.range(0, 1000)
                .filter(IntermediateOperations::isPrime)
                .limit(10)
                .forEach(System.out::println);

        //============================================
        // 8. Use Stream<T> skip(long n) to process the stream
        // while excluding the specified number of elements passed as an argument.
        IntStream.range(0, 20)
                .peek(value -> System.out.println("before skip: " + value))
                .skip(5)
                .peek(value -> System.out.println("after skip: " + value))
                .filter(IntermediateOperations::isPrime)
                .forEach(System.out::println);

        //============================================
        // 9. Use Stream<T> takeWhile(Predicate<? super T> predicate) to halt the processing when
        // the condition specified by the predicate evaluates to false.
        Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
                .peek(val -> System.out.println("before: " + val))
                .takeWhile(num -> num < 15)
                .forEach(val -> System.out.println(val + " "));

        //============================================
        // 10. Use dropWhile() this method work like complementory with takeWhile() method.
        Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
                .dropWhile(num -> num < 15)
                .forEach(val -> System.out.println(val + " "));


    }

    private static boolean isPrime(int value) {
        if (value < 2)
            return false;
        return IntStream.rangeClosed(2, value / 2).noneMatch(i -> value % i == 0);
    }

    private static boolean isOlderThan15(Person person) {
        return 15 < person.getAge();
    }
}


