# Java Practice
## Contents
• [map()](#mapfunction-super-t--extends-r-mapper) • [flatMap()](#flatmapfunction-super-t--extends-stream-extends-r-mapper) • [distinct()](#distinct) • [Design Pattern](#design-patterns)

#### distinct()
```java
    // 5. Stream<T> distinct() returns a stream 
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
