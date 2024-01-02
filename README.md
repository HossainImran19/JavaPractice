# Java Practice
## Contents
**Terminal Operations**: • [count()](#long-count) 

**Intermediate Operations**: • [skip()](#streamt-skiplong-n-) • [limit()](#streamt-limitlong-maxsize) • [peek()](#streamt-peekconsumer-super-t-action) • [sorted()](#streamt-sortedcomparator-super-t-comparator) • [map()](#mapfunction-super-t--extends-r-mapper) • [flatMap()](#flatmapfunction-super-t--extends-stream-extends-r-mapper) • [distinct()](#distinct) • [Design Pattern](#design-patterns)

#### long count()
```java
        // Use long count() to find out the number of elements in the stream.
        Stream.of(1, 2, 3, 4).count();
        try {
            List<String> lines = Files.readAllLines(Paths.get("/home/peripatetic/Practice/OOP/Text.txt"));

            long wordCount
                    = lines.stream()
                    .map(line -> line.split("(?<=[,.])|(?=[,.])|\\s+"))
                    .flatMap(Stream::of)
                    .count();
```
#### Stream<T\> dropWhile(Predicate<? super T> predicate)
```java
        // 10. Use dropWhile() as a complementary method to takeWhile(); 
        // it works to exclude elements based on a specified condition.
        Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
                .dropWhile(num -> num < 15)
                .forEach(val -> System.out.println(val + " "));
```
#### Stream<T\> takeWhile(Predicate<? super T> predicate)
```java
        // Use takeWhile() to halt the processing when
        // the condition specified by the predicate evaluates to false.
        Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
                .peek(val -> System.out.println("before: " + val))
                .takeWhile(num -> num < 15)
                .forEach(val -> System.out.println(val + " "));
```
#### Stream<T\> skip(long n); 
```java
        // Use skip() to process the stream 
        // while excluding the specified number of elements passed as an argument.
        IntStream.range(0, 20)
                .filter(SomeMethods::isPrime)
                .skip(5)
                .forEach(System.out::println);
```
#### Stream<T\> limit(long maxSize)
```java
        // Use limit() to restrict the output or production of a limited set of elements.
        IntStream.range(0, 1000)
                .filter(SomeMethods::isPrime)
                .limit(10)
                .forEach(System.out::println);
```
#### Stream<T\> peek(Consumer<? super T> action)
```java
        // Use peek() for debugging
        List<Person> personList
                = people
                .stream()
                .peek(person -> System.out.println("before filter: " + person.getAge() + " : " + person.getName()))
                .filter(SomeMethods::isOlderThan15)
                .peek(person -> System.out.println("after filter: " + person.getAge() + " : " + person.getName()))
                .sorted(Comparator.comparing(Person::getName))
                .toList();
```
#### Stream<T\> sorted(Comparator<? super T> comparator)
```java
        // Stream<T> sorted(Comparator<? super T> comparator) method does not modify the source;
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
        
        // In this case we are sorting Persons ascending order based on their names.
        // If names are equal then descending order based on their ages.
        people.stream()
                .sorted(Comparator.comparing(Person::getName)
                        .thenComparing(Comparator.comparing(Person::getAge).reversed())
                )
                .forEach(val -> System.out.println(val.getName() + " " + val.getAge()));
```
#### distinct()
```java
    // Stream<T> distinct() returns a stream 
    // that holds only distinct elements.
    List<Integer> numbers1 = Arrays.asList(1, 2, 3, 3, 3, 4, 5, 5, 5, 6, 9);
    numbers1.stream().distinct().forEach(System.out::println);
```
#### map(Function<? super T, ? extends R> mapper)
```java
// map(Function<? super T, ? extends R> mapper)
// is used for transforming each element of the stream one type to another.
Stream<Person> personStream
        = Stream.of(
        new Person("Imran", 16, Gender.MALE),
        new Person("Mizan", 32, Gender.MALE),
        new Person("Mihad", 3, Gender.MALE)
);

// Here by using map() method we are creating a nameStream form the personStream
// to store the names of each person.
        personStream.filter(SomeMethods::isOlderThan15)
                .map(Person::getName)
                .forEach(val -> System.out.println(val + " "));
```
#### flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
```java
        // flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
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
```
- **Overhead:** Amount of Time, Memory, Bandwidth or Resources required to do a specific task.
- Comaratively, runtime overheading of **Anonymous Inner Class** is sligthly higher than **Lamda Expression**.
- The Overheads of the Anonymous Inner class are
  1. Class loading
  2. Creation of object and allocation of memory.
  3. Object method call.
### Design Patterns
- **Singleton Pattern:** Ensures that a class has only one instance and provides a global point of access to it.
  <details>
    <summary>Example</summary>
  
    ```java
    public final class ConnectionPool {
    // This ConnectionPool class have only one instance
    // In the whole project.
    private static final ConnectionPool INSTANCE
            = new ConnectionPool();
    // Ensuring that none of other classes can't create
    // Instances directly.
    private ConnectionPool(){}

    // Only method by which we can get the instance
    // that created for the whole project.
    public static ConnectionPool getInstance() {
        return INSTANCE;
    }

    public DataSource getDataSource() {
        var dbProb = ResourceBundle.getBundle("db");

        var config = new HikariConfig();
        config.setJdbcUrl(dbProb.getString("db.url"));
        config.setUsername(dbProb.getString("db.user"));
        config.setPassword(dbProb.getString("db.password"));
        config.setDriverClassName(dbProb.getString("db.driver"));
        var maxPoolSize
                = dbProb.getString("db.max.connections");
        config.setMaximumPoolSize(Integer.parseInt(maxPoolSize));

        return new HikariDataSource(config);
        }
    }
    ```
  </details>

- **Factory Method Pattern**:  It defines an interface for creating an object, but the actual instantiation is deferred to subclasses.
  <details>
    <summary>Key Notes</summary>
  
    ```.md
  1. when should we use this pattern
   
    ```
  </details>
  <details>
    <summary>Example</summary>
  
    ```java
  // The Factory method relies heavily on interface
  // Product class served as an abstraction for different types of Documents
  interface Document {
    void open();
    void save();
  }
  // Product type of A
  class DocumentA implements Document {
    @Override
    void open() {
  
    }
    @Override
    void save() {
  
    }
  }
  // Product type of B
  class DocumentB implements Document {
    @Override
    void open() {
  
    }
    @Override
    void save() {
  
    }
  // We can add other ConcreteProducts similarly.
  // ......
  }
  
  // Creator is an abstract class with a factory method createDocument(), 
  // and some other method for some specific operations.
  // createProduct/createDocument is responsible for creating instances of the Product/Document interface.
  public abstract class DocumentCreator { 
    abstract Document createDocument();  
  } 
    ```
  </details>
- **Decorator Pattern:** Attaches additional responsibilities to an object dynamically, providing a flexible alternative to subclassing for extending functionality.
  <details>
    <summary>Example</summary>

    ```java
    public class DecoratorPattern {

    public static void main(String[] args) {
        // we can create different types of coffee
        // by combining constructors using the decorator pattern.
        var coffee = new VanillaAlmond(
                new SweetMilk(
                        new SaltedCaremelFudge(
                                new DarkCookieCrumb(
                                        new CoffeeBean()
                                )
                        )
                )
        );
        
        System.out.println(coffee.getIngredient());
    }
    @SafeVarargs
    public static Coffee getCoffeeWithExtras(Coffee coffee,
                                             Function<Coffee, Coffee>... ingregients) {
        Function<Coffee, Coffee> inital = kopi -> kopi;


        for (Function<Coffee, Coffee> ingredient : ingregients) {
            inital = inital.andThen(ingredient);
        }

        // we can write that in this way
        Function<Coffee, Coffee> reduced
                = Stream
                .of(ingregients)
                .reduce(
                        Function.identity(),
                        Function::andThen
                );


        return reduced.apply(coffee);
    }
    }

    @FunctionalInterface
    interface Coffee {
    // Method can add a property
    String getIngredient();
    }

    // Concrete class implementing Coffee
    class CoffeeBean implements Coffee {
    @Override
    public String getIngredient() {

        return "Coffee Bean";
    }
    }

    // Decorator class which have a reference of Coffee 
    abstract class CoffeeDecorator implements Coffee {
    private final Coffee coffee;

    // Initializing the coffee property.
    CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getIngredient() {
        return coffee.getIngredient();
    }
    }

    // Concrete Decorator classes
    class SaltedCaremelFudge extends CoffeeDecorator {
    SaltedCaremelFudge(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getIngredient() {
        return super.getIngredient() + " SaltedCaramelFudge";
    }
    }

    class SweetMilk extends CoffeeDecorator {
    SweetMilk(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getIngredient() {
        return super.getIngredient() + " SweetMilk";
    }
    }

    class DarkCookieCrumb extends CoffeeDecorator {
    DarkCookieCrumb(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getIngredient() {
        return super.getIngredient() + " DarkCookieCrumb";
    }
    }

    class VanillaAlmond extends CoffeeDecorator {
    VanillaAlmond(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getIngredient() {
          return super.getIngredient() + " VanilaAlmond";
      }
    }
    ```
  </details>
